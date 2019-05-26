
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GestorLloguersLite {

	public static void main(String[] args) throws ParseException {
		// creamos un cliente
		Client client1 = new Client("123456789A", "David", "666666666");
		
		//creamos los tres vehiculos
		Vehicle vehicleBasic = new Vehicle("Clio", "Renault", Vehicle.Basic);
		Vehicle vehicleMitja = new Vehicle("A3", "Audi", Vehicle.Mitja);
		Vehicle vehicleAlt = new Vehicle("Panamera", "Porsche", Vehicle.Alt);
		
		
		//creamos tres alquileres
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = dateFormat.parse("2/8/2013");
		Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);
		Client.afegeix(lloguerBasic);
		
		Date date2 = dateFormat.parse("8/09/2014");
		Lloguer lloguerMitja = new Lloguer(date2, 7, vehicleMitja);
		Client.afegeix(lloguerMitja);
		
		Date date3 = dateFormat.parse("4/12/2014");
		Lloguer lloguerAlt = new Lloguer(date3, 4, vehicleAlt);
		Client.afegeix(lloguerAlt);
		
		// demostració de formatat d'una data
		System.out.println(dateFormat.format(lloguerBasic.getData()));
		System.out.println(dateFormat.format(lloguerMitja.getData()));
		System.out.println(dateFormat.format(lloguerAlt.getData()));
		
		//mostrar datos
		//System.out.println(client1.mostrarDatos());
		System.out.println(client1.informe());
		System.out.println(client1.informeHTML());
		
	}

	

	

}
