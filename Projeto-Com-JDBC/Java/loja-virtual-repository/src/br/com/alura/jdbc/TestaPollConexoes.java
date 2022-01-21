package br.com.alura.jdbc;

import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaPollConexoes {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criandoConexao = new ConnectionFactory();

		for (int i = 0; i < 20; i++) {
			criandoConexao.recuperarConexao();
			System.out.println(i + "ª Conexão Realizada com sucesso!!!");
//			connection.close();
		}

	}

}
