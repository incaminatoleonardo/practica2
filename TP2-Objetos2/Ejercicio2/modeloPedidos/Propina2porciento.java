package modeloPedidos;

public class Propina2porciento extends Propina {

	@Override
	public double CalcularPropina(double costoTotal) {
		return (costoTotal * 2 / 100);
	}

}
