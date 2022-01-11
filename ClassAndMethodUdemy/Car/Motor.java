public class Motor {
	
	double fatorInjencao = 1;
	boolean ligado = false;
	
	//Para que seja feita uma ligação bidirecional
	//Ou seja o carro tem o motor e o motor tem o carro
	/*Carro carro;
	Motor(Carro carro){
		this.carro = carro;
	}*/
	
	int giros () {
		if(!ligado) {
			return 0;
		}else {
			return (int) Math.round(fatorInjencao*3000); // arredondamento para um valor inteiro
		}
	}
	

}
