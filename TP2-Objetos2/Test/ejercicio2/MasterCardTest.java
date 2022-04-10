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
import modeloPedidos.TCreditoMastercard;
import modeloPedidos.TarjetaCredito;
import modeloPedidos.ItemMenu;

class MasterCardTest {

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
		TarjetaCredito tarjetaMaster = new TCreditoMastercard();

		// Crear Propina
		Propina propina3 = new Propina3porciento();

		// Creo Resultado esperado
		double resultadoEsperadoMasterCard = 66.27;
		String resultadoEsperadoFechaYCosto = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
				.format(LocalDate.now()) + " || " + resultadoEsperadoMasterCard + System.lineSeparator();

		// EXERCISE

		// MasterCard
		assertEquals(resultadoEsperadoMasterCard, pedido.sumarPedidoTotal(tarjetaMaster, propina3));
		assertTrue(fechaYCostoTotal.sonIguales(resultadoEsperadoFechaYCosto));

		// assertEquals(resultadoEsperadoVisa, tarjetaVisa.CalcularPrecioTotal(pedido,
		// propina3), 0.01);// aca me toma
		// hasta el
		// segundo
		// digito

	}

}
