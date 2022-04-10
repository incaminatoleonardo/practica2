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
import modeloPedidos.Propina5porciento;
import modeloPedidos.StubFechaYCostoTotal;
import modeloPedidos.TarjetaCredito;
import modeloPedidos.ItemMenu;

class TarjetaViedmaTest {

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

		Pedido pedidoStub = new Pedido(new ArrayList<>(), new ArrayList<>(), fechaYCostoTotal);
		pedidoStub.añadirBebida(dosJugos);
		pedidoStub.añadirBebida(tresCocas);
		pedidoStub.añadirComida(unasPapas);
		pedidoStub.añadirComida(dosPanchos);

		// Crear Tarjeta

		TarjetaCredito tarjetaViedma = new TarjetaCredito();

		// Crear Propina

		Propina propina5 = new Propina5porciento();

		// Creo Resultado esperado

		double resultadoEsperadoViedma = 68.25;
		String resultadoEsperadoFechaYCosto = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
				.format(LocalDate.now()) + " || " + resultadoEsperadoViedma + System.lineSeparator();

		// EXERCISE

		pedidoStub.sumarPedidoTotal(tarjetaViedma, propina5);

		// Tarjeta Viedma

		assertEquals(resultadoEsperadoViedma, pedidoStub.sumarPedidoTotal(tarjetaViedma, propina5));
		assertTrue(fechaYCostoTotal.sonIguales(resultadoEsperadoFechaYCosto));

	}

}
