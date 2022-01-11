public class Carro {
	
	Motor motor = new Motor();
	
	//Para que seja feita uma ligação bidirecional
	//Ou seja o carro tem o motor e o motor tem o carro
	/*Motor motor;
	Carro(Motor motor){
		this.motor = new Motor(this);
	}*/
	
	void acelerar(){
		if(motor.fatorInjencao < 2.6) {
			motor.fatorInjencao += 0.4;

		}
	}
	
	void frear() {
		if(motor.fatorInjencao > 0.5) {
			motor.fatorInjencao -= 0.4;
		}
	}
	
	void ligar() {
		motor.ligado = true;
	}
	
	void desligar() {
		motor.ligado = false;
	}
	
	boolean estaligado() {
		return motor.ligado;
	}
}
