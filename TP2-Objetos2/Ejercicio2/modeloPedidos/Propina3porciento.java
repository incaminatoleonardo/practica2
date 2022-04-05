package modeloPedidos;

public class Propina3porciento extends Propina {

	@Override
	public double CalcularPropina(double costoTotal) {

		return (costoTotal * 3 / 100);
	}
}
