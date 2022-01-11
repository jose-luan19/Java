public class CompraTeste {
	public static void main(String[] args) {
		
		Compra compra1 = new Compra();
		compra1.cliente = "Luan";
		
		compra1.itens.add(new Item("Caneta", 20, 5.80));
		compra1.itens.add(new Item("Borracha", 5, 2.9));
		compra1.adicionarItem(new Item("Caderno", 2, 15));
		compra1.adicionarItem("Bola", 3, 10.90);
		
		System.out.println(compra1.itens.size());
		System.out.println(compra1.valorTotal());
		
		
	}

}
