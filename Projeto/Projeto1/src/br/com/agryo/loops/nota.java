package br.com.agryo.loops;

import java.util.Scanner;

public class nota {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nota;

        while (true){
            System.out.println("Digite uma nota de 0 a 10: ");
            nota = scan.nextInt();
            if (nota >=0 && nota <=10){
                System.out.println(("Muito bem, a nota foi: ") + nota);
                break;
            }
            else System.out.println("Nota inexistente, escolha entre 0 e 10.");
        }
        System.out.println("Continuaria daqui...");
    }
}
