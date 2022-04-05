package modeloPedidos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class Pedido {

	private List<CantidadItemMenu> itemMenuBebidas;
	private List<CantidadItemMenu> itemMenuComidas;
	private RegistroCostoDeCena registro;

	public Pedido(List<CantidadItemMenu> itemMenuBebidas, List<CantidadItemMenu> itemMenuComidas,
			RegistroCostoDeCena registro) {
		super();
		this.itemMenuBebidas = itemMenuBebidas;
		this.itemMenuComidas = itemMenuComidas;
		this.registro = registro;
	}

	public void añadirBebida(CantidadItemMenu comestible) {

		itemMenuBebidas.add(comestible);

	}

	public void añadirComida(CantidadItemMenu comestible) {

		itemMenuComidas.add(comestible);

	}

	public double sumarPedidoBebida() {

		double costoBebida = 0;
		for (CantidadItemMenu cantidadItemMenu : itemMenuBebidas) {

			costoBebida = costoBebida + cantidadItemMenu.sumarComestibles();

		}

		return costoBebida;
	}

	public double sumarPedidoComida() {

		double costoComida = 0;
		for (CantidadItemMenu cantidadItemMenu : itemMenuComidas) {

			costoComida = costoComida + cantidadItemMenu.sumarComestibles();

		}

		return costoComida;
	}

	public double sumarPedidoTotal(TarjetaCredito tarjeta, Propina propina) {

		double costoTotal = tarjeta.CalcularPrecioTotal(sumarPedidoBebida(), sumarPedidoComida())
				+ propina.CalcularPropina(sumarPedidoBebida() + sumarPedidoComida());

		String fechaYCostoTotal = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(LocalDate.now()) + " || "
				+ costoTotal + "\n";
		this.registro.registrar(fechaYCostoTotal);

		return costoTotal;
	}

	@Override
	public String toString() {
		return "Pedido [itemMenuBebidas=" + itemMenuBebidas.toString() + ", itemMenuComidas="
				+ itemMenuComidas.toString() + "]";
	}

}
