package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.model.Categoria;
import br.com.alura.jdbc.model.Produto;

public class TestaListagemProdutoPorCategoriaMelhorado {

	public static void main(String[] args) throws SQLException {

		//Usando o metodo que possui a query com INNER JOIN

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			//produtoDao.salvar(comoda);
			List<Categoria> listaDeCategorias = categoriaDao.listarComProdutos();


			listaDeCategorias.stream().forEach(lc -> {
				System.out.println(lc);
				for (Produto produto : lc.adicionar()) {
					System.out.println(lc.getNome() +"   -> "+ produto.getNome());
				}
			});
				
		}

	}

}
