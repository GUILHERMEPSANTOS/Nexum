package com.nexum.backend.services.admin;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.domain.endereco.EnderecoEntity;

import com.nexum.backend.infra.files.helperFile.CSVhelper;

import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.admin.interfaces.AdminServicePort;
import org.springframework.core.io.InputStreamResource;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AdminService implements AdminServicePort {
    private SpringUserRepository springUserRepository;

    public AdminService(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Override
    public InputStreamResource load() {
        ByteArrayInputStream in = CSVhelper.userToCSV(springUserRepository.findAll());
        return new InputStreamResource(in);
    }

    public void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        // try-catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
        }

        // try-catch para gravar e fechar o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
        }
    }

    public void gravaArquivoTxt(Collection<UserEntity> lista, String nomeArq) {
        int contaRegDados = 0;

        // Monta o registro de header
        String header = "00NEXUM20222";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";
        // Grava o registro de header
        gravaRegistro(header, nomeArq);

        // Monta e grava os registros de corpo
        String corpo;
        for (UserEntity userEntity : lista) {
            corpo = "02";
            corpo += String.format("%-45.45s", userEntity.getNome());
            corpo += String.format("%10.10s", userEntity.getSenha());
            corpo += String.format("%-22.22s", userEntity.getEmail());
            corpo += String.format("%12.12s", userEntity.getCelular());
            corpo += String.format("%-500.500s", userEntity.getSobre());
            // valor numérico não se coloca o -, para alinhar para a direita
            // e é recomendável preencher o valor com zeros à esquerda
            contaRegDados++;
            gravaRegistro(corpo, nomeArq);
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegDados);
        gravaRegistro(trailer, nomeArq);
    }

    public void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, senha, email, celular, sobre, cidade, estado;
        Integer contaRegDadoLido = 0;
        Integer qtdRegDadoGravadoTrailer;

        // Cria uma lista com os dados lidos do arquivo
        List<FreelancerEntity> listaLida = new ArrayList();

        // try-catch para abrir o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo!");
            erro.printStackTrace();
        }

        // try-catch para ler e fechar o arquivo
        try {
            registro = entrada.readLine(); // Lê o 1o registro

            while (registro != null) {
                // enquanto não chegou ao final do arquivo
                // obtém os 2 primeiros caracteres do registro
                // 01234567890
                // 00NOTA20222
                // substring - 1o argumento é o índice de onde quero obter
                // substring - 2o argumento é o índice de até onde quero + 1
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("Registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 6));
                    System.out.println("Ano e semestre: " + registro.substring(6, 11));
                    System.out.println("Data e hora de gravação: " + registro.substring(11, 30));
                    System.out.println("Versão do documento: " + registro.substring(30, 32));

                } else if (tipoRegistro.equals("01")) {
                    System.out.println("Registro de trailer");
                    qtdRegDadoGravadoTrailer = Integer.valueOf(registro.substring(2, 12));
                    if (contaRegDadoLido == qtdRegDadoGravadoTrailer) {
                        System.out.println("Quantidade de registros lidos compatível com " +
                                "quantidade de registros gravados");
                    } else {
                        System.out.println("Quantidade de registros lidos incompatível com " +
                                "quantidade de registros gravados");
                    }
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("Registro de corpo");
                    nome = registro.substring(2, 47).trim();
                    senha = registro.substring(47, 57).trim();
                    email = registro.substring(57, 79).trim();
                    celular = registro.substring(79, 91).trim();
                    sobre = registro.substring(91, 591).trim();
                    cidade = registro.substring(591, 603).trim();
                    estado = registro.substring(603, 617).trim();

                    // Incrementa o contador de registros lidos
                    contaRegDadoLido++;

                    UserEntity userEntity = new UserEntity(celular, email, nome, senha, sobre);
                    userEntity = new UserEntity(new EnderecoEntity(cidade, estado).getId_endereco());

                    springUserRepository.save(userEntity);
                } else {
                    System.out.println("Tipo de registro inválido!");
                }
                // Lê o próximo registro
                registro = entrada.readLine();
            }
            entrada.close();
        } catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo");
            erro.printStackTrace();
        }

        // Exibe o conteúdo da lista lida
        System.out.println("Conteúdo da lista lida do arquivo");
        for (UserEntity user : listaLida) {
            System.out.println(user);
        }
    }

    public Collection<UserEntity> listAll() {
        return springUserRepository.findAll();

    }

    @Override
    public Integer countNumberFreelancers() {
        return null;
    }

    @Override
    public Integer countNumberContratantes() {
        return null;
    }
}
