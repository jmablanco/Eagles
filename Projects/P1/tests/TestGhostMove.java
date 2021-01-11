import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(10, 10), "blinky", Color.red);
		PacMan pacman = frame.addPacMan(new Location(20, 20));
		
		//Check if ghost has valid move & if it will change location
		if(ghost.get_valid_moves().size() > 0) {
			assertTrue(ghost.move());
		}else {
			assertFalse(ghost.move());
		}
		
	}
}
