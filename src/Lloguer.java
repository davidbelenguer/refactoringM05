
import java.util.Date;
import java.util.Vector;

public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle;
	
	public Lloguer(Date date, int dies, Vehicle vehicle) {
		super();
		this.data = date;
		this.dies = dies;
		this.vehicle = vehicle;
	}

	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getDies() {
		return dies;
	}

	public void setDies(int dies) {
		this.dies = dies;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public double quantitat() {
		double quantitat = 0;
		switch (getVehicle().getCategoria()) {
		case Vehicle.Basic:
			quantitat += 3;
			if (getDies() > 3) {
				quantitat += (getDies() - 3) * 1.5;
			}
			break;
		case Vehicle.Mitja:
			quantitat += 4;
			if (getDies() > 2) {
				quantitat += (getDies() - 2) * 2.5;
			}
			break;
		case Vehicle.Alt:
			quantitat += getDies() * 6;
			break;
		}
		return quantitat;
	}
	

}
