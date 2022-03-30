package persistenciaEnMemoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import modeloPedidos.RegistroCostoDeCena;

public class EnMemoriaRegistroDeCena implements RegistroCostoDeCena {

	@Override
	public void registrar(String registro) {

		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/objetos2", "root", "");
			PreparedStatement statement = (PreparedStatement) con
					.prepareStatement("INSERT INTO registroscenas(registrosCenas) VALUES (?)");

			statement.setString(1, registro);
			statement.executeUpdate();

			// Statement st = con.createStatement();
			// st.executeUpdate("INSERT INTO registroinscripcion(registroInscripcion) VALUES
			// (?)");
			// st.setCursorName(registro);

		} catch (SQLException e) {
			System.out.println("Error al procesar consulta");

		}
	}

}
