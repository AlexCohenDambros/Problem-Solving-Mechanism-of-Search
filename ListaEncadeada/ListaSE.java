package ListaEncadeada;

/**
1) O que � uma lista encadeada?

Uma lista encadeada � uma representa��oo de uma sequencia de valores, do mesmo tipo, no qual ser�o armazenados na mem�ria.
Cada elemento � armazenado em uma celula, o primeiro elemento na primeira c�lula, o segundo na segunda, e assim por diante.
 
2) Como o encadeamento de elementos � realizado em uma lista encadeada?

Cada elemento receber o seu valor e o proximo No

3) Quais as diferen�as entre uma lista encadeada com e sem descritor (header)?

Uma lista com descritor, permite realizar opera��es utilizando o primeiro e o ultimo, no qual ja ser�o instenciados.

4) Elabore um m�todo JAVA que imprime todos os elementos de uma Lista Simplesmente Encadeada com descritor.
5) Elabore m�todo JAVA que insere um elemento de forma ordenada em uma Lista Simplesmente Encadeada com descritor considerando as 4 situa��es:
a) lista esta vazia
b) elemento � menor que o primeiro
c) elemento � maior que o �ltimo
d) elemento � intermedi�rio

**/


public class ListaSE {
	public No primeiro;
	public No ultimo;
	
	public ListaSE() {
		this.primeiro = null;
		this.ultimo = null;
	}
	
	public boolean listaVazia() {
		return(this.primeiro == null);
	}
	
	public void inserePrimeiro(int elemento) {
		No p = new No(elemento);
		if(listaVazia()) {
			this.primeiro = p;
			this.ultimo = p;
		}
		else {
			p.proximo = this.primeiro;
			this.primeiro = p;
		}
	}
	
	public void insereUltimo(int elemento) {
		if(listaVazia()) {
			inserePrimeiro(elemento);
		}
		else {
			No p = new No(elemento);
			this.ultimo.proximo = p;
			this.ultimo = p;
			
		}
		
	}
	public void insereOrdenado(int elemento) {
        if(listaVazia() || elemento <= primeiro.getDado()) {
            inserePrimeiro(elemento);
        } else if(elemento >= ultimo.getDado()) {
            insereUltimo(elemento);
        } else {
            No x = primeiro;
            No y = ultimo;
            while(elemento > x.dado) {
                y = x;
                x = x.proximo;
            }
            No p = new No(elemento);
            p.proximo = x;
            y.proximo = p;
        }
    }
	
	public void imprimirElemen()
    {
		
        No p = primeiro;
        System.out.print("Lista Ordenada: ");
        while(p.proximo!=null)
        {
            System.out.print(p.dado + ",");
            p = p.proximo;
        }
        System.out.println(p.dado);
        System.out.println("Descritor(primeiro) = (" + primeiro.dado + ")");
        System.out.println("Descritor(ultimo) = (" + ultimo.dado   + ")");
    }
	
	// RECUSIVIDADE VERIFICAR SE O ELEMENTO ESTA INSERIDO
	public boolean verificar(No p, int x) {
		if(p==null) {
			return false;
		}
		else if(p.dado == x){
			return true;
		}
		else {
			return(verificar(p.proximo, x));
		}
	}
	
	// RECURSIVIDADE CONTAGEM  DE ELEMENTOS
	public double contagem(No p, double c) {
		if(p==null) {
			return c;
		} else {
			return contagem(p.proximo, c + 1);
		}
	}
	
	// RECURSIVIDADE PASSAR A POSI��O DO ELEMENTO E RETORNAR ELE 
	
	public int retornar(No p, int x, int y) {
		y+=1;
		
		if (p==null) {
			return 0;
		}
		else if (x == y) {
			return p.dado;
		}
		else {
			return retornar(p.proximo, x, y);
		}
	}
	
	
	public static void main(String[] args) {
		ListaSE A = new ListaSE();
		A.inserePrimeiro(1);
		A.insereOrdenado(2);
		A.insereOrdenado(3);
		A.insereUltimo(9);
		A.insereOrdenado(4);
		A.imprimirElemen();
		System.out.println("Verificar numero: " + A.verificar(A.primeiro, 80));
		System.out.println("Contagem: " + A.contagem(A.primeiro, 0));
		System.out.println("Valor armazenado na posi��o: " + A.retornar(A.primeiro, 3, 0));

	}
}
