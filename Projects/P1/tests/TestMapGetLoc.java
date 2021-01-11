import junit.framework.*;
import java.awt.Color;
import java.util.HashSet;
import static org.junit.Assert.*;
import java.io.*;



public class TestMapGetLoc {
	
	public void testMapGetLoc() throws FileNotFoundException {
	//Creating A Map 
	//Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
	NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

	//Creating Players
	Ghost ghost = frame.addGhost(new Location(6, 7), "name", Color.red); //Creates a red ghost named "name" at location 6,7
	PacMan pacman = frame.addPacMan(new Location(1, 3)); //Creates PacMan at location 1,3

	Map map = frame.getMap(); 

	HashSet<Map.Type> ghostSet = new HashSet<Map.Type>();
	HashSet<Map.Type> pacmanSet = new HashSet<Map.Type>();

	ghostSet.add(Map.Type.GHOST);
	pacmanSet.add(Map.Type.PACMAN);

	//Start The Game
	//frame.startGame();

	assertEquals(map.getLoc(new Location(6, 7)), ghostSet);
	assertEquals(map.getLoc(new Location(1, 3)), pacmanSet);
	}
}
