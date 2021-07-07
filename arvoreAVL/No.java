package arvoreAVL;

public class No {
    public String palavra;
    public String nomeArquivo;
    public int freq;
    public No proximo;
    
    public No(String palavra, int freq, String nomeArquivo) {
        this.palavra = palavra;
        this.nomeArquivo = nomeArquivo;
        this.proximo = null;
        this.freq = freq;
    }
}