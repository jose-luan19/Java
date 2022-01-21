package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.model.Categoria;
import br.com.alura.jdbc.model.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Categoria categoria) {
		String sql = "INSERT INTO CATEGORIA (NOME_CATEGORIA) VALUES (?)";

		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stm.setString(1, categoria.getNome());

			stm.execute();

			try (ResultSet rst = stm.getGeneratedKeys()) {
				while (rst.next()) {
					categoria.setId(rst.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Categoria> listar() {
		try {
			List<Categoria> categorias = new ArrayList<Categoria>();

			String sql = "SELECT * FROM CATEGORIA";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
						categorias.add(categoria);
					}
				}
			}

			return categorias;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Utilizando o INNER JOIN, para evitar repetir querys
	public List<Categoria> listarComProdutos() {
		Categoria ultima = null;

		List<Categoria> categorias = new ArrayList<Categoria>();

		// * == C.idCATEGORIA, C.NOME_CATEGORIA, P.idPRODUTO, P.NOME_PRODUTO,P.DESCRICAO
		String sql = "SELECT * FROM CATEGORIA C INNER JOIN PRODUTO P ON C.idCATEGORIA = P.idCATEGORIA";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					if (ultima == null || !ultima.getNome().equals(rst.getString(2))) {
						Categoria categoria = new Categoria(rst.getInt("idCATEGORIA"), rst.getString("NOME_CATEGORIA"));
						ultima = categoria;
						categorias.add(categoria);
					}
					Produto produto = new Produto(rst.getInt("idPRODUTO"), rst.getString("NOME_PRODUTO"),
							rst.getString("DESCRICAO"),rst.getInt("idCATEGORIA"));
					ultima.setProdutos(produto);
				}
			}
			return categorias;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}