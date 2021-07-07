
public class TrabalhoFinal {
	
	public void shellsort(int[] lista) { // passamos uma lista com os numeros dentro
        int x = lista.length / 2; // pegamos o tamanho total da lista e dividimos por 2 para verificar as posições
        int y;  // guardar o numero, caso seja preciso trocar os numeros
        while(x >= 1) { // enquanto o numero das posições for maior que 1 vai ser verificada toda a lista
            for(int i = 0; i< lista.length; i++) { // vai andar pela lista
                if(i + x >=lista.length) { // se o i + x for maior que o tamanho da lista vai dar break
                    break;
                }else if(lista[i] > lista[i + x]) { // se o numero que ele ta na posicao atual for maior que o numero da posicao + x
                    y = lista[i]; // esses dois numeros serão invertidos
                    lista[i] = lista[i + x];
                    lista[i + x] = y;
                    if(i - x >= 0) { // caso troque os numeros vamos vereficar a posicao atual - x, verificando asssim os numeros anteriores
                        i = i-x-1;
                    }
                }
            }
            x = x / 2; // dividimos novamente o x
        }
    }

}
