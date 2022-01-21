package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory criandoConexao = new ConnectionFactory();
		Connection connection = criandoConexao.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("SELECT * FROM PRODUTO");

		// Fazendo a consulta e se for uma realmente uma consulta retorna true, e false
		// se não for.
		// E em qualquer uma das hipoteses, o resultado da chamada também gera um
		// ResultSet
		boolean resultado = stm.execute();

		System.out.println("A consulta é uma lista: " + resultado + "\n");

		// Buscando os resultados do stm.execute
		ResultSet rst = stm.getResultSet();

		// Laço para pegar todos os dados da tabela um por um
		while (rst.next()) {
			Integer id = rst.getInt("idPRODUTO");
			System.out.println(id);
			String nome = rst.getString("NOME_PRODUTO");
			System.out.println(nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
		}
		rst.close();
		stm.close();
		connection.close();
	}

}
