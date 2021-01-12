import junit.framework.*;
import java.awt.Color;
import java.util.HashSet;
import static org.junit.Assert.*;
import java.io.*;



public class TestMapGetLoc extends TestCase {
	
	public void testMapGetLoc() throws FileNotFoundException {
	//Creating A Map 
	//Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
	NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

	//Creating Players
	Ghost ghost = frame.addGhost(new Location(6, 7), "name", Color.red); //Creates a red ghost named "name" at location 6,7

	Map map = frame.getMap(); 

	HashSet<Map.Type> ghostAndCookieSet = new HashSet<Map.Type>();

	ghostAndCookieSet.add(Map.Type.GHOST);
	ghostAndCookieSet.add(Map.Type.COOKIE);

	//Start The Game
	//frame.startGame();

	assertEquals(map.getLoc(new Location(6, 7)), ghostAndCookieSet);
	}
}
