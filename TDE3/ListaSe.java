package TDE3;
import AulaPilha.Pilha;
import ListaEncadeada.No;

public class ListaSe {
	public No primeiro;
	public No ultimo;
	
	public ListaSe() {
		this.primeiro = null;
		this.ultimo = null;
	}
	
	public boolean vazia() {
		return(this.primeiro == null);
	}
	
	public void inserePrimeiro(int elemento) {
		No p = new No(elemento); // Criar um novo No com o elemento passado como parametro
		if(vazia()) { 
			this.primeiro = p;
			this.ultimo = p;  // Se a lista estiver vazia o primeiro sera igual o ultimo, porque ele sera o unico elemento presente na lista
		} else {
			p.proximo = this.primeiro; // o proximo de P passar a ser o primeiro antigo
			this.primeiro = p; // o primeiro vira o p passado como parametro.
		}
	}
	
	public void insereDepois(No no, int elemento) { // Insere depois do NO, um novo elemento
		if(!vazia()) { 
			No x = new No(elemento);
			if (no.proximo == null) { // caso eu tenha passado o ultimo como parametro 
				ultimo = x;  // o proximo do ultimo, passaria a ser o X, virando o novo ultimo   
			}
			x.proximo = no.proximo; // o X pega o proximo do No passado como parametro, exemplo 3 5 6, passo 3 e 4, o proximo do 3 é 5, que vira o novo proximo de 4
			no.proximo = x; // E o proximo do No passado como parametro vira o X inserido. No caso do exemplo o proximo do 3 vira o 4.
		}
	}
	
	public void insereUltimo(int elemento) {
		if(vazia()) {
			inserePrimeiro(elemento); // Se o no esta vazio ele insere no um elemento na primeira posição
		} else {
			No p = new No(elemento); // Criar um novo No com o elemento
			this.ultimo.proximo = p; // o proximo do ultimo passar a ser o novo No
			this.ultimo = p; // o ultimo passsar a ser o P
		}
	}
	
	public void insereOrdenado(int elemento) {
		if(vazia() || elemento <= primeiro.getDado()) {
			inserePrimeiro(elemento);
		} else if(elemento >= ultimo.getDado()) {
			insereUltimo(elemento);
		} else {
			No x = primeiro; 
			No y = null; // guardar o valor de X
			while(elemento > x.dado) { 
				y = x; // anterior
				x = x.proximo;  // proximo 
			}
			No p = new No(elemento); // Criar um novo No com o elemento
			p.proximo = x; // proximo de P vira o (X)
			y.proximo = p; // O proximo do (y), o anterior, vira P em vez do X
		}
	}
	
	public void mostraLista(){
		if(!vazia()) {
			System.out.print("[");
	        No x = primeiro;
	        while(x.proximo!=null){
	            System.out.print(x.dado + ",");
	            x = x.proximo;
	        }
	        System.out.print(x.dado + "]");
	        System.out.println("\nHeader = [" + primeiro.dado + "," + ultimo.dado   +"]");
		}
		else {
			System.out.println("Lista vazia.");
		}
    }
	
	public int retiraPrimeiro(){
		if (vazia()){ 
			System.out.println("Lista Vazia");
			return 0;
		}
		int n = primeiro.dado;
		if (this.primeiro == this.ultimo){
			primeiro = null;
			ultimo = null;
		}
		else{
			primeiro = this.primeiro.proximo; // RETIRAR O PRIMEIRO E TRANSFORMAR O PROXIMO DO ANTIGO PRIMEIRO EM PRIMEIRO
		}
		return n;
	}
	
	public int retiraUltimo(){
		No p = primeiro;
		while (p.proximo!=ultimo){ // chegar até penultimo
			p = p.proximo;
		}
		int n = ultimo.dado;
		ultimo = p; // o penultimo vira o ultimo
		ultimo.proximo = null; // proximo do ultimo é null
		return n;
	}
	
	public int retiraDepois(No no) {  // Passar o numero como parametro para retirar o elemento q esta depois do nó
		if(vazia() || no == ultimo) { // se o no for o ultimo n tem o que retirar
			return 0;
		}
		
		if (no.proximo == ultimo) {  // verificar se o proximo é igual ao ultimo
			ultimo = no;  //retira o ultimo antigo e transforma e o No passa a ser o ultimo, um exemplo é tenho 3 e 4 e passo o no 3 como parametro, o proximo é igual a 4 no qual é o ultimo
		} //  retira o 4 e o 3 passa a ser o novo ultimo
		
		int x = no.proximo.dado;  // em um exemplo de 1, 2, 3, 4 e 5, onde o no passado como parametro é igual a 3, então o proximo de 3 é 4 
		no.proximo = no.proximo.proximo; // logo sera retirado o 4, onde o no.proximo(3) recebe o no.proximo.proximo (5)
		return x;
	}
	
	public int ultimo_elemento()
	{
		return ultimo.dado;
	}
	
