package modeloPedidos;

public class itemMenu {

	private String descripcion;
	private double costo;

	public itemMenu(String descripcion, double costo) {
		super();
		this.descripcion = descripcion;
		this.costo = costo;
	}

	public double obtenerCosto() {

		return this.costo;

	}

	@Override
	public String toString() {
		return "itemMenu [descripcion=" + descripcion + ", costo=" + costo + "]";
	}

}
