package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
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

public class PerfomanceConsultas {

	public static void main(String[] args) {

		popularBancoDeDados();
		EntityManager em = JPAUtil.recuperaConexao();
		PedidoDAO pedidoDao = new PedidoDAO(em);
		Pedido pedido = pedidoDao.buscarPedidoComCliente(2l);
		
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		List<Produto> produtosCriteria = produtoDao.buscarPorParametrosComCriteria(null, new BigDecimal("1200"), LocalDate.now());
		List<Produto> produtos = produtoDao.buscarPorParametros("PS5", new BigDecimal("4500"), null);
		
		produtosCriteria.forEach(System.out::println);
		produtos.forEach(System.out::println);
		
		em.close();
		
		System.out.println(pedido.getCliente().getNome());		
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAME");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi Redmi","Muito legal",new BigDecimal("1200"), celulares);
		Produto videogame = new Produto("PS5","TOP",new BigDecimal("4500"), videogames);
		Produto macbook = new Produto("MACBOOK","DEMAIS",new BigDecimal("7000"), informatica);
		
		Cliente clienteRodrigo = new Cliente("Rodrigo","1121");
		Cliente clienteLuan = new Cliente("Luan","457889");

		EntityManager em = JPAUtil.recuperaConexao();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);

		Pedido pedido1 = new Pedido(clienteRodrigo);
		pedido1.adicionarItem(new ItemPedido(5, pedido1, celular));
		pedido1.adicionarItem(new ItemPedido(2, pedido1, videogame));
		
		Pedido pedido2 = new Pedido(clienteLuan);
		pedido2.adicionarItem(new ItemPedido(8, pedido2, macbook));
		
		PedidoDAO pedidoDao = new PedidoDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);
		
		
		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);
		
		clienteDao.cadastrar(clienteRodrigo);
		clienteDao.cadastrar(clienteLuan);
		
		pedidoDao.cadastrar(pedido1);
		pedidoDao.cadastrar(pedido2);
		
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("VALOR TOTAL: " +totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		relatorio.forEach(System.out::println);

		em.close();
	}

}
