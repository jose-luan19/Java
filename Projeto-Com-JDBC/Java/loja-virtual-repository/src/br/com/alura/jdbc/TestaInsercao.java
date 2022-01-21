package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory criandoConexao = new ConnectionFactory();
		Connection connection = criandoConexao.recuperarConexao();

		Statement stm = connection.createStatement();

		// Fazendo a insercao
		stm.execute("INSERT INTO PRODUTO (NOME_PRODUTO, DESCRICAO) VALUES ('Mouse','Logitech')",
				Statement.RETURN_GENERATED_KEYS);

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
