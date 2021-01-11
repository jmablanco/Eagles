import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie {
	
	public void testMapEatCookie() {
		NoFrame frame = new NoFrame();
		int x = 1;
		int y = 1;
		PacMan pacman = frame.addPacMan(new Location(x, y));
		
		//Will consume the first cookie and will return true.
		assertTrue(frame.getMap().eatCookie("pacman") != null);
		// There is no cookie to consume so it will return false.
		assertFalse(frame.getMap().eatCookie("pacman") != null);
	}
}
