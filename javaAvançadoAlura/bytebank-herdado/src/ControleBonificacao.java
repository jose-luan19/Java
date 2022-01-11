

public class ControleBonificacao {

	private double soma;
	
	/**
	 * Caso tipico de polimorfismo onde usamos a referência do tipo mais generico (Funcionario)
	 * para se comunicar com os metodos mais especificos de cada classe-filha (Gerente, ...).
	 * Evitando repetição de código. 
	 * Definição Alura: Referências de tipos de classes mais genéricas referenciam 
	 * bjetos mais específicos.
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
