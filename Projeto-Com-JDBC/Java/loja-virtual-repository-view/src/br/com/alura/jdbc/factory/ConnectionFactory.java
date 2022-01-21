package br.com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;

	/**
	 * Reciclagem de conexões
	 */
	public ConnectionFactory() {
		// Quando essa classe é instanciada é preparado esse pool de conexões, para que
		// não seja criado
		// uma fila de conexões, ou que sejam criadas muitas conexãos ao mesmo tempo.
		// E ainda é possivel por um minimo e um máximo de conexões possiveis para
		// guardar nesse pool.
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("Qweasdzxc123");

//		comboPooledDataSource.setMaxPoolSize(15);
//		comboPooledDataSource.setMinPoolSize(5);

		this.dataSource = comboPooledDataSource;
	}

	// Ao chamar o metodo ele apenas irá resgatar uma conexão já criada e passar com
	// return
	public Connection recuperarConexao()  {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
//		 DriverManager
//				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", 
//						"root", "Qweasdzxc123");

	}

}
