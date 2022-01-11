public class CarroTeste {
	public static void main(String[] args) {
		
		Carro carro1  = new Carro();
		
		System.out.println(carro1.estaligado());
		
		carro1.ligar();
		
		System.out.println(carro1.estaligado());
		
		System.out.println(carro1.motor.giros());
		
		carro1.acelerar();
		carro1.acelerar();
		carro1.acelerar();
		carro1.acelerar();
		carro1.acelerar();
		carro1.acelerar();
		carro1.acelerar();
		carro1.acelerar();
		carro1.acelerar();
		carro1.acelerar();
		carro1.acelerar();
		
		System.out.println(carro1.motor.giros());
		
		carro1.frear();
		carro1.frear();
		carro1.frear();
		carro1.frear();
		carro1.frear();
		carro1.frear();
		carro1.frear();
		carro1.frear();
		carro1.frear();
		carro1.frear();
		carro1.frear();
		carro1.frear();
		
		// Faltou encapsulamento
		// carro1.motor.fatorInjencao = -30;
		System.out.println(carro1.motor.giros());
		
		//Qaundo há uma relação bidimensional
		//System.out.println(carro1.motor.carro.motor.carro.motor.giros());
		
		carro1.desligar();
		
	}

}
