package modeloConcurso;

public class Cartera {

	private int puntaje;
	private int bonificacion = 10;

	public void sumarPuntaje() {
		puntaje = +bonificacion;
	}

	public String toString() {
		return "Cartera [puntaje=" + puntaje + "]";
	}

	public int obtenerPuntaje() {
		return this.puntaje;
	}

}
