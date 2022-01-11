

public class ControleBonificacao {

	private double soma;
	
	/**
	 * Caso tipico de polimorfismo onde usamos a refer�ncia do tipo mais generico (Funcionario)
	 * para se comunicar com os metodos mais especificos de cada classe-filha (Gerente, ...).
	 * Evitando repeti��o de c�digo. 
	 * Defini��o Alura: Refer�ncias de tipos de classes mais gen�ricas referenciam 
	 * bjetos mais espec�ficos.
	 * 
	 */
	public void registra(Funcionario f) {
		double boni = f.getBonificacao();
		this.soma = this.soma + boni;
		System.out.println(this.soma);
	}

	public double getSoma() {
		return this.soma;
	}
}
