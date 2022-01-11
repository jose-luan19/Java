package enumAlura;

//As enums são uma forma orientada a objetos de lidar com os constantes na linguagem Java
public class Teste {

	public static void main(String[] args) {
//		Thread t = new Thread(() -> System.out.println("rodando ..."));
//		t.start();
		
		Prioridade pMin = Prioridade.MIN;
		Prioridade pMax = Prioridade.MAX;
		
		System.out.println(pMin.name());
		System.out.println(pMin.ordinal());

		System.out.println();
		
		System.out.println(pMax.name());
		System.out.println(pMax.ordinal());
		
		System.out.println();
		
		System.out.println(pMin.getValor());
		System.out.println(pMax.getValor());
	}

}
