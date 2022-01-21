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

//Classe que acessa o banco de dados de fato, e se preciso envia as informações solicitadas, etc . . .
public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) {
		String sql = "INSERT INTO PRODUTO (NOME_PRODUTO, DESCRICAO, idCATEGORIA) VALUES (?,?,?)";

		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.setInt(3, produto.getCategoriaId());

			stm.execute();

			try (ResultSet rst = stm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}
	
	public void salvarComCategoria(Produto produto) {
		String sql = "INSERT INTO PRODUTO (NOME_PRODUTO, DESCRICAO, idCATEGORIA) VALUES (?, ?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setInt(3, produto.getCategoriaId());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> listar()  {
		List<Produto> produtos = new ArrayList<Produto>();

		String sql = "SELECT * FROM PRODUTO";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3),rst.getInt(4));
					produtos.add(produto);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return produtos;
	}

	public List<Produto> bucar(Categoria categoria) {
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT idPRODUTO, NOME_PRODUTO, DESCRICAO FROM PRODUTO WHERE idCATEGORIA = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, categoria.getId());
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3),categoria.getId());
					produtos.add(produto);
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return produtos;
	}
	
	public void deletar(Integer id)  {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE idPRODUTO = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(String nome, String descricao, Integer id)  {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE PRODUTO P SET P.NOME_PRODUTO = ?, P.DESCRICAO = ? WHERE idPRODUTO = ?")) {
			stm.setString(1, nome);
			stm.setString(2, descricao);
			stm.setInt(3, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
//	private void trasformarResultSetEmProduto(List<Produto> produtos, PreparedStatement pstm) {
//		try (ResultSet rst = pstm.getResultSet()) {
//			while (rst.next()) {
//				Produto produto = null;
//				try {
//					produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				produtos.add(produto);
//			}
//		} catch (SQLException e1) {
//			throw new RuntimeException(e1);
//		}
//	}
	
}