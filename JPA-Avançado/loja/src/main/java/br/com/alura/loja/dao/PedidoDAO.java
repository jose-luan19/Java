package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

public class PedidoDAO {
	
	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql,BigDecimal.class).getSingleResult();
	}
	
	//Criar uma classe para tratar esse relatorio especifico, por padrão é usado essas 'Vo'.
	//Usar o SELECT new é a maneira mais correta de realizar essas consultas.
	//Irá me devolver uma lista de objetos especifico ,RelatorioDeVendasVo, 
	//com todos os atributos que eu solicitei na consulta.
	//É preciso passar todod o diretorio do meu Vo para funfar kkk
	public List<RelatorioDeVendasVo> relatorioDeVendas() {
		String jpql = "SELECT new br.com.alura.loja.vo.RelatorioDeVendasVo("
				+ "produto.nome, SUM(item.quantidade), MAX(pedido.data)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY item.quantidade DESC";
		return em.createQuery(jpql,RelatorioDeVendasVo.class).getResultList();
	}
	
	//Query planejada com o JOIN FETCH, para nesse caso em especifico já seja carregado os dados 
	//da tabela cliente, no caso dessa consulta em especifico ela será feita no modo Eager
	public Pedido buscarPedidoComCliente(Long id) {
		return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id",Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
