

//contrato Autenticavel
//quem assinar esse contrato precisa implementar
        //metodo setSenha
        //metodo autentica

//Classe especifica para polimorfismo 
public abstract interface Autenticavel {

	public abstract void setSenha(int senha);

	public abstract boolean autentica(int senha);

}
