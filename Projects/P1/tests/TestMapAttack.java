import java.awt.Color;
import junit.framework.*;
import java.io.*;

public class TestMapAttack extends TestCase{

	public void testMapAttack() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(10, 5), "clyde", Color.orange);
		Ghost ghost2 = frame.addGhost(new Location(12, 10), "blinky", Color.red);
		PacMan pacman = frame.addPacMan(new Location(11, 5));
		
		assertTrue(frame.getMap().attack("clyde"));
		assertFalse(frame.getMap().attack("blinky"));
	}
}
