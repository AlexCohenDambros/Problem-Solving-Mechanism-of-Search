package AulaPilha;

public class Pilha {
	public int[] dados;
	private int topo;
	public int max;	
	
	public Pilha(int tam) {
		this.max = tam;
		this.dados = new int[tam];
		this.topo = -1;
	}
	
	public boolean cheia() {
		return (topo == max-1);
	}
	public boolean vazia() {
		return (topo == -1);
	}
	
	public boolean empilhar(int x) {
		if (cheia()) {
			System.out.println("Pilha Cheia!");
			return false;
		}
		this.dados[++topo] = x;
		return true;
	}
	
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
			System.out.println("Pilha Vazia!");
			return 0;
		}
		return dados[topo];
		
	}
	
	public static void main(String args[]) {
		Pilha p = new Pilha(3);
		p.empilhar(6);
		p.empilhar(12);
		p.empilhar(1);
		int x = p.desempilhar();
		System.out.println("O valor desempilhado foi de: " + x);
		System.out.println("O valor do topo é: " + p.retornaTopo());
		
	}

}
