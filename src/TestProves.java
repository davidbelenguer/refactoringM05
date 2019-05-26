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
	
	private String textOriginal = "Informe de lloguers del client David (123456789A)\n" + 
			"	Renault Clio: 90.0€\n" + 
			"	Audi A3: 495.0€\n" + 
			"	Porsche  Panamera: 720.0€\n" + 
			"Import a pagar: 1305.0€\n" + 
			"Punts guanyats: 4\n";
	
	private String textBuit = "Informe de lloguers del client David (123456789A)\n" + 
			"Import a pagar: 0.0€\n" + 
			"Punts guanyats: 0\n";
	
	private String textUn = "Informe de lloguers del client David (123456789A)\n" + 
			"	Renault Clio: 90.0€\n" +  
			"Import a pagar: 90.0€\n" + 
			"Punts guanyats: 1\n";
	
	private String textGeneralUnDia = "Informe de lloguers del client David (123456789A)\n" + 
			"	Renault Clio: 90.0€\n" +  
			"Import a pagar: 90.0€\n" + 
			"Punts guanyats: 1\n";
	
	private String textLloguerTotal = "Informe de lloguers del client David (123456789A)\n" + 
			"	Renault Clio: 630.0€\n" + 
			"	Audi A3: 3720.0€\n" + 
			"	Porsche  Panamera: 18000.0€\n" + 
			"Import a pagar: 22350.0€\n" + 
			"Punts guanyats: 4\n";
	
	private String textOriginalHTML = "<h1>Informe de lloguers</h1>\n" + 
			"<p>Informe de lloguers del client <em>David </em> (<strong>123456789A</strong>)</p>\n" + 
			"<table>\n" + 
			"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>	<tr><td>Renault</td><td>Clio</td><td>90.0€</td></tr>\n"+
			"    <tr><td>Audi</td><td>A3</td><td>495.0€</td></tr>\n" + 
			"    <tr><td>Porsche</td><td>Panamera</td><td>720.0€</td></tr>\n" + 
			"</table>\n" + 
			"<p>Import a pagar: <em>1305.0€</em></p>\n" + 
			"<p>Punts guanyats: <em>4</em></p>";
	
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
		
		assertEquals(textOriginal, client.informe());
	}
	
	@Test
	public void testBuit() throws ParseException {
		Date fecha = dateFormat.parse("8/09/2014");
		lloguer = new Lloguer(fecha, 2, basic);
		
		Date fecha2 = dateFormat.parse("4/02/2010");
		lloguer = new Lloguer(fecha2, 7, mitja);
		
		Date fecha3 = dateFormat.parse("19/12/2018"); 
		lloguer = new Lloguer(fecha3, 4, alt);
		
		assertEquals(textBuit, client.informe());
	}
	@Test
	public void testUnDosDies() throws ParseException {
		Date fecha = dateFormat.parse("8/09/2014");
		lloguer = new Lloguer(fecha, 2, basic);
		client.afegeix(lloguer);
		
		assertEquals(textUn, client.informe());
	}
	@Test
	public void testGeneralUnDia() throws ParseException {
		Date fecha = dateFormat.parse("8/09/2014");
		lloguer = new Lloguer(fecha, 1, basic);
		client.afegeix(lloguer);
		
		assertEquals(textGeneralUnDia, client.informe());
	}
	@Test
	public void testLloguerTotal() throws ParseException {
		Date fecha = dateFormat.parse("8/09/2014");
		lloguer = new Lloguer(fecha, 15, basic);
		client.afegeix(lloguer);
		Date fecha2 = dateFormat.parse("4/02/2010");
		lloguer = new Lloguer(fecha2, 50, mitja);
		client.afegeix(lloguer);
		Date fecha3 = dateFormat.parse("19/12/2018"); 
		lloguer = new Lloguer(fecha3, 100, alt);
		client.afegeix(lloguer);
		
		assertEquals(textLloguerTotal, client.informe());
	}
	
	/**
	 * PROVES UNITARIES INFORME HTML
	 * 
	 */
	@Test
	public void testOriginalHTML() throws ParseException {
		Date fecha = dateFormat.parse("8/09/2014");
		lloguer = new Lloguer(fecha, 2, basic);
		client.afegeix(lloguer);
		Date fecha2 = dateFormat.parse("4/02/2010");
		lloguer = new Lloguer(fecha2, 7, mitja);
		client.afegeix(lloguer);
		Date fecha3 = dateFormat.parse("19/12/2018"); 
		lloguer = new Lloguer(fecha3, 4, alt);
		client.afegeix(lloguer);
		
		assertEquals(textOriginalHTML, client.informeHTML());
	}
	
	
	
	
	
	
	
}
