package modeloPedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import persistenciaArchivoTexto.EnDiscoRegistroDeCena;

class MasterCardTest {

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
		TarjetaCredito tarjetaMaster = new TCreditoMastercard();

		// Crear Propina
		Propina propina3 = new Propina3porciento();

		// Creo Resultado esperado
		double resultadoEsperadoMasterCard = 66.27;

		// EXERCISE

		// MasterCard
		assertEquals(resultadoEsperadoMasterCard, tarjetaMaster.CalcularPrecioTotal(pedido, propina3));

	}

}
