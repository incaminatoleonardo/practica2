package modeloPedidos;

public class TCreditoMastercard extends TarjetaCredito {

	@Override
	public double CalcularPrecioTotal(Double costoTotalBebida, Double costoTotalComida) {

		return super.CalcularPrecioTotal(costoTotalBebida, costoTotalComida) - (costoTotalComida * 2 / 100);

	}

}
