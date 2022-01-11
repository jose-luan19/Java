package br.com.bytebank.banco.modelo;

//new ContaCorrente()
public class ContaCorrente extends Conta implements Tributavel {
	/**
	 * Construtores não são herdados, mas podemos reutilaz-los dessa forma
	 */
	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public void saca(double valor) throws SaldoInsuficienteException{
		double valorASacar = valor + 0.2;
		super.saca(valorASacar);
	}

	@Override
	public void deposita(double valor) {
        super.saldo += valor;
    }

	@Override
	public double getValorImposto() {	
		return super.saldo * 0.01;
	}
	
}
