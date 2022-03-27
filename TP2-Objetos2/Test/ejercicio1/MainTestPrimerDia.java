package ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import modeloConcurso.Cartera;
import modeloConcurso.Concurso;
import modeloConcurso.Participante;
import persistenciaArchivoTexto.EnDiscoRegistroDeInscripcion;

class MainTestPrimerDia {

	@Test
	void test() {

		// SET UP
		// Creo el Participante
		Cartera cartera = new Cartera();
		Participante jose = new Participante("Jose", "1", cartera, 1);

		// Creo el concurso
		List<Participante> participantes = new ArrayList<>();

		Concurso concurso = new Concurso(participantes, LocalDate.now(), LocalDate.now().plusDays(7),
				new EnDiscoRegistroDeInscripcion(), 1);

		int cantidadPartipantes = 1;
		int cantidadDePuntos = 10;
		String registroIncripcion = "27/3/22, 1, 1";

		// EXERCISE
		concurso.inscribirParticipante(jose);

		// VERIFY

		assertEquals(cantidadPartipantes, concurso.cantidadParticipantes());
		assertEquals(LocalDate.now(), concurso.obtenerFechaInicial()); // PREGUNTAR SI ESTA BIEN USADO
		assertEquals(cantidadDePuntos, cartera.obtenerPuntaje()); // PREGUNTAR SI ESTA BIEN USADO
		// assertEquals(registroIncripcion, En);

	}

}
