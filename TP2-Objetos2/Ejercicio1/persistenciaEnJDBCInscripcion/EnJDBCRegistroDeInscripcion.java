package persistenciaEnJDBCInscripcion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import modeloConcurso.RegistroDeInscripcion;

// llamar JDBC
public class EnJDBCRegistroDeInscripcion implements RegistroDeInscripcion {

	@Override
	public void registrar(String registro) {

		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/objetos2", "root", "");
			PreparedStatement statement = (PreparedStatement) con
					.prepareStatement("INSERT INTO registroinscripcion(registroInscripcion) VALUES (?)");

			statement.setString(1, registro);
			statement.executeUpdate();

			// sacar todos los syso
		} catch (SQLException e) {
			System.out.println("Error al procesar consulta");

		} catch (Exception e) {
			System.out.println("Error al insertar un registro");

		} // cerrar la conexion con finaly

	}

}
