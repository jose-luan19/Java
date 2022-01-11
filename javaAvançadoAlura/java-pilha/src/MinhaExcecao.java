//public class MinhaExcecao extends RuntimeException
//Categoria unchecked, ou seja não é verificada pelo compilador

public class MinhaExcecao extends Exception{ //checked
//Categoria checked, ou seja é verificada pelo compilador e precisa ser declarado o 
//throws na assinatura do metoto que irá instanciar esta classe ou utlizar o try/catch
	
	public MinhaExcecao(String msg) {
		super(msg);
	}

}
