package modeloPedidos;

public class Propina5porciento extends Propina {

	@Override
	public double CalcularPropina(double costoTotal) {

		return (costoTotal * 5 / 100);
	}
}
