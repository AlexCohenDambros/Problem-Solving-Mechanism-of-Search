package TDE;

public class Expressao {
	public static boolean validaExpressao(String x) { //PASSANDO A OPERA��O COMO PARAMETRO ATRAS DE UMA STRING
		
		TadPilha p = new TadPilha(x.length()); //Instanciar e contar o tamanho da express�o
		
		for(int i = 0; i < x.length(); i++) {	
			
			if(x.charAt(i) == '(' || x.charAt(i) == '[' || x.charAt(i) == '{') {
				p.empilhar(x.charAt(i));
			}
			else if(x.charAt(i) == ')') {
				if(p.retornaTopo() == '(') {
					p.desempilhar();
				}
				else {
					System.out.println("Inv�lida");   
					return false;
				}
			}
			else if(x.charAt(i) == ']') {
				if(p.retornaTopo() == '[') {
					p.desempilhar();
				}
				else {
					System.out.println("Inv�lida");
					return false;
				}
			}
			else if(x.charAt(i) == '}') {
				if(p.retornaTopo() == '{') {
					p.desempilhar();
				}
				else {
					System.out.println("Inv�lida");
					return false;
				}
			}
		}
		//VERIFICAR SE DPS DO FOR A PILHA EST� VAZIA
		if(p.vazia()) {
			System.out.println("V�lida");
			return true;
		}
		System.out.println("Inv�lida");
		return false;
	}
	
	public static void main(String[] args) {
		validaExpressao("(1+5)*(56+12)");
		validaExpressao("(1+5)*)56+12)");
		validaExpressao("(1+5)*[56+12)");
		validaExpressao("(((1+2) - 3 )* 6)");
		validaExpressao("1+2");
	}
}
