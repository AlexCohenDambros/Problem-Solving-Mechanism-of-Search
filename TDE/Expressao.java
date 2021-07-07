package TDE;

public class Expressao {
	public static boolean validaExpressao(String x) { //PASSANDO A OPERAÇÃO COMO PARAMETRO ATRAS DE UMA STRING
		
		TadPilha p = new TadPilha(x.length()); //Instanciar e contar o tamanho da expressão
		
		for(int i = 0; i < x.length(); i++) {	
			
			if(x.charAt(i) == '(' || x.charAt(i) == '[' || x.charAt(i) == '{') {
				p.empilhar(x.charAt(i));
			}
			else if(x.charAt(i) == ')') {
				if(p.retornaTopo() == '(') {
					p.desempilhar();
				}
				else {
					System.out.println("Inválida");   
					return false;
				}
			}
			else if(x.charAt(i) == ']') {
				if(p.retornaTopo() == '[') {
					p.desempilhar();
				}
				else {
					System.out.println("Inválida");
					return false;
				}
			}
			else if(x.charAt(i) == '}') {
				if(p.retornaTopo() == '{') {
					p.desempilhar();
				}
				else {
					System.out.println("Inválida");
					return false;
				}
			}
		}
		//VERIFICAR SE DPS DO FOR A PILHA ESTÁ VAZIA
		if(p.vazia()) {
			System.out.println("Válida");
			return true;
		}
		System.out.println("Inválida");
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
