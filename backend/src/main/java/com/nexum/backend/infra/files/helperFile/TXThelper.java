package com.nexum.backend.infra.files.helperFile;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.dto.shared.UserDTO;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TXThelper {
    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
        }
    }

    public static void gravaArquivoTxt(List<UserEntity> lista, String nomeArq){
        int contaRegDados =0;

        String header = "00NOTA20222";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        gravaRegistro(header,nomeArq);

        String corpo;
        for(UserEntity userEntity : lista){
            corpo = "02";
            corpo += String.format("%-50.50s",userEntity.getNome());
            corpo += String.format("%-40.40s",userEntity.getCelular());
            corpo += String.format("%-40.40s",userEntity.getEmail());
            contaRegDados++;
            gravaRegistro(corpo,nomeArq);
        }
        String trailer = "01";
        trailer += String.format("%010d", contaRegDados);
        gravaRegistro(trailer,nomeArq);
    }

    public static void leArquivoTxt(String nomeArq){
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, email, celular;
        Integer contaRegDadoLido = 0;
        Integer qtdRegDadoGravadoTrailer;

        List<UserEntity> listaLida = new ArrayList<>();

        try{
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo!");
            erro.printStackTrace();
        }
        try{
            registro = entrada.readLine();
            while (registro !=null){
                tipoRegistro = registro.substring(0,2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("Registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2,6));
                    System.out.println("Ano e semestre: " + registro.substring(6,11));
                    System.out.println("Data e hora de gravação: " + registro.substring(11,30));
                    System.out.println("Versão do documento: " + registro.substring(30,32));
                }else if (tipoRegistro.equals("01")) {
                    System.out.println("Registro de trailer");
                    qtdRegDadoGravadoTrailer = Integer.valueOf(registro.substring(2, 12));
                    if (contaRegDadoLido == qtdRegDadoGravadoTrailer) {
                        System.out.println("Quantidade de registros lidos compatível com " +
                                "quantidade de registros gravados");
                    }
                    else {
                        System.out.println("Quantidade de registros lidos incompatível com " +
                                "quantidade de registros gravados");
                    }
                }else if (tipoRegistro.equals("02")) {
                    System.out.println("Registro de corpo");
                    nome = registro.substring(2, 45).trim();
                    email = registro.substring(45, 85).trim();
                    celular =registro.substring(85,100).trim();

                    contaRegDadoLido++;

                    UserEntity a = new UserEntity(nome, email, celular);

                    listaLida.add(a);
                }
                else {
                    System.out.println("Tipo de registro inválido!");
                }
                // Lê o próximo registro
                registro = entrada.readLine();
            }
            entrada.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo");
            erro.printStackTrace();
        }

        // Exibe o conteúdo da lista lida
        System.out.println("Conteúdo da lista lida do arquivo");
        for (UserEntity userEntity : listaLida) {
            System.out.println(userEntity);
        }
            }
    public static void main(String[] args) {
        List<UserEntity> lista = new ArrayList();
        lista.add(new UserEntity("caiu","caiu@gmail.com","11966761630"));
        gravaArquivoTxt(lista, "Nexum.txt");
        leArquivoTxt("Nexum.txt");

    }
        }