	public int soma(No p) { // soma dos elementos do no
		if(p ==null) {
			return 0;
		}
		else {
			return p.dado + soma(p.proximo);
		}
	}
	
	// RECUSIVIDADE VERIFICAR SE O ELEMENTO ESTA INSERIDO NO NÓ
	public boolean verifica(int x, No p) { 
		if(p == null) {
			return false;
		}else if (x == p.dado) {
			return true;
		}else {
			return(verifica(x, p.proximo));
		}
	}
	
	// RECURSIVIDADE CONTAGEM  DE ELEMENTOS
	public int contagem(No p) { 
		if(p == null) {
			return 0;
		}
		else {
			return 1 + contagem(p.proximo);
		}
	}
	
	// RECURSIVIDADE PASSAR A POSIÇÃO DO ELEMENTO E RETORNAR ELE 
	public int retorna(int x, No p,int y) { //x, posição passada como parametro,  y contagem/contador
		y+= 1;
		if (p == null) {
			return 0;
		} else if(x == y) {
			return p.dado;
		} else {
			return retorna(x,p.proximo,y);
		}
	}
	
	public double similaridade(ListaSe l1, ListaSe l2) {
		double x = 0; // Somatorias
		double y = 0;
		double z = 0;
		for (int i = 1;i <= l1.contagem(l1.primeiro);i++) {
			x += l1.retorna(i, l1.primeiro, 0) * l2.retorna(i, l2.primeiro, 0); // primeiro da l1, com o primeiro da l2
			y += l1.retorna(i, l1.primeiro, 0) * l1.retorna(i, l1.primeiro, 0); // primeiro da l1 com ele mesmo, isso é pra levar ele ao quadradado
			z += l2.retorna(i, l2.primeiro, 0) * l2.retorna(i, l2.primeiro, 0);
		}
		return  x / Math.sqrt(y*z);
	}
	
	public ListaSe intersecao(ListaSe l1, ListaSe l2) {
		ListaSe listaFinal = new ListaSe(); //criando uma nova lista
		for(int i = 1;i <= l1.contagem(l1.primeiro);i++) { // esses for serve pra pergar as posições das duas listas
			for(int x = 1;x <= l2.contagem(l2.primeiro);x++) {
				if(l1.retorna(i, l1.primeiro, 0) == l2.retorna(x, l2.primeiro, 0)) { // primeiro com o primeiro, primeiro com o segundo, se sao iguais
					if(!listaFinal.verifica(l1.retorna(i, l1.primeiro, 0), listaFinal.primeiro)) { // Vai verificar se o elemento já esta Lista final
						listaFinal.insereOrdenado(l1.retorna(i, l1.primeiro, 0)); // Se o elemento ja estiver inserido, não sera duplicado. 
					} // se tiver um repetido ele nao adiciona novamente
				}
			}
		}
		return listaFinal;
	}
	
	public ListaSe inverte(ListaSe l1) {
        ListaSe listaFinal = new ListaSe();
        Pilha p = new Pilha(l1.contagem(l1.primeiro));
        
        No x = l1.primeiro;
        for(int i = 0; i < l1.contagem(l1.primeiro); i++) {
            p.empilhar(x.dado);
            x = x.proximo;
        }
        while(!p.vazia()) {
            listaFinal.insereUltimo(p.desempilhar());
        }
        return listaFinal;
    }
	
	public ListaSe inverte2(ListaSe l1,ListaSe listaFinal, No x,Pilha p) {
        if(x != null) {
            p.empilhar(x.dado);
            return inverte2(l1,listaFinal,x.proximo,p);
        }
        
        if(listaFinal.contagem(listaFinal.primeiro) != p.max) {
            listaFinal.insereUltimo(p.desempilhar());
            return inverte2(l1,listaFinal,x,p);
        }
        
        if (p.vazia()) {
            return listaFinal;
        }
        
        return inverte2(l1,listaFinal,x.proximo,p);
    }
	
	
	public static void main(String[] args) {
		ListaSe l = new ListaSe();
		ListaSe l1 = new ListaSe();
		l.insereUltimo(5);
		l.insereUltimo(40);
		l.insereUltimo(20);
		l.insereUltimo(17);
		//l.insereDepois(l.primeiro.proximo, 0);
		//l.insereDepois(l.primeiro, 6);
		//l1.insereOrdenado(3);
		//l1.insereOrdenado(5);
		ListaSe l2 = l.inverte2(l, new ListaSe(), l.primeiro, new Pilha(l.contagem(l.primeiro)));
		l2.mostraLista();
		//System.out.println("Verificar numero: " + l.verifica(80, l.primeiro));
		//System.out.println("Contagem: " + l.contagem(l.primeiro));
		//System.out.println("Valor armazenado na posição: " + l.retorna(1, l.primeiro, 0));
		//l.intersecao(l1,l).mostraLista();;
		
	}
}
