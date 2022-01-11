
public class Fluxo {

	public static void main(String[] args) {
		System.out.println("Ini do main");
		try {
			metodo1();
		} catch(Exception ex) {
			String msg = ex.getMessage();
			System.out.println("Exception " + msg);
			ex.printStackTrace();
		} 
		System.out.println("Fim do main");
	}

	private static void metodo1() throws MinhaExcecao  {
		System.out.println("Ini do metodo1");

		metodo2();

		System.out.println("Fim do metodo1");
	}

	private static void metodo2() throws MinhaExcecao {
		
		/**
		 * Ap�s instanciar uma exce��o. 
		 * O throw joga a exce��o na pilha, fazendo retornar
		 * at� o tratamento try catch, se houver
		 */
//		ArithmeticException ex = new ArithmeticException("Deu ruim");
//		throw ex;
//		throw new ArithmeticException("Deu ruim");
		throw new MinhaExcecao("Deu ruim demais");

		// System.out.println("Fim do metodo2");	
	}
}