package modeloConcurso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class Concurso {

	private int idConcurso;
	private List<Participante> participantes;
	private LocalDate fechaInicial;
	private LocalDate fechaFinal;
	private RegistroDeInscripcion registro;

	public Concurso(List<Participante> participantes, LocalDate fechaInicial, LocalDate fechaFinal,
			RegistroDeInscripcion registro, int idConcurso) {
		super();
		this.idConcurso = idConcurso;
		this.participantes = participantes;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.registro = registro;
	}

	public void inscribirParticipante(Participante participante) {

		if ((this.fechaInicial.isBefore(LocalDate.now()) || this.fechaInicial.isEqual(LocalDate.now()))
				&& this.fechaFinal.isAfter(LocalDate.now())) {

			participantes.add(participante);

			String fechaIdParticipanteIdConcurso = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
					.format(LocalDate.now()) + ", " + participante.idParticipante() + ", " + this.idConcurso
					+ System.lineSeparator();
			this.registro.registrar(fechaIdParticipanteIdConcurso);

			if (this.fechaInicial.isEqual(LocalDate.now())) {
				participante.sumarPuntaje();

			}
		} else {
			throw new RuntimeException("Se encuentra fuera de las fechas de inscripcion");

		}

	}

	public void imprimirFechaInicial() {
		System.out.println(this.fechaInicial);

	}

	@Override
	public String toString() {
		return "Concurso [participantes=" + participantes + "]";
	}

	public int cantidadParticipantes() {

		return participantes.size();
	}

	public LocalDate obtenerFechaInicial() {
		return this.fechaInicial;
	}

}
