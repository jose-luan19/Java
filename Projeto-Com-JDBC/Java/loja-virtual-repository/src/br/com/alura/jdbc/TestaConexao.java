package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		// Criando a conexão com o DB
		ConnectionFactory criandoConexao = new ConnectionFactory();
		Connection connection = criandoConexao.recuperarConexao();

//		Connection connection = DriverManager
//				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "Qweasdzxc123");

		System.out.println("Conexão Realizada com sucesso!!!");

		connection.close();
	}

}
