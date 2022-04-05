package modeloConcurso;

public class StubFechaIdParticipanteIdConcurso implements RegistroDeInscripcion {

	private String fechaIdParticipanteIdConcurso;

	public StubFechaIdParticipanteIdConcurso() {

	}

	public String fechaIdParticipanteIdConcurso() {
		return this.fechaIdParticipanteIdConcurso;
	}

	@Override
	public void registrar(String registro) {
		this.fechaIdParticipanteIdConcurso = registro;

	}

}
