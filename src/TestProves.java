import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
public class TestProves {
	
	private Client client;
	private Vehicle basic;
	private Vehicle mitja;
	private Vehicle alt;
	private Lloguer lloguer;
	/*private String textOriginal = "Informe de lloguers del client David (123456789A)\n"+
			"	Renault Clio: 90.0€\n"+
			"	Audi A3: 495.0€\n"+
			"	Porsche Panamera: 720.0€\n"+
		"Import a pagar: 1305.0€\n"+
		"Punts guanyats: 4\n";*/
	private String textOriginal = "Informe de lloguers del client David (123456789A)\n" + 
			"	Renault Clio: 90.0€\n" + 
			"	Audi A3: 495.0€\n" + 
			"	Porsche  Panamera: 720.0€\n" + 
			"Import a pagar: 1305.0€\n" + 
			"Punts guanyats: 4\n";
	SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
	
	
	@Before
	public void setUp() {
		client = new Client("123456789A", "David", "666666666");
		basic = new Vehicle("Clio","Renault", Vehicle.Basic);
		mitja = new Vehicle("A3", "Audi", Vehicle.Mitja);
		alt = new Vehicle("Panamera", "Porsche ", Vehicle.Alt);
	}
	
	@Test
	public void testBasic() throws ParseException {
		Date fecha = dateFormat.parse("8/09/2014");
		lloguer = new Lloguer(fecha, 2, basic);
		client.afegeix(lloguer);
		Date fecha2 = dateFormat.parse("4/02/2010");
		lloguer = new Lloguer(fecha2, 7, mitja);
		client.afegeix(lloguer);
		Date fecha3 = dateFormat.parse("19/12/2018"); 
		lloguer = new Lloguer(fecha3, 4, alt);
		client.afegeix(lloguer);
		System.out.println("textOriginalX abans de l'assert");
		assertEquals(textOriginal, client.informe());
	}
	
	/*@Test
	public void testMitja() throws ParseException {
		
		assertEquals(textOriginal,client.informe ());
	}
	
	@Test
	public void testAlt() throws ParseException {
		
		assertEquals(textOriginal, client.informe ());
	}*/
	
	
	/*public void Clientinforme() {
		Client client1 = new Client("14789547B", "david", "666888774");
		
				
		double total = 14;
		int bonificacions = 5;
		double quantitat = 7;
		
		client1.setNom("David");
		client1.getNom();
		client1.getNif();
		
		String result = "";
		String resultado = client1.informe();
		quantitat +=3;
		bonificacions +=10;
		total += 14;
		assertEquals(result,resultado);
		
		
	}*/

}
