import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
public class TestProves {
	
	private Client client;
	private Vehicle basic;
	private Vehicle mitja;
	private Vehicle alt;
	private Lloguer lloguer;
	SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
	
	
	
	public void setUp() {
		client = new Client("12345678B", "David", "664754002");
		basic = new Vehicle("Clio", "Renault", Vehicle.Basic);
		mitja = new Vehicle("A3", "Audi", Vehicle.Mitja);
		alt = new Vehicle("Panamera.", "Porsche ", Vehicle.Alt);
	}
	
	@Test
	public void testBasic() throws ParseException {
		Date fecha = dateFormat.parse("8/09/2014");
		lloguer = new Lloguer(fecha, 3, basic);
		assertEquals( client.informe (), 2);
	}
	
	@Test
	public void testMitja() throws ParseException {
		Date fecha = dateFormat.parse("4/02/2010");
		lloguer = new Lloguer(fecha, 1, mitja);
		assertEquals( client.informe (), 4);
	}
	
	@Test
	public void testAlt() throws ParseException {
		Date fecha = dateFormat.parse("19/12/2018"); 
		lloguer = new Lloguer(fecha, 8, alt);
		assertEquals( client.informe (), 3);
	}
	public void Clientinforme() {
		Client client1 = new Client("14789547B", "david", "666888774");
		
				
		double total = 14;
		int bonificacions = 5;
		double quantitat = 7;
		
		client1.setNom("David");
		client1.getNom();
		client1.getNif();
		
		String result = "";
		String resultado = client1.informe();
		/*quantitat +=3;
		bonificacions +=10;
		total += 14;*/
		assertEquals(result,resultado);
		
		
	}

}
