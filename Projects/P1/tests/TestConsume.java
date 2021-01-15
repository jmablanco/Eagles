import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {
		//Creating A Map 
		//Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
		Map map = frame.getMap(); 
		int x = 9, y = 12;
		//Creating Players
		//Ghost ghost = frame.addGhost(new Location(x, y), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(x, y)); //Creates PacMan at location x, y

		//alternatively if you don't need the PacMan or Ghost objects in your tests
		//frame.initPlayers(); //Creates all of the players

		//Start The Game
		//frame.startGame();
		assertTrue(pacman.consume() == null); 

		CookieComponent tok = new CookieComponent(x,y,frame.scale);
		map.add("tok_x"+x+"_y"+y, new Location(x, y), tok, Map.Type.COOKIE);
		tok.setLocation(x, y);
		assertTrue(pacman.consume() != null); 

	}
}
