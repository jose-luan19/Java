package br.com.bytebank.banco.modelo;

/**
 * Classe que representa a moldura de uma conta
 * 
 * @author Jose Luan
 * 
 */
public abstract class Conta {

	// Private usado para encapslamento e melhorar manuntenção de código
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;

	/**
	 * Construtor para inicializar o objeto Conta a partir da agencia e numero.
	 * 
	 * @param agencia
	 * @param numero
	 */
	public Conta(int agencia, int numero) {
		Conta.total++;
		// System.out.println("O total de contas Ã© " + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
		// this.saldo = 100;
		// System.out.println("Estou criando uma conta " + this.numero);
	}

	public abstract void deposita(double valor);

	// Usando Exception

	/**
	 * Valor precisa ser maior do que o saldo.
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	public void saca(double valor) throws SaldoInsuficienteException {

		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor);
		}

		this.saldo -= valor;
	}
//	public boolean saca(double valor) {
//	if (this.saldo >= valor) {
//		this.saldo -= valor;
//		return true;
//	}
//	return false;
//}

	// Usando Exception
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
		this.saca(valor);
		destino.deposita(valor);
	}


	//Polimorfismo
//	public boolean transfere(double valor, Conta destino) {
//		if (this.saca(valor)) {
//			destino.deposita(valor);
//			return true;
//		}
//		return false;
//	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("Nao pode valor menor igual a 0");
			return;
		}
		this.numero = numero;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		if (agencia <= 0) {
			System.out.println("Nao pode valor menor igual a 0");
			return;
		}
		this.agencia = agencia;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public static int getTotal() {
		return Conta.total;
	}

}