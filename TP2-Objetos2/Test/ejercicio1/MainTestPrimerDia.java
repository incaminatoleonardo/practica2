package ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import modeloConcurso.Cartera;
import modeloConcurso.Concurso;
import modeloConcurso.Participante;
import modeloConcurso.StubFechaIdParticipanteIdConcurso;
import persistenciaArchivoTexto.EnDiscoRegistroDeInscripcion;
import persistenciaEnMemoria.EnMemoriaRegistroDeInscripcion;

class MainTestPrimerDia {

	@Test
	void test() {

		// SET UP
		// Creo el Participante
		Cartera cartera = new Cartera();
		Participante jose = new Participante("Jose", "1", cartera, 1);

		// Creo el concurso
		List<Participante> participantes = new ArrayList<>();

		Concurso concursoEnDisco = new Concurso(participantes, LocalDate.now(), LocalDate.now().plusDays(7),
				new EnDiscoRegistroDeInscripcion(), 1);

		Concurso concursoEnBase = new Concurso(participantes, LocalDate.now(), LocalDate.now().plusDays(7),
				new EnMemoriaRegistroDeInscripcion(), 2);

		int cantidadPartipantes = 1;
		int cantidadDePuntos = 10;
		String registroIncripcion = "29/3/22, 1, 1";
		StubFechaIdParticipanteIdConcurso stubRegistro = new StubFechaIdParticipanteIdConcurso(
				DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(LocalDate.now()) + ", " + 1 + ", " + 1);

		// EXERCISE
		concursoEnDisco.inscribirParticipante(jose);
		// concursoEnBase.inscribirParticipante(jose);

		// VERIFY

		assertEquals(cantidadPartipantes, concursoEnDisco.cantidadParticipantes());
		assertEquals(LocalDate.now(), concursoEnDisco.obtenerFechaInicial()); // PREGUNTAR SI ESTA BIEN USADO
		assertEquals(cantidadDePuntos, cartera.obtenerPuntaje()); // PREGUNTAR SI ESTA BIEN USADO
		assertEquals(registroIncripcion, stubRegistro.fechaIdParticipanteIdConcurso());

	}

}
