package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.model.Categoria;
import br.com.alura.jdbc.model.Produto;

public class TestaListagemProdutoPorCategoria {

	public static void main(String[] args) throws SQLException {

		//Não é uma boa pratica, realizar varias querys simples para listar cada produto a partir do idCATEGORIA

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			//produtoDao.salvar(comoda);
			List<Categoria> listaDeCategorias = categoriaDao.listar();


			listaDeCategorias.stream().forEach(lc -> {
				System.out.println(lc);
				try {
					for (Produto produto : new ProdutoDAO(connection).bucar(lc)) {
					System.out.println(lc.getNome() +"   -> "+ produto.getNome());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		}

	}

}
