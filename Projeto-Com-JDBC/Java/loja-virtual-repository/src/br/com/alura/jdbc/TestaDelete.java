package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaDelete {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory criandoConexao = new ConnectionFactory();
		Connection connection = criandoConexao.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE idPRODUTO > ?");
		stm.setInt(1, 4);

		// Fazendo a remoção
		stm.execute();

		// Função que retorna a quantidade de linhas modificadas
		Integer linhasModificada = stm.getUpdateCount();

		System.out.println("Quantidade de linhas modificadas: " + linhasModificada);

		stm.close();
		connection.close();

	}

}
