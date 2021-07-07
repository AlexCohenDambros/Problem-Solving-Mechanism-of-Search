package ArvoreDeBusca;
import java.util.Random;

public class Arvore {
	public No raiz;
	public int[] lista;

	public Arvore() {
		this.raiz = null;
	}

	public void insere(int valor) {
		No novo = new No(valor);
		No p = raiz;
		No q = null;

		if (raiz == null) {
			raiz = novo;
		} else {
			while (p != null) {
				q = p;
				if (valor < p.dado) {
					p = p.esquerda;
				} else {
					p = p.direita;
				}
			}
			if (valor < q.dado) {
				q.esquerda = novo;
			} else {
				q.direita = novo;
			}
		}
	}

	public boolean verifica(int valor) {
		No p = raiz;
		No q = null;
		if (raiz == null) {
			return false;
		} else {
			while (p != null) {
				q = p;
				if (p.dado == valor) {
					return true;
				}
				if (valor < p.dado) {
					p = p.esquerda;
				} else {
					p = p.direita;
				}
			}
			return false;
		}
	}
	
	public int maior() {
		if (raiz == null) {
			return 0;
		}
		No n = raiz;
		while (n.direita != null) {
			n = n.direita;
		}
		return n.dado;
	}
	
	public int menor() {
		if (raiz == null) {
			return 0;
		}
		No n = raiz;
		while (n.esquerda != null) {
			n = n.esquerda;
		}
		return n.dado;
	}

	public void preordem(No no) {
		if (no != null) {
			System.out.println(no.dado + " ");
			preordem(no.esquerda);
			preordem(no.direita);
		}
	}
	
	public void inordem(No no) {
		if (no != null) {
			inordem(no.esquerda);
			System.out.print(no.dado + " ");
			inordem(no.direita);
		}
	}
	
	public void posordem(No no) {
		if (no != null) {
			posordem(no.esquerda);
			posordem(no.direita);
			System.out.print(no.dado + " ");
		}
	}
	
	public void array(int valor) {
		this.lista = new int[valor];
	}
	


	public static void main(String[] args) {
		Arvore a = new Arvore();
		//instância um objeto da classe Random usando o construtor padrão
        Random gerador = new Random();
        
        long tempInicial = System.currentTimeMillis();
        // fazer array   
        int valor = 20000000;
        a.array(valor);
        for (int i = 0; i < valor; i++) {
        	int y = gerador.nextInt();
        	a.lista[i] = y;
            a.insere(y);
            
        }
        long tempFinal = System.currentTimeMillis();
		long dif1 = (tempFinal - tempInicial);
		System.out.println(String.format("Tempo final insere: "+"%02d segundos", dif1/1000));
		
        //busca elemento
        long tempInicial1 = System.currentTimeMillis();
		for (int x = 0; x<a.lista.length;x++) {
			a.verifica(a.lista[x]);
		}
		long tempFinal1 = System.currentTimeMillis();
		long dif = (tempFinal1 - tempInicial1);
		
		System.out.println(String.format("Tempo final verifica: "+"%02d segundos", dif/1000));
	}
}