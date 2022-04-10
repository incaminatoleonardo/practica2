package ejercicio2;

import static org.junit.Assert.assertTrue;
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
import modeloPedidos.ItemMenu;

class MainPedidosTestVisa {

	@Test
	void test() {

		// SET UP
		// Creacion del pedido
		ItemMenu coca = new ItemMenu("coca", 7);
		CantidadItemMenu tresCocas = new CantidadItemMenu(coca, 3);
		ItemMenu jugo = new ItemMenu("jugo", 5);
		CantidadItemMenu dosJugos = new CantidadItemMenu(jugo, 2);

		ItemMenu pancho = new ItemMenu("pancho", 12);
		CantidadItemMenu dosPanchos = new CantidadItemMenu(pancho, 2);
		ItemMenu papas = new ItemMenu("papas", 10);
		CantidadItemMenu unasPapas = new CantidadItemMenu(papas, 1);

		StubFechaYCostoTotal fechaYCostoTotal = new StubFechaYCostoTotal();

		Pedido pedido = new Pedido(new ArrayList<>(), new ArrayList<>(), fechaYCostoTotal);
		pedido.añadirBebida(dosJugos);
		pedido.añadirBebida(tresCocas);
		pedido.añadirComida(unasPapas);
		pedido.añadirComida(dosPanchos);

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
		assertEquals(resultadoEsperadoVisa, pedido.sumarPedidoTotal(tarjetaVisa, propina3));
		assertTrue(fechaYCostoTotal.sonIguales(resultadoEsperadoFechaYCosto)); // Esta es la forma correcta para no
																				// hacer un get
		assertEquals(resultadoEsperadoFechaYCosto, fechaYCostoTotal.fechaYCostoTotal());

	}

}
