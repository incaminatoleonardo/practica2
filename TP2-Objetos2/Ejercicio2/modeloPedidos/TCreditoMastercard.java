package modeloPedidos;

public class TCreditoMastercard extends TarjetaCredito {

	public double CalcularPrecioTotal(Pedido pedido, Propina propina) {

		return super.CalcularPrecioTotal(pedido, propina) - (pedido.sumarPedidoComida() * 2 / 100);

	}

}
