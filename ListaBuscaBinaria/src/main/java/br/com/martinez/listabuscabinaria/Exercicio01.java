
package br.com.martinez.listabuscabinaria;

import java.util.Random;
import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {
        
        Random random = new Random();
        
        int[] x = new int[200];
        for(int i=0; i<x.length; i++) {
            x[i] = random.nextInt(200);
            System.out.println(x[i]);
        }
        
        int buscando = -1;
        Scanner sc = new Scanner(System.in);
        
        while(buscando != 0) {
            System.out.println("Informe um número para ser pesquisado entre 0 a 200(0 = Sair): ");
            buscando = sc.nextInt();

            quickSort(x,0,x.length-1);
            
            buscaBinaria(x, 0, x.length-1, buscando);
            
            System.out.println(verificaNumero(x, buscando));
        }
       
    }
    
    private static String verificaNumero(int x[], int buscando) {
        
        String retorno = "\nNúmero " + buscando + " não encontrado!\n";
        for(int i=0; i<x.length && buscando>=x[i]; i++) {
            if(x[i] == buscando) {
                retorno = "\nNúmero " + buscando + " encontrado na posição: " + i + "!\n";
                break;
            }
        }
        return retorno;
        
    }
    
    static boolean buscaBinaria(int[] x, int inicio, int fim, int buscando) {
        
        boolean achou = false;
        int meio = (inicio + fim) / 2;
        
        while (inicio <= fim && !achou) {
            if(buscando == x[meio]) {
                achou = true;
            }else {
                if(buscando <= x[meio]) {
                    fim = meio - 1;
                    meio = (inicio + fim) / 2;
                }else {
                    inicio = meio + 1;
                    meio = (inicio + fim) / 2;
                }
            }
        }
        return achou;
        
    }
    
    static void quickSort(int[] vetor, int esquerda, int direita) {
        
        if(esquerda < direita){
            int p = particao(vetor, esquerda, direita);
            quickSort(vetor, esquerda, p);
            quickSort(vetor, p + 1, direita);
        }
        
    }

    static int particao(int[] vetor, int esquerda, int direita) {
        
        int meio = (int) (esquerda + direita) / 2;
        int pivot = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;
        
        while(true){
            do {
                i++;
            } while(vetor[i] < pivot);
            do {
                j--;
            } while(vetor[j] > pivot);
            if (i >= j){
                return j;
            }
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
        
    }
    
}
