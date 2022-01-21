package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercaoMultiplaComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criandoConexao = new ConnectionFactory();
		// utilizar o try with recources para que as instancias criadas do sql, sejam
		// fechadas automaticamente
		try (Connection connection = criandoConexao.recuperarConexao()) {

			// Assume o um maior controle do JDBC, impedindo que ele faça transações
			// automaticamente
			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (NOME_PRODUTO, DESCRICAO) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {
				adcionarVariavel("SmartTV", "45 polegadas", stm);
				adcionarVariavel("Radio", "Radio de bateria", stm);

				// Libera a trasanção para o banco
				connection.commit();
				// Como o stm foi criado no try, após o bloco acabar ele fecha automaticamente
//			stm.close();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		} // connection.cloce();

	}

	private static void adcionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		// Fazendo a insercao com parametro
		stm.execute();

		// Buscando os resultados do stm.execute
		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		} // rst.cloce();

	}

}
