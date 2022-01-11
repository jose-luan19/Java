

public class TesteFuncionario {

	public static void main(String[] args) {
		//Funcionario f1 = new Funcionario(); após tornar a classe abstract, o new para de funcionar
		EditorVideo ev = new EditorVideo();
		Gerente g1 = new Gerente();
		
		g1.setSalario(5000.0);
        ev.setSalario(2500.0);
        

		
		 ControleBonificacao controle = new ControleBonificacao();

		 controle.registra(g1);
         controle.registra(ev);


		
		System.out.println(controle.getSoma());
	}

}
