import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
		//Creating A Map 
		//Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
		int x = 2; 
		int y = 2; 
		//Creating Players
		PacMan pacman = frame.addPacMan(new Location(x, y)); //Creates PacMan at location x, y
		//Start The Game
		//frame.startGame();
		Map map = frame.getMap(); 

		//Checks if PACMAN is at location before the move.
		assertTrue(map.getLoc(new Location(x,y)).contains(Map.Type.PACMAN)); 

		//Move pacman
		pacman.move();

		//Checks if PACMAN was removed from location after move.
		assertFalse(map.getLoc(new Location(x,y)).contains(Map.Type.PACMAN)); 

	}
}
