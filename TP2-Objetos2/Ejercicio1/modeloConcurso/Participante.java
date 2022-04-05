package modeloConcurso;

public class Participante {

	private int idParticipante;
	private String nombre;
	private String dni;
	private Cartera cartera;

	public Participante(String nombre, String dni, Cartera cartera, int idParticipante) {
		super();
		this.idParticipante = idParticipante;
		this.nombre = nombre;
		this.dni = dni;
		this.cartera = cartera;
	}

	public void sumarPuntaje() {
		this.cartera.sumarPuntaje();
	}

	public int puntaje() {
		return cartera.obtenerPuntaje();
	}

	/*
	 * public String nombre() { return this.nombre; }
	 */

	public int idParticipante() {
		return this.idParticipante;
	}

	// NO LO USO
	public void imprimirPuntaje() {
		System.out.println(cartera.toString());
	}

	@Override
	public String toString() {
		return "Participante [nombre=" + nombre + ", dni=" + dni + ", cartera=" + cartera + "]";
	}

}
