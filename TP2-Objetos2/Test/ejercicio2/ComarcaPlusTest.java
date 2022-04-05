package ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modeloPedidos.CantidadItemMenu;
import modeloPedidos.Pedido;
import modeloPedidos.Propina;
import modeloPedidos.Propina2porciento;
import modeloPedidos.TCreditoComPlus;
import modeloPedidos.TarjetaCredito;
import modeloPedidos.itemMenu;
import persistenciaArchivoTexto.EnDiscoRegistroDeCena;

class ComarcaPlusTest {

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
		pedido.a�adirBebida(dosJugos);
		pedido.a�adirBebida(tresCocas);
		pedido.a�adirComida(unasPapas);
		pedido.a�adirComida(dosPanchos);

		// Crear Tarjeta

		TarjetaCredito tarjetaPlus = new TCreditoComPlus();

		// Crear Propina

		Propina propina2 = new Propina2porciento();

		// Creo Resultado esperado

		double resultadoEsperadoPlus = 65.00;

		// EXERCISE

		assertEquals(resultadoEsperadoPlus, pedido.sumarPedidoTotal(tarjetaPlus, propina2));

	}

}
