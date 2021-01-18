import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie extends TestCase{
	
	public void testMapEatCookie() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		Map myMap = frame.getMap();
		int scale = frame.scale;  
		int x = 1;
		int y = 1;
		Location loc = new Location(x, y); 

		PacMan pacman = frame.addPacMan(loc);
		CookieComponent tok = new CookieComponent(x,y,scale);
		myMap.add("tok_x"+x+"_y"+y, loc, tok, Map.Type.COOKIE);
		tok.setLocation(x, y);
		
		//Will consume the first cookie and will return true.
		assertTrue(frame.getMap().eatCookie("pacman") != null);
		// There is no cookie to consume so it will return false.
		assertFalse(frame.getMap().eatCookie("pacman") != null);
	}
}
