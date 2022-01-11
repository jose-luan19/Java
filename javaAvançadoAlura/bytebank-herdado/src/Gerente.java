

public class Gerente extends Funcionario implements Autenticavel {

	private AutenticacaoUtil autenticador;

    public Gerente() {
        this.autenticador = new AutenticacaoUtil();
    }

    @Override
    public void setSenha(int senha) {
        this.autenticador.setSenha(senha);
    }

    @Override
    public boolean autentica(int senha) {
        return this.autenticador.autentica(senha);
    }

	public double getBonificacao() {
		return super.salario;//super -> atributo definido na classe m�e
		//return super.getBonificacao() + super.getSalario(); -> implementa��o com o salario private
	}

}