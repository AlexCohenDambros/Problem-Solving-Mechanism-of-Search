
public class NoArvore{
    public int dado;
    public NoArvore esquerda;
    public NoArvore direita;
    
    public NoArvore(int dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }
}