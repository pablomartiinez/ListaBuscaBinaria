
package br.com.martinez.listabuscabinaria;

import java.util.Scanner;

public class Exercicio04 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int buscando = -1;
        int[] ra = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,
                    35,36,37,38,39,40};
        String[] nome = {"Miguel", "Davi", "Gabriel", "Arthur", "Lucas", "Matheus", "Pedro", "Guilherme", "Gustavo",
                         "Rafael", "Felipe", "Bernardo", "Enzo, Nicolas", "João Pedro", "Pedro Henrique", "Cauã",
                         "Vitor", "Eduardo", "Daniel", "Henrique", "Murilo", "Vinicius", "Samuel", "Pietro",
                         "João Vitor", "Leonardo", "Caio", "Heitor", "Lorenzo", "Isaac", "Lucca", "Thiago", 
                         "João Gabriel", "João", "Theo", "Bruno", "Bryan", "Carlos Eduardo", "Luiz Felipe"};
        
        while(buscando != 0) {
            System.out.println("Informe o RA do aluno para encontrar o nome: (0 = Sair):\n");
            buscando = sc.nextInt();
            
            quickSort(ra,0,ra.length-1);
            
            buscaBinaria(ra, 0, ra.length-1, buscando);
            
            System.out.println(verificaNumero(ra, nome, buscando) + "\n");
        }
        
    }
    
    private static String verificaNumero(int ra[], String nome[], int buscando) {
        
        String retorno = "\nO RA " + buscando + " não foi encontrado!\n";
        for(int i=0; i<ra.length && buscando>=ra[i]; i++) {
            if(ra[i] == buscando) {
                retorno = "\nRA: " + ra[i] + "\nNome: " + nome[i];
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