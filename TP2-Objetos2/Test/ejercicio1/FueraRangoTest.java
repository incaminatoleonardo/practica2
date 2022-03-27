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

class FueraRangoTest {

	@Test
	void test() {

		// SET UP
		// Creo el Participante
		Cartera cartera = new Cartera();

		Participante juan = new Participante("Juan", "2", cartera, 2);

		// Creo el concurso

		List<Participante> participantesFueraRango = new ArrayList<>();

		Concurso concursoFueraRango = new Concurso(participantesFueraRango, LocalDate.now().plusMonths(1),
				LocalDate.now().plusMonths(2), new EnDiscoRegistroDeInscripcion(), 2);

		int cantidadPartipantesFueraRango = 0;

		// EXERCISE
		try {
			concursoFueraRango.inscribirParticipante(juan);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// VERIFY

		assertEquals(cantidadPartipantesFueraRango, concursoFueraRango.cantidadParticipantes());

	}

}
