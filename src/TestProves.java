import static org.junit.Assert.*;

import org.junit.Test;

public class TestProves {

	@Test
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
