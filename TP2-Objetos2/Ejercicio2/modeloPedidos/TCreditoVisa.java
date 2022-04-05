package modeloPedidos;

public class TCreditoVisa extends TarjetaCredito {

	@Override
	public double CalcularPrecioTotal(Double costoTotalBebida, Double costoTotalComida) {

		return super.CalcularPrecioTotal(costoTotalBebida, costoTotalComida) - (costoTotalBebida * 3 / 100);

	}

}
