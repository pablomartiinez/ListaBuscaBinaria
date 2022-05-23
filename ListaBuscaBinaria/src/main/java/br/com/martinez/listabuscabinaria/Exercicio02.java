
package br.com.martinez.listabuscabinaria;

import java.util.Random;
import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {
        
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        
        int[] x = new int[2000];
        for(int i=0; i<x.length; i++) {
            x[i] = random.nextInt(2000);
        }
        
        boolean[] achou = new boolean[2000];
        
        int[] y = new int[6];
        for(int j=0; j<y.length; j++) {
            System.out.println("Digite o " + (j+1) + "º número:");
            y[j] = sc.nextInt();
        }        

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2000; j++) {
                if(x[j] == y[i]) {
                    achou[j] = true;
                    System.out.println("O número " + y[i] + " foi encontrado na posição " + (j+1) + "!");
                    break;
                }
            }   
        }
    
    }
    
}