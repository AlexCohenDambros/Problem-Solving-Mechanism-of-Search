package arvoreAVL;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Contador_Palavras {
	public Arvore teste(File f) throws FileNotFoundException { // caso nao tenha nenhum arquivo
		File[] listaDeArquivos = f.listFiles();  // vai criar um array de arquivos, listar todos os arquivos dentro da pasta
		Arvore a = new Arvore(); // instanciar a arvore
		a.raiz = new NoArvore(); // iniciando a raiz da arvore

		for(int i = 0; i < listaDeArquivos.length;i++) { // passamos por todas as palavras de todos os arquivos e por todos os arquivos 
			Scanner sc = new Scanner(listaDeArquivos[i]); // escanenando as palavras dentro do arquivo
			String nomeArquivo = listaDeArquivos[i].getName(); // guardar o nome do arquivo, pra printar depois
			
			while(sc.hasNext()) {  // enquanto nao chegou no final do arquivo ele vai lendo as palavras
				String palavra = sc.next(); // palavra que ele esta no momento
			    NoArvore no = a.raiz; // vai puxar a raiz 
			    if(verifica(a.raiz,palavra)) { // verificar se a palavra ja existe na arvore 
			    	while(no != null) { // precorrer a arvore dependendo se der positivo ou negativo 
				    	if(palavra.compareTo(no.lista.primeiro.palavra) == 0) { 
							break; // achou a palavra
						}else if(palavra.compareTo(no.lista.primeiro.palavra) > 0) {
							no = no.direita;  // andar pra direita 
						}else if(palavra.compareTo(no.lista.primeiro.palavra) < 0) {
							no = no.esquerda; // andar esquerda
						} 
				    }
			    	
					No x = no.lista.primeiro; // recebe a lista da posicao X
					while (x != null) { // enquanto ele nao for nulo 
						if (x.nomeArquivo.equals(nomeArquivo)) { // se estiver no mesmo arquivo vai somar a frequencia da palavra
							x.freq++;
							break;
						}
						x = x.proximo; // passando pela lista 
					}
					if(x == null) {
						no.lista.insereOrdenado(palavra, 1, nomeArquivo); // caso nao ache a palavra ele vai inserir um novo No na lista da palavra 
					}
			    }
			    else {
			    	a.insere_elemento(a, palavra, 1, nomeArquivo); //se nao tiver nenhuma palavra que estamos verificando dentro da arvore
			    	// vai ser criado um No na arvore com a palavra
			    }
			}
			sc.close(); // fecha o arquivo que tinha aberto 
		}
		return a; // retorna a Arvore
	}
	
	public boolean verifica(NoArvore no, String palavra) throws FileNotFoundException{ // verificar se existe uma palavra em uma arvore (recursivo)
		if (no == null || no.lista.primeiro == null) {
			return false;
		}else if(palavra.compareTo(no.lista.primeiro.palavra) == 0) {
			return true;
		}else if(palavra.compareTo(no.lista.primeiro.palavra) > 0) {
			return verifica(no.direita,palavra);
		}else if(palavra.compareTo(no.lista.primeiro.palavra) < 0) {
			return verifica(no.esquerda,palavra);
		}
		return false;
	}
	
	public void pesquisa(Arvore a, String palavra) throws FileNotFoundException {
        if (!this.verifica(a.raiz, palavra)) { // verificar se a palavre que esta sendo pesquisada existe na arvore
            System.out.println("Essa palavra não foi encontrada.");
        } else {
            NoArvore x = a.raiz; // passar a raiz

            while(palavra.compareTo(x.lista.primeiro.palavra) != 0) { // enquanto for diferente de 0 ele vai andar pela arvore
                if (palavra.compareTo(x.lista.primeiro.palavra) > 0) {
                    x = x.direita;
                } else if (palavra.compareTo(x.lista.primeiro.palavra) < 0) {
                    x = x.esquerda;
                }
            }

            System.out.println("Palavra: " + x.lista.primeiro.palavra);
            No no = x.lista.primeiro;

            int y;
            for(y = 0; no != null; no = no.proximo) {
                System.out.println("Nome do Arquivo: '" + no.nomeArquivo + "' || Frequência: " + no.freq);
                y += no.freq;
            }

            System.out.println("Frequência total = " + y);
        }

    }
	
	public static void main(String[] args) throws FileNotFoundException{
		Contador_Palavras cp = new Contador_Palavras();
		Arvore a = cp.teste(new File("C:\\Users\\carli\\OneDrive\\Área de Trabalho\\teste"));
		a.imprime_preordem(a.raiz);
		System.out.println(a.altura(a, a.raiz.esquerda));
		System.out.println(a.altura(a, a.raiz.direita));
	}
}
