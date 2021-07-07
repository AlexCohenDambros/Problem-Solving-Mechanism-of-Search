package Atividade1;

import java.util.Scanner;

public class Exercicio1 {
	public static void main(String[] args) {
		 
		 Scanner ler = new Scanner(System.in);
		 
		 int n; // tamanho do vetor 
		 
		 System.out.println("Informe o tamanho da array: ");
		 n = ler.nextInt();
		 
		 
	     int vetor[] = new int[n];
	     int i;
	     float soma = 0;
	     float media;
	 
	     System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	     System.out.println("               Média de Vetores");
	 
	 
	     for (i = 0; i<vetor.length; i++){
	    	 System.out.println("Informe o " + (i + 1) + "º numero inteiro:");
	         vetor[i] = ler.nextInt();
	         soma = soma + vetor[i];
	     }
	 
	     media = soma/vetor.length;
	 
	     System.out.println("Resultado: " + media);
	 
	     
	}
	 
}