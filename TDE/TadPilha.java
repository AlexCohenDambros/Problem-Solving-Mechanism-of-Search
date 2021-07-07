package TDE;

import java.util.Scanner;

public class TadPilha {
	// VARIAVEIS 
	public int dados[]; // VETOR
	private int topo;
	public int max;	
	
	//CONSTRUTOR, INICIALIZAÇÃO DOS ATRIBUTOS
	public TadPilha(int tam) {
		this.max = tam;
		this.dados = new int[tam];
		this.topo = -1;
	}
	
	//VERIFICAR SE A LISTA ESTA CHEIA
	public boolean cheia() {
		return (topo == max-1);
	}
	//VERIFICAR SE A LISTA ESTA VAZIA
	public boolean vazia() {
		return (topo == -1);
	}
	
	//EMPILHAR OS VALORES NA PILHA
	public boolean empilhar(int x) {
		if (cheia()) {
			System.out.println("Pilha Cheia!");
			return false;
		}
		this.dados[++topo] = x;
		return true;
	}
	// DESEMPILHAR
	public int desempilhar() {
		if (vazia()) {
			System.out.println("Pilha Vazia!");
		}
		int x = dados[topo];
		topo--;
		return x;
		
	}
	
	public int retornaTopo() {
		if (vazia()) {
			return 0;
		}
		return dados[topo];
		
	}
	
	//CRIAR UMA PILHA
	public static TadPilha cria_pilha(int n) {
		TadPilha p = new TadPilha(n);
		return p;
	}
	
	public static void main(String args[]) {
		int n;
		Scanner ler = new Scanner(System.in);
		System.out.println("Informe o tamanho da pilha: ");
		n = ler.nextInt();
		System.out.println("O tamanho da Pilha é de: " + n + " elementos");
		
		TadPilha p = new TadPilha(n);
		p.empilhar(6); 
		p.empilhar(12); 
		p.empilhar(1);
		
		int x = p.desempilhar();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("O valor desempilhado foi de: " + x);
		System.out.println("O valor do topo é: " + p.retornaTopo());
		
	}

}