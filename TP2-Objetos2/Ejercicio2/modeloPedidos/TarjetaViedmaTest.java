package modeloPedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import persistenciaArchivoTexto.EnDiscoRegistroDeCena;

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

		Pedido pedido = new Pedido(new ArrayList<>(), new ArrayList<>(), new EnDiscoRegistroDeCena());
		pedido.añadirBebida(dosJugos);
		pedido.añadirBebida(tresCocas);
		pedido.añadirComida(unasPapas);
		pedido.añadirComida(dosPanchos);

		// Crear Tarjeta

		TarjetaCredito tarjetaViedma = new TarjetaCredito();

		// Crear Propina

		Propina propina5 = new Propina5porciento();

		// Creo Resultado esperado

		double resultadoEsperadoViedma = 68.25;

		// EXERCISE

		// Tarjeta Viedma
		assertEquals(resultadoEsperadoViedma, tarjetaViedma.CalcularPrecioTotal(pedido, propina5)); // Entra dos veces,
																									// la segunda cuando
																									// calcular propina,
																									// por lo tanto me
																									// escribe dos veces
																									// en el archivo

	}

}
