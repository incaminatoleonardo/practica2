package persistenciaArchivoTexto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import modeloPedidos.RegistroCostoDeCena;

public class EnDiscoRegistroDeCena implements RegistroCostoDeCena {

	@Override
	public void registrar(String registro) {
		try {
			Files.write(Paths.get("C:\\Users\\Frodo\\Desktop\\Uni\\Objetos 2\\cenas.txt"), registro.getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo guardar en disco", e);
		}

	}

}
