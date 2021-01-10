import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException{
		//Creating A Map 
		//Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
		int x = 2, y = 2; 
		//Creating Players
		Ghost ghost = frame.addGhost(new Location(x, y), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(x+1, y+1)); //Creates PacMan at location x, y
		Ghost ghost2 = frame.addGhost(new Location(x+4, y+4), "name2", Color.red); //Creates a red ghost named "name" at location x,y

		//Start The Game
		frame.startGame();		

		assertTrue(ghost.is_pacman_in_range()); 
		assertFalse(ghost2.is_pacman_in_range()); 

	}
}

