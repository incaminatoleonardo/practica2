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
import persistenciaEnJDBCInscripcion.EnJDBCRegistroDeInscripcion;

class MainTestPrimerDia {

	@Test
	void test() {

		// SET UP
		// Creo el Participante
		Cartera cartera = new Cartera();
		Participante jose = new Participante("Jose", "1", cartera, 1);
		StubFechaIdParticipanteIdConcurso stubRegistro = new StubFechaIdParticipanteIdConcurso();

		// Creo el concurso
		List<Participante> participantes = new ArrayList<>();

		Concurso concursoEnDisco = new Concurso(participantes, LocalDate.now(), LocalDate.now().plusDays(7),
				new EnDiscoRegistroDeInscripcion(), 1);

		Concurso concursoEnBase = new Concurso(participantes, LocalDate.now(), LocalDate.now().plusDays(7),
				new EnJDBCRegistroDeInscripcion(), 4);

		Concurso concursoStub = new Concurso(participantes, LocalDate.now(), LocalDate.now().plusDays(7), stubRegistro,
				3);

		int cantidadPartipantes = 1;
		int cantidadDePuntos = 10;
		String registroIncripcion = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(LocalDate.now()) + ", "
				+ 1 + ", " + 3 + System.lineSeparator();

		// EXERCISE
		// concursoEnDisco.inscribirParticipante(jose);
		// concursoEnBase.inscribirParticipante(jose);
		concursoStub.inscribirParticipante(jose);

		// VERIFY

		assertEquals(cantidadPartipantes, concursoEnDisco.cantidadParticipantes());
		assertEquals(LocalDate.now(), concursoEnDisco.obtenerFechaInicial()); // Si hace falta

		assertEquals(cantidadDePuntos, jose.puntaje());

		assertEquals(registroIncripcion, stubRegistro.fechaIdParticipanteIdConcurso());// si puedo cambiar esto por
		// una
		// true o false
		// hacer un assert que compare las cadenas de caracteres y que devuelva true o
		// false

	}

}
