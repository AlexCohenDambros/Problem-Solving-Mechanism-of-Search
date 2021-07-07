package ArvoreDeBusca;

public class No {
    public int dado;
    public No esquerda;
    public No direita;
    
    public No(int valor) {
        this.dado = valor;
        this.esquerda = null;
        this.direita = null;
    }
}
