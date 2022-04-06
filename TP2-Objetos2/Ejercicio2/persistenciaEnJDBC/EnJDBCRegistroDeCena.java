package persistenciaEnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import modeloPedidos.RegistroCostoDeCena;

public class EnJDBCRegistroDeCena implements RegistroCostoDeCena {

	@Override
	public void registrar(String registro) {

		Connection con = null;
		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/objetos2", "root", "");
			PreparedStatement statement = (PreparedStatement) con
					.prepareStatement("INSERT INTO registroscenas(registrosCenas) VALUES (?)");

			statement.setString(1, registro);
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("No se pudo guardar en BD", e);

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new RuntimeException("No pudo cerrar conexion", e);

				}
			}
		}
	}

}
