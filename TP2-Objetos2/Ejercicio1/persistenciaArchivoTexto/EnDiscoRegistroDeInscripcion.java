package persistenciaArchivoTexto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import modeloConcurso.RegistroDeInscripcion;

public class EnDiscoRegistroDeInscripcion implements RegistroDeInscripcion {

	@Override
	public void registrar(String registro) {
		try {
			Files.write(Paths.get("C:\\Users\\Frodo\\Desktop\\Uni\\Objetos 2\\inscriptos.txt"), registro.getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo guardar en disco", e);
		}

	}

}
