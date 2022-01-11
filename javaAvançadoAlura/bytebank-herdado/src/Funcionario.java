

public abstract class Funcionario {
	private String nome;
	private String cpf;
	protected double salario;//protected -> publico somente para os filhos
	private static int quantidadeDeFuncionarios = 0;

	public Funcionario() {
		Funcionario.quantidadeDeFuncionarios++;
	}
	
	//metodo sem implementação, criado apenas para que os filhos possam utilizar
	public abstract double getBonificacao(); /*{
		return this.salario * 0.1;
	}*/

	public static int getQuantidadeDeFuncionarios() {
		return Funcionario.quantidadeDeFuncionarios;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
