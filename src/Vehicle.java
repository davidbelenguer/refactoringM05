
public class Vehicle {
	
	private String model;
	private String marca;
	private String categoria;
	
	public static final String Basic = "basic";
	public static final String Mitja = "mitja";
	public static final String Alt = "alt";
	
	public Vehicle(String model, String marca, String categoria) {
		this.model = model;
		this.marca = marca;
		this.categoria = categoria;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
