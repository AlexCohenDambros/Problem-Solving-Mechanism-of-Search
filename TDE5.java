import java.util.Random;


public class TDE5 {
	public int[] lista;
	public int topo;

	public TDE5(int tamanho) {
		this.lista = new int[tamanho];
		this.topo = 0;
	}
	
	public void adiciona(int x) {
		lista[topo] = x;
		topo++;
	}
	
	public void imprimeLista() {
		for(int i = 0; i < lista.length; i++) {
			System.out.print(lista[i]+",");
		}
	}
	
	public void quicksort(int[] lista, int esquerda, int direita) {
		if(direita > esquerda) {
			int pivo = lista[esquerda];
			int i = esquerda;
			for(int j = esquerda + 1; j <= direita;j++) {
				if(lista[j] < pivo) {
					i++;
					int x = lista[i];
					lista[i] = lista[j];
					lista[j] = x;
				}
			}
			lista[esquerda] = lista[i];
			lista[i] = pivo;
			
			quicksort(lista,esquerda,i-1);
			quicksort(lista,i+1,direita);
		}
	}
	
	public void shellsort(int[] lista) {
		int x = lista.length / 2;
		int y;
		while(x >= 1) {
			for(int i = 0; i< lista.length; i++) {
				if(i + x >=lista.length) {
					break;
				}else if(lista[i] > lista[i + x]) {
					y = lista[i];
					lista[i] = lista[i + x];
					lista[i + x] = y;
					if(i - x >= 0) {
						i = i-x-1;
					}
				}
			}
			x = x / 2;
		}
	}
	
	public NoArvore[] maxheap(NoArvore[] listaNos) {
		for(int x = (listaNos.length / 2 - 1); x >= 0; x--) {
			NoArvore no = listaNos[x];
			if(no.dado < no.esquerda.dado) {
				listaNos[x] = no.esquerda;
				listaNos[(x + 1) * 2 - 1] = no;
				for(int i = 0; (i + 1) * 2 <= listaNos.length;i++) {
					NoArvore noo = listaNos[i];
					noo.esquerda = listaNos[(i+1) * 2 - 1];
					if((i + 1) * 2 <= listaNos.length - 1) {
						noo.direita = listaNos[(i+1) * 2];
					}
				}
				no = listaNos[x];
			} if(no.direita != null && no.dado < no.direita.dado) {
				listaNos[x] = no.direita;
				listaNos[(x + 1) * 2] = no;
				for(int i = 0; (i + 1) * 2 <= listaNos.length;i++) {
					NoArvore noo = listaNos[i];
					noo.esquerda = listaNos[(i+1) * 2 - 1];
					if((i + 1) * 2 <= listaNos.length - 1) {
						noo.direita = listaNos[(i+1) * 2];
					}
				}
			}
		}
		return listaNos;
	}
	
	public void heapsort(int[] lista) {
			NoArvore[] listaNos = new NoArvore[lista.length];
			
			for(int y = 0; y < listaNos.length; y++) {
				listaNos[y] = new NoArvore(lista[y]);
			}
			
			for(int y = 0; (y + 1) * 2 <= listaNos.length;y++) {
				NoArvore no = listaNos[y];
				no.esquerda = listaNos[(y+1) * 2 - 1];
				if((y + 1) * 2 <= listaNos.length - 1) {
					no.direita = listaNos[(y+1) * 2];
				}
			}
			
			for(int i = listaNos.length; i >= 1; i--) {
				NoArvore[] listaNos2 = new NoArvore[i];
				for(int x = 0; x<listaNos2.length;x++) {
					listaNos2[x] = listaNos[x];
				}
				listaNos = maxheap(listaNos2);
				lista[i-1] = listaNos[0].dado;
				
				NoArvore no1 = listaNos[0];
				listaNos[0] = listaNos[listaNos.length - 1];
				listaNos[listaNos.length - 1] = no1;
				listaNos[i - 1] = null;
				
				for(int x = 0; x < listaNos.length; x++) {
					if(listaNos[x] != null) {
						listaNos[x].esquerda = null;
						listaNos[x].direita = null;
					}
				}
				for(int y = 0; (y + 1) * 2 <= listaNos.length;y++) {
					NoArvore no = listaNos[y];
					if(no != null) {
						no.esquerda = listaNos[(y+1) * 2 - 1];
						if((y + 1) * 2 <= listaNos.length - 1) {
							no.direita = listaNos[(y+1) * 2];
						}
					}
				}
				
			}
	}
	
	// o selectionSort vai pegar o menor elemento da lista e colocar na cabeça da lista e vai ordenando o resto da lista
			public void selectionSort(int[] lista) {
		        int y = 0; // definimos o y começando no 0
		        while(y < lista.length) { // enquanto o y for menor que a lista
		            int x = lista[y]; // x recebe o valor do primeiro elemento da nossa nova lista
		            int z = y; // instanciamos o z
		            for (int i = y; i < lista.length; i++) { // passa pela lista inteira procurando um elemento menor do que temos no momento
		                if(lista[i] < x) { // verifica se o proximo elemento da lista é menor que o primeiro elemento que ja temos
		                    x = lista[i]; // x recebe o valor do elemento 
		                    z = i; // z recebe o valor do novo elemento
		                }
		            }
		            lista[z] = lista[y];
		            lista[y] = x;
		            y++; // soma 1 ao y
		        }
		    }	
	
