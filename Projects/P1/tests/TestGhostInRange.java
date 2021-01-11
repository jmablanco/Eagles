import junit.framework.*;
import java.awt.Color;
import java.io.*;


public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(10, 5), "clyde", Color.orange);
		PacMan pacman = frame.addPacMan(new Location(11, 5));
		
		//check if ghost is in range
		assertTrue(pacman.is_ghost_in_range());
		frame.startGame();
	
		NoFrame frame2 = new NoFrame();
		Ghost ghost2 = frame2.addGhost(new Location(13, 7), "blinky", Color.red);
		PacMan pacman2 = frame2.addPacMan(new Location(11, 5));
		
		//check if ghost is in range
		assertTrue(pacman2.is_ghost_in_range() == false);
		frame2.startGame();

	}
}

