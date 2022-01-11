

public class TesteReferencias {

	public static void main(String[] args) {
		Conta primeiraConta = new Conta(1337, 24226);
		primeiraConta.deposita(200); 
		System.out.println(primeiraConta.getSaldo());

		primeiraConta.deposita(100); 
		System.out.println(primeiraConta.getSaldo());

		Conta segundaConta = new Conta(1337, 24226);
		segundaConta.deposita(50); 

		System.out.println("primeira conta tem " + primeiraConta.getSaldo());
		System.out.println("segunda conta tem " + segundaConta.getSaldo());

		System.out.println(primeiraConta.getAgencia());
		System.out.println(primeiraConta.getNumero());

		System.out.println(segundaConta.getAgencia());

		System.out.println("agora a segunda conta está na agencia " + segundaConta.getAgencia());

		if (primeiraConta == segundaConta) {
			System.out.println("mesma conta");
		} else {
			System.out.println("contas diferentes");
		}

		System.out.println(primeiraConta);
		System.out.println(segundaConta);

	}

}
