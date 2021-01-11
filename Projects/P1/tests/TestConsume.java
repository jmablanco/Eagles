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
		frame.startGame();
		CookieComponent cookie = new CookieComponent(x,y,frame.scale);
		assertTrue(pacman.consume() == null); 
		map.add("cookie", new Location(x,y),cookie,Map.Type.COOKIE);
		assertTrue(pacman.consume().equals(cookie)); 

	}
}
