package Atividade1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exercicio2 {
	public static void main(String[] args) {
		int Moda[] = {2, 0, 1, 4, 2};
		float saida[] = {};
		
		Map<Float, Integer> frequenciaNumeros = new HashMap<>();
		
		int maiorFrequencia = 0;
		
		for (float numero : Moda) {
			// Verificar se o n�mero j� est� na lista
			Integer quantidade = frequenciaNumeros.get(numero);
			
			
			// Lista de n�meros
			if (quantidade == null) {
				quantidade = 1;
			}  else {
				quantidade += 1;
			}
			
			frequenciaNumeros.put(numero, quantidade);
			
			if (maiorFrequencia < quantidade) {
				maiorFrequencia = quantidade;
			}
		}
		
		System.out.print("A(s) moda(s) � (s�o) : ");
		
		for (Float numeroChave : frequenciaNumeros.keySet()) {
			
			int quantidade = frequenciaNumeros.get(numeroChave);
			
			if (maiorFrequencia == quantidade) {
				System.out.print(numeroChave + " ");
				saida = Arrays.copyOf(saida, saida.length + 1);
		        saida[saida.length - 1] = numeroChave;
			}
		
		}
		System.out.println();
		
		if(saida.length != 1) {
			System.out.println("N�o Existe Moda �nica!!");
		} else {
			System.out.println("Moda �nica!");
		}
	}
}