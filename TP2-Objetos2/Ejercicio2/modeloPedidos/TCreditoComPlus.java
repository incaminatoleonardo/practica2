package modeloPedidos;

public class TCreditoComPlus extends TarjetaCredito {

	@Override
	public double CalcularPrecioTotal(Double costoTotalBebida, Double costoTotalComida) {

		return super.CalcularPrecioTotal(costoTotalBebida, costoTotalComida)
				- (super.CalcularPrecioTotal(costoTotalBebida, costoTotalComida) * 2 / 100);

	}
}