	public void insertionSort(int[] lista) {
		for(int i = 1; i < lista.length; i++) {
			int y = i - 1;
			int x = i;
			while(y >= 0 && lista[x] < lista[y]) {
				int z = lista[y];
				lista[y] = lista[x];
				lista[x] = z;
				y--;
				x--;
			}
		}
	}
	
	public int[] mergeSort(int[] lista) {
		if(lista.length == 1) {
			return lista;
		}
		
		int[] lista_A = new int[lista.length / 2];
		int[] lista_B = new int[lista.length / 2];
		
		if(lista.length % 2 == 1) {
			lista_B = new int[lista.length / 2 + 1];
		}
		
		int x = 0;
		for(int i = 0; i < lista.length; i++) {
			if(i < lista.length / 2) {
				lista_A[i] = lista[i];
			}else if(i >= lista.length / 2) {
				lista_B[x] = lista[i];
				x++;
			}
		}
		
		lista_A = mergeSort(lista_A);
		lista_B = mergeSort(lista_B);
		
		return merge(lista_A,lista_B);
	}
	
	public int[] merge(int[] lista_A, int[] lista_B) {
		int[] listaFinal = new int[lista_A.length + lista_B.length];
		
		int x = 0;
		int y = 0;
		int z = 0;
		while(z < listaFinal.length) {
			if(x == lista_A.length) {
				for(int i = z; i < listaFinal.length; i++) {
					listaFinal[i] = lista_B[y];
					y++;
					z++;
				}
			}else if(y == lista_B.length) {
				for(int i = z; i < listaFinal.length; i++) {
					listaFinal[i] = lista_A[x];
					x++;
					z++;
				}
			}else if(lista_A[x] <= lista_B[y]) {
				listaFinal[z] = lista_A[x];
				z++;
				x++;
			}else if(lista_B[y] <= lista_A[x]) {
				listaFinal[z] = lista_B[y];
				z++;
				y++;
			}
		}
		return listaFinal;
	}
	
	public static void Desordenado(int x) {
		System.out.println("===================== Desordenado =====================");
		
		TDE5 a = new TDE5(x);
		Random rd = new Random();
		
	    for (int i = 0; i < a.lista.length; i++) {
	    	a.lista[i] = rd.nextInt();
	    }
	    
	    int[] listaTeste = a.lista;
	    long start = System.currentTimeMillis();
	    a.quicksort(listaTeste, 0, a.lista.length - 1);
	    long end = System.currentTimeMillis();
	    long tempoPassado = end - start;
	    System.out.println("Tempo do QuickSort em milissegundos: " + tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.shellsort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do ShellSort em milissegundos: " + tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.heapsort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do HeapSort em milissegundos: " + tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.selectionSort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do  SelectionSort em milissegundos: " +tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.insertionSort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do  InsertionSort em milissegundos: " + tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.mergeSort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do MergeSort em milissegundos: " + tempoPassado);
	}
	
	public static void OrdemDes(int x) {
		System.out.println("===================== Ordem decrescente =====================");
		TDE5 a = new TDE5(x);
		
	    for (int i = a.lista.length - 1; i >= 0; i--) {
	    	a.lista[i] = i;
	    }
	    
	    int[] listaTeste = a.lista;
	    long start = System.currentTimeMillis();
	    a.quicksort(listaTeste, 0, a.lista.length - 1);
	    long end = System.currentTimeMillis();
	    long tempoPassado = end - start;
	    System.out.println("Tempo do QuickSort em milissegundos: " + tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.shellsort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do ShellSort em milissegundos: " + tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.heapsort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do HeapSort em milissegundos: " + tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.selectionSort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do  SelectionSort em milissegundos: " + tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.insertionSort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do  InsertionSort em milissegundos: " + tempoPassado);
	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.mergeSort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do MergeSort em milissegundos: " + tempoPassado);
	}
	
	public static void Semi(int x) {
		System.out.println("===================== Quase Ordenado =====================");
		TDE5 a = new TDE5(x);
		
		int[] listaSemiOrdenada = a.lista;
		
	    for(int i = 1; i < listaSemiOrdenada.length / 2; i++) {
			int y = i - 1;
			int x1 = i;
			while(y >= 0 && listaSemiOrdenada[x1] < listaSemiOrdenada[y]) {
				int z = listaSemiOrdenada[y];
				listaSemiOrdenada[y] = listaSemiOrdenada[x1];
				listaSemiOrdenada[x1] = z;
				y--;
				x1--;
			}
	    }
		
	    int[] listaTeste = listaSemiOrdenada;
	    long start = System.currentTimeMillis();
	    a.quicksort(listaTeste, 0, a.lista.length - 1);
	    long end = System.currentTimeMillis();
	    long tempoPassado = end - start;
	    System.out.println("Tempo do QuickSort em milissegundos: " +tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.shellsort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do ShellSort em milissegundos: " +tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.heapsort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do HeapSort em milissegundos: " + tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.selectionSort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do SelectionSort em milissegundos: " + tempoPassado);

	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.insertionSort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do InsertionSort em milissegundos: " + tempoPassado);
	    listaTeste = a.lista;
	    start = System.currentTimeMillis();
	    a.mergeSort(listaTeste);
	    end = System.currentTimeMillis();
	    tempoPassado = end - start;
	    System.out.println("Tempo do MergeSort em milissegundos: " + tempoPassado);
	}
		
	public static void main(String[] args) {
		Semi(20000);
		Desordenado(20000);
		OrdemDes(20000);
	}
}
