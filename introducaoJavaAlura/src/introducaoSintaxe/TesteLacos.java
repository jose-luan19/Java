package introducaoSintaxe;

public class TesteLacos {

	public static void main(String[] args) {
		int contador = 0;
		int total = 0;

		while (contador <= 10) {

			total = total + contador;

			System.out.println(total);
			contador++;
		}
		for (contador = 0; contador <= 10; contador++) {
			System.out.println(contador);
		}
		for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {
			for (contador = 0; contador <= 10; contador++) {
				System.out.print(multiplicador * contador);
				System.out.print(" ");
			}
			System.out.println();
		}
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna <= linha; coluna++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
