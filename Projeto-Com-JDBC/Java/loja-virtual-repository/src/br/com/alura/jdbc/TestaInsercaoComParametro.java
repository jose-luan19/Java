package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		String nome = "Sql Injection";
		String descricao = ");delete from;";

		ConnectionFactory criandoConexao = new ConnectionFactory();
		Connection connection = criandoConexao.recuperarConexao();

		// Prepara o meu insert para receber informações que não irá prejudicar a minha
		// aplicação
		PreparedStatement stm = connection.prepareStatement(
				"INSERT INTO PRODUTO (NOME_PRODUTO, DESCRICAO) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, nome);
		stm.setString(2, descricao);

		// Fazendo a insercao com parametro
		stm.execute();

		// Buscando os resultados do stm.execute
		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);

		}

		rst.close();
		stm.close();
		connection.close();

	}

}
