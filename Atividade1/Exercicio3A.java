package Atividade1;

public class Exercicio3A {
	public static void main(String[] args) {
		Exercicio3 pessoa = new Exercicio3("Alex", "Cohen", 18, 1000);
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Sobrenome: " + pessoa.getSobrenome());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("Salario: " + pessoa.getSalario());
	}

}
