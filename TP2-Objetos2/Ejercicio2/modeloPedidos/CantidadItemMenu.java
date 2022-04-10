package modeloPedidos;

public class CantidadItemMenu {

	private ItemMenu itemMenu;
	private int cantidad;

	public CantidadItemMenu(ItemMenu itemMenu, int cantidad) {
		super();
		this.itemMenu = itemMenu;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "CantidadItemMenu [itemMenu=" + itemMenu + ", cantidad=" + cantidad + "]";
	}

	public double sumarComestibles() {

		double costo = 0;

		costo = costo + this.itemMenu.obtenerCosto() * this.cantidad;

		return costo;
	}

}
