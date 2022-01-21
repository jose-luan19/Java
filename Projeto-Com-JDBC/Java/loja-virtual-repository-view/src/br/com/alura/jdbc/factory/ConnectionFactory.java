package br.com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;

	/**
	 * Reciclagem de conex�es
	 */
	public ConnectionFactory() {
		// Quando essa classe � instanciada � preparado esse pool de conex�es, para que
		// n�o seja criado
		// uma fila de conex�es, ou que sejam criadas muitas conex�os ao mesmo tempo.
		// E ainda � possivel por um minimo e um m�ximo de conex�es possiveis para
		// guardar nesse pool.
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("Qweasdzxc123");

//		comboPooledDataSource.setMaxPoolSize(15);
//		comboPooledDataSource.setMinPoolSize(5);

		this.dataSource = comboPooledDataSource;
	}

	// Ao chamar o metodo ele apenas ir� resgatar uma conex�o j� criada e passar com
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
