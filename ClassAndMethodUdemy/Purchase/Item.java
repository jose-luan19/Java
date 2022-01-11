public class Item {
	
	String nome;
	int quantidade;
	double preco;
	// Colocando a classe compra em Item
	Compra compra;
	
	Item (String nome, int quantidade, double preco){
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}

}
