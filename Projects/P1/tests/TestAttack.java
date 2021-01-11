import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(10, 5), "clyde", Color.orange);
		Ghost ghost2 = frame.addGhost(new Location(12, 10), "blinky", Color.red);
		PacMan pacman = frame.addPacMan(new Location(11, 5));
		frame.startGame();

		//Ghost 2 is not by pacman, should return false;
		assertFalse(ghost2.attack());
		//Game should not be over
		assertFalse(frame.getMap().isGameOver())

		//Ghost is by pacman, and should be able to attack
		assertTrue(ghost.attack());
		//Game should be over
		assertTrue(frame.getMap().isGameOver());
	}
}
