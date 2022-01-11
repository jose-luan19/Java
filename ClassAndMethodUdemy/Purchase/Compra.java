import java.util.ArrayList;

public class Compra {
	
	String cliente;// O correto seria uma classe para 'clientes'
	ArrayList<Item> itens = new ArrayList<Item>();
	//Transformando em uma relação bidirecional
	//-------------------------------------------------------------------------------------------------------------
	void adicionarItem(Item item) {
		this.itens.add(item);
		item.compra = this;
	}
	
	void adicionarItem(String nome, int quantidade, double preco) {
		this.adicionarItem(new Item(nome, quantidade, preco));
	}
	//----------------------------------------------------------------------------------------------
	double valorTotal() {
		double total = 0;
		for (Item item : itens) {
			total += item.quantidade * item.preco;
			
		}
		return total;
	}

}
