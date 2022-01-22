package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

public class CadastroDePedido {

	public static void main(String[] args) {

		popularBancoDeDados();
		EntityManager em = JPAUtil.recuperaConexao();
		
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		Produto produto1 = produtoDao.buscarPorId(1l);
		Produto produto2 = produtoDao.buscarPorId(2l);
		Produto produto3 = produtoDao.buscarPorId(3l);
		
		ClienteDAO clienteDao = new ClienteDAO(em);
		Cliente cliente = clienteDao.buscarPorId(1l);
		
		em.getTransaction().begin();
		

		Pedido pedido1 = new Pedido(cliente);
		pedido1.adicionarItem(new ItemPedido(5, pedido1, produto1));
		pedido1.adicionarItem(new ItemPedido(2, pedido1, produto2));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(8, pedido2, produto3));
		
		PedidoDAO pedidoDao = new PedidoDAO(em);
		pedidoDao.cadastrar(pedido1);
		pedidoDao.cadastrar(pedido2);
		
		em.getTransaction().commit();
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("VALOR TOTAL: " +totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		
		//Outra sintaxe para percorrer uma matriz e imprimir todos os seus valores 
		relatorio.forEach(System.out::println);
		
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAME");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi Redmi","Muito legal",new BigDecimal("1200"), celulares);
		Produto videogame = new Produto("PS5","TOP",new BigDecimal("4500"), videogames);
		Produto macbook = new Produto("MACBOOK","DEMAIS",new BigDecimal("7000"), informatica);
		
		Cliente cliente = new Cliente("Rodrigo","1121");

		EntityManager em = JPAUtil.recuperaConexao();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);

		
		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);
		
		
		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);
		
		
		clienteDao.cadastrar(cliente);
		em.getTransaction().commit();

		em.close();
	}

}
