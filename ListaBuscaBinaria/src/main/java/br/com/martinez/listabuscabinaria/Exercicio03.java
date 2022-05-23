
package br.com.martinez.listabuscabinaria;
import java.util.Scanner;

public class Exercicio03 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int[] y = {1,2,6,8,11,12,13,14,16,17,19,20,22,23,24};
        int[] x = new int[15];
        
        System.out.println("Digite os números jogados por você na Loto-Facil:");
        for(int i=0; i<x.length; i++) {
            x[i] = sc.nextInt();
        }
        
        verificaAcertos(x, y);
        
    }
    
    static void verificaAcertos(int[] x, int[] y) {
        
        int[] z = new int[15];
        int total;
        
        for(int i=0; i<y.length; i++) {
            if(y[i] == x[i]) {
                z[i] = 1;
            } else  {
                z[i] = 0;
            }
        }
        
        total = z[0] + z[1] + z[2] + z[3] + z[4] + z[5] + z[6] + z[7] + z[8] + z[9] + z[10] + z[11] + z[12] 
                + z[13] + z[14];
        
        switch(total) {
            case 11:
                System.out.println("Você teve 11 acertos e ganhou R$ 5,00");
                break;
            case 12:
                System.out.println("Você teve 12 acertos e ganhou R$ 10,00");
                break;
            case 13:
                System.out.println("Você teve 13 acertos e ganhou R$ 25,00");
                break;
            case 14:
                System.out.println("Você teve 14 acertos e ganhou R$ 2.030,40");
                break;
            case 15:
                System.out.println("Você teve 15 acertos e ganhou R$ 890.879,07");
                break;
            default:
                System.out.println("Você teve " + total + " acertos e não ganhou nada!");
        }
        
    }
    
}