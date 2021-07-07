package Atividade1;

public class Exercicio3 {
	
	String nome;
	String sobrenome;
	int idade;
	float salario;
	
	public Exercicio3(String nome, String sobrenome, int idade, float salario) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.salario = salario;
	}
	
	public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public float getSalario() {
        return salario;
    }

}
