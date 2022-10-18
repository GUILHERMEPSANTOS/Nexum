package com.nexum.backend.controller.controle.acesso;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.repositories.controle.acesso.SpringUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListObj <T> {

    private T[] vetor;

    private int nmrElem;

    public ListObj(int tamanho) {
        vetor = (T[]) new String[tamanho];
        nmrElem = 0;
    }

    public void adiciona(T elemento) {
        if (nmrElem >= vetor.length) {
            throw new IllegalStateException();
        } else {
            vetor[nmrElem++] = elemento;
        }
    }

    public int busca(T elementoBuscado) {
        for (int i = 0; i < nmrElem; i++) {
            if (vetor[i].equals(elementoBuscado)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        if (indice < 0 || indice >= nmrElem) {
            System.out.println("\nÍndice inválido!");
            return false;
        }
        for (int i = indice; i < nmrElem - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        nmrElem--;
        return true;
    }

    public boolean removeElemento(T elementoARemover) {
        return removePeloIndice(busca(elementoARemover));
    }

    public int getTamanho() {
        return nmrElem;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= nmrElem) {
            return null;
        } else {
            return vetor[indice];
        }
    }

    public void limpa() {
        nmrElem = 0;
    }

    public void exibe() {
        if (nmrElem == 0) {
            System.out.println("\nA lista está vazia.");
        } else {
            System.out.println("\nElementos da lista:");
            for (int i = 0; i < nmrElem; i++) {
                System.out.println(vetor[i]);
            }
        }
    }

    public T[] getVetor() {
        return vetor;
    }


    public ListObj<String> selectionSort(ListObj<String> arrayNomes) {
//        int n = desordenadaLista.size();
//        String arrayNomes[] = desordenadaLista.toArray(new String[desordenadaLista.size()]);
        String aux = "";
        for (int i = 0; i < arrayNomes.getTamanho(); i++) {
            for (int j = 0; j < arrayNomes.getTamanho(); j++) {
                String nome1 = arrayNomes.getElemento(i);
                String nome2 = arrayNomes.getElemento(j);
                String primeiraLetra = String.valueOf(nome1.charAt(0));
                String segundaLetra = String.valueOf(nome2.charAt(0));
                if(primeiraLetra.compareTo(segundaLetra) < 0){
                    aux = arrayNomes.getVetor()[i];
                    arrayNomes.getVetor()[i] = arrayNomes.getVetor()[j];
                    arrayNomes.getVetor()[j] = aux;
                }
            }
        }
return arrayNomes;
    }
}

