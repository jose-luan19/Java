import javax.swing.JOptionPane;

public class StringParaNumber {
	public static void main(String[] args) {
		String valor1 = JOptionPane.showInputDialog("Informe um valor:");
		String valor2 = JOptionPane.showInputDialog("Informe um valor:");
		
		System.out.printf("1 valor: %s\n2 valor: %s\n\n", valor1, valor2);
		
		double numero1 = Double.parseDouble(valor1);
		double numero2 = Double.parseDouble(valor2);
		
		
		double soma = numero1 + numero2, media = (numero1+numero2)/2;
		System.out.println("Soma e "+soma);
		System.out.println("Media e "+media);


	}
}