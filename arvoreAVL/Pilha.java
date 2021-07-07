package arvoreAVL;

public class Pilha {
    public NoArvore[] nos;
    private int topo;
    public int max;

    public Pilha(int tam) {
        this.max = tam;
        this.nos = new NoArvore[tam];
        this.topo = -1;
    }

    public boolean cheia() {
        return (topo == max-1);
    }
    public boolean vazia() {
        return (topo == -1);
    }
    
    public boolean empilhar(NoArvore x) {
        if (cheia()) {
            return false;
        }
        topo ++;
        nos[topo] = x;
        return true;
    }
    
    public void desempilhar() {
        if (!vazia()) {
            topo --;
        }
    }
    
    public NoArvore topo() {
        if (vazia()) {
            return null;
        }
        return nos[topo];
    }
}