package ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modeloPedidos.CantidadItemMenu;
import modeloPedidos.Pedido;
import modeloPedidos.Propina;
import modeloPedidos.Propina3porciento;
import modeloPedidos.TCreditoMastercard;
import modeloPedidos.TarjetaCredito;
import modeloPedidos.itemMenu;
import persistenciaEnJDBC.EnJDBCRegistroDeCena;

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

		Pedido pedido = new Pedido(new ArrayList<>(), new ArrayList<>(), new EnJDBCRegistroDeCena());
		pedido.a�adirBebida(dosJugos);
		pedido.a�adirBebida(tresCocas);
		pedido.a�adirComida(unasPapas);
		pedido.a�adirComida(dosPanchos);

		// Crear Tarjeta
		TarjetaCredito tarjetaMaster = new TCreditoMastercard();

		// Crear Propina
		Propina propina3 = new Propina3porciento();

		// Creo Resultado esperado
		double resultadoEsperadoMasterCard = 66.27;

		// EXERCISE

		// MasterCard
		assertEquals(resultadoEsperadoMasterCard, pedido.sumarPedidoTotal(tarjetaMaster, propina3));

		// assertEquals(resultadoEsperadoVisa, tarjetaVisa.CalcularPrecioTotal(pedido,
		// propina3), 0.01);// aca me toma
		// hasta el
		// segundo
		// digito

	}

}
