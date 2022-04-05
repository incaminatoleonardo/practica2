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

}
