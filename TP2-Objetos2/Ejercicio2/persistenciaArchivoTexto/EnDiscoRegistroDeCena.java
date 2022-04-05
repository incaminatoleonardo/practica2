package persistenciaArchivoTexto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import modeloPedidos.RegistroCostoDeCena;

public class EnDiscoRegistroDeCena implements RegistroCostoDeCena {

	private String pathCasa = "C:\\Users\\Frodo\\Desktop\\Uni\\Objetos 2\\cenas.txt";
	private String pathNote = "C:\\Users\\Marii\\OneDrive\\Escritorio\\Uni\\cenas.txt";

	@Override
	public void registrar(String registro) {
		try {
			Files.write(Paths.get(pathCasa), registro.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo guardar en disco", e);
		}

	}

}
