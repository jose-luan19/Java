package introducaoSintaxe;

public class Teste3_conversao {

	public static void main(String[] args) {
		double salario = 127751.64646;
		int valor = (int)salario;
		System.out.println(valor);
		
		long grande = 5464316165161L;
		short pequeno = 2131;
		byte b = 127;
		System.out.println(grande+"\n"+ pequeno + "\n" + b);
	}

}
