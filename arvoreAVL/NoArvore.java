package arvoreAVL;

public class NoArvore{
	public ListaSE lista;
	public NoArvore esquerda;
	public NoArvore direita;
	
	public NoArvore() {
		this.lista = new ListaSE();
		this.esquerda = null;
		this.direita = null;
	}
	
	public static void main(String[] args) {
		System.out.println("que".compareTo("estou"));
	}
}