
import java.util.Date;
import java.util.Vector;

public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle;
	private static final double EUROS_PER_UNITAT_DE_COST_BASIC = 3;
	private static final double DIES_INICI_VEHI_BASIC = 3;
	private static final double EUROS_PER_DIES_INICI_BASIC = 1.5;
	private static final double EUROS_PER_UNITAT_DE_COST_MITJA = 4;
	private static final double DIES_INICI_VEHICLE_MITJA = 2;
	private static final double EUROS_PER_DIES_INICI_MITJA = 2.5;
	private static final double EUROS_PER_DIES_VEHICLE_ALT = 6;
	
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
			quantitat += EUROS_PER_UNITAT_DE_COST_BASIC;
			if (getDies() > DIES_INICI_VEHI_BASIC) {
				quantitat += (getDies() - 3) * EUROS_PER_DIES_INICI_BASIC;
			}
			break;
		case Vehicle.Mitja:
			quantitat += EUROS_PER_UNITAT_DE_COST_MITJA;
			if (getDies() > DIES_INICI_VEHICLE_MITJA) {
				quantitat += (getDies() - 2) * EUROS_PER_DIES_INICI_MITJA;
			}
			break;
		case Vehicle.Alt:
			quantitat += getDies() * EUROS_PER_DIES_VEHICLE_ALT;
			break;
		}
		return quantitat;
	}
	
	
	public int bonificacions() {
		int bonificacions = 0;
		// afegeix lloguers freqüents
		bonificacions++;
		// afegeix bonificació per dos dies de lloguer de Luxe
		if (getVehicle().getCategoria() == Vehicle.Alt && 
				getDies() > 1) {
			bonificacions++;
		}
		return bonificacions;

	}

}
