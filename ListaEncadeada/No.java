package ListaEncadeada;

public class No {
	public int dado;
	public No proximo;
	
	
	public No(int valor) {
		this.dado = valor;
		this.proximo = null;
	}

	public int getDado() {
		return dado;
	}
}
