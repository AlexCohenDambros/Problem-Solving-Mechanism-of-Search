package TDE2;


public class Merge {
	private static int[] merge(Fila f, Fila f2) {
		int[] filaFinal = new int[f.getMAX() + f2.getMAX()];
		
		for(int x=0;x<filaFinal.length;x++) {
			
			if (f.vazia() && f2.vazia()) {
				break;
			}
			
			if (f2.vazia()) {
				filaFinal[x] = f.primeiro();
				f.remove();
			}
			else if(f.vazia()) {
				filaFinal[x] = f2.primeiro();
				f2.remove();
			}
			
			else if(f.primeiro()<=f2.primeiro()) {
				filaFinal[x] = f.primeiro();
				f.remove();
			}
			
			else if(f2.primeiro()<=f.primeiro()) {
				filaFinal[x] = f2.primeiro();
				f2.remove();
			}
		}
		for(int i:filaFinal) {
			System.out.println(i);
		}
		return filaFinal;
	}
	
	public static void main(String[] args) {
		Fila f = new Fila(4);
		Fila f2 = new Fila(5);
		f.insere(12);
		f.insere(35);
		f.insere(52);
		f.insere(64);
		f2.insere(5);
		f2.insere(15);
		f2.insere(23);
		f2.insere(55);
		f2.insere(75);
		merge(f,f2);
	}
}
