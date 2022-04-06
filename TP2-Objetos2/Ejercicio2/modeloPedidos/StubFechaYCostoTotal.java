package modeloPedidos;

public class StubFechaYCostoTotal implements RegistroCostoDeCena {

	private String fechaYCostoTotal;

	@Override
	public void registrar(String registro) {
		this.fechaYCostoTotal = registro;

	}

	public String fechaYCostoTotal() {
		return this.fechaYCostoTotal;
	}

	public boolean sonIguales(String registro) {

		if (this.fechaYCostoTotal.compareTo(registro) == 0) {
			return true;
		}

		return false;
	}

}
