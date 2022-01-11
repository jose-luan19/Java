public class Foreach {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		double[] notas = {6.5,48.9,8.5,47.49};
		for (int i = 0; i < notas.length; i++) {
			System.out.print (notas[i] + " ");
		}
		System.out.println();
		for (double nota : notas) {
			System.out.print(nota + " ");
		}
		int linha = 4, coluna = 2;
		double[][] matriz1 = new double[linha][coluna];
		double[][] matrix;
	}
}
