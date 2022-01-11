package br.com.bytebank.banco.modelo;

public class ContaPoupanca extends Conta {

	/**
	 * Construtores n�o s�o herdados, mas podemos reutilaz-los dessa forma
	 */
	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;	
	}
	
}
