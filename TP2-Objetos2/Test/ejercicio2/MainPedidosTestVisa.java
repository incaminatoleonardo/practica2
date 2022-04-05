package ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modeloPedidos.CantidadItemMenu;
import modeloPedidos.Pedido;
import modeloPedidos.Propina;
import modeloPedidos.Propina3porciento;
import modeloPedidos.StubFechaYCostoTotal;
import modeloPedidos.TCreditoVisa;
import modeloPedidos.TarjetaCredito;
import modeloPedidos.itemMenu;

class MainPedidosTestVisa {

	@Test
	void test() {

		// SET UP
		// Creacion del pedido
		itemMenu coca = new itemMenu("coca", 7);
		CantidadItemMenu tresCocas = new CantidadItemMenu(coca, 3);
		itemMenu jugo = new itemMenu("jugo", 5);
		CantidadItemMenu dosJugos = new CantidadItemMenu(jugo, 2);

		itemMenu pancho = new itemMenu("pancho", 12);
		CantidadItemMenu dosPanchos = new CantidadItemMenu(pancho, 2);
		itemMenu papas = new itemMenu("papas", 10);
		CantidadItemMenu unasPapas = new CantidadItemMenu(papas, 1);

		StubFechaYCostoTotal fechaYCostoTotal = new StubFechaYCostoTotal();

		Pedido pedido = new Pedido(new ArrayList<>(), new ArrayList<>(), fechaYCostoTotal);
		pedido.a�adirBebida(dosJugos);
		pedido.a�adirBebida(tresCocas);
		pedido.a�adirComida(unasPapas);
		pedido.a�adirComida(dosPanchos);

		// Crear Tarjeta

		TarjetaCredito tarjetaVisa = new TCreditoVisa();

		// Crear Propina
		Propina propina3 = new Propina3porciento();

		// Creo Resultado esperado

		double resultadoEsperadoVisa = 66.02;
		String resultadoEsperadoFechaYCosto = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
				.format(LocalDate.now()) + " || " + resultadoEsperadoVisa + System.lineSeparator();

		// EXERCISE

		// Visa
		pedido.sumarPedidoTotal(tarjetaVisa, propina3);
		assertEquals(resultadoEsperadoFechaYCosto, fechaYCostoTotal.fechaYCostoTotal());

	}

}
