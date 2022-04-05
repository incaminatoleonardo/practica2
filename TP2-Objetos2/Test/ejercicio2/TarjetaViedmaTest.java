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
import modeloPedidos.Propina5porciento;
import modeloPedidos.StubFechaYCostoTotal;
import modeloPedidos.TarjetaCredito;
import modeloPedidos.itemMenu;
import persistenciaArchivoTexto.EnDiscoRegistroDeCena;
import persistenciaEnJDBC.EnJDBCRegistroDeCena;

class TarjetaViedmaTest {

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

		Pedido pedidoDisco = new Pedido(new ArrayList<>(), new ArrayList<>(), new EnDiscoRegistroDeCena());
		pedidoDisco.a�adirBebida(dosJugos);
		pedidoDisco.a�adirBebida(tresCocas);
		pedidoDisco.a�adirComida(unasPapas);
		pedidoDisco.a�adirComida(dosPanchos);

		Pedido pedidoJDBC = new Pedido(new ArrayList<>(), new ArrayList<>(), new EnJDBCRegistroDeCena());
		pedidoJDBC.a�adirBebida(dosJugos);
		pedidoJDBC.a�adirBebida(tresCocas);
		pedidoJDBC.a�adirComida(unasPapas);
		pedidoJDBC.a�adirComida(dosPanchos);

		StubFechaYCostoTotal fechaYCostoTotal = new StubFechaYCostoTotal();
		Pedido pedidoStub = new Pedido(new ArrayList<>(), new ArrayList<>(), fechaYCostoTotal);
		pedidoStub.a�adirBebida(dosJugos);
		pedidoStub.a�adirBebida(tresCocas);
		pedidoStub.a�adirComida(unasPapas);
		pedidoStub.a�adirComida(dosPanchos);

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
		assertEquals(resultadoEsperadoViedma, pedidoDisco.sumarPedidoTotal(tarjetaViedma, propina5));
		assertEquals(resultadoEsperadoViedma, pedidoJDBC.sumarPedidoTotal(tarjetaViedma, propina5));

		assertEquals(resultadoEsperadoFechaYCosto, fechaYCostoTotal.fechaYCostoTotal());

	}

}
