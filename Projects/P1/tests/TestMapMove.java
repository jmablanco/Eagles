import junit.framework.*;
import java.awt.Color;
import java.util.HashSet;
import static org.junit.Assert.*;
import java.io.*;

public class TestMapMove {

	public void testMapMove() throws FileNotFoundException {
		//Creating A Map 
		//Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
		int x = 2; 
		int y = 2; 
		//Creating Players
		Ghost ghost = frame.addGhost(new Location(x, y), "ghost1", Color.red); //Creates a red ghost named "ghost1" at location x,y
		PacMan pacman = frame.addPacMan(new Location(x, y)); //Creates PacMan at location x, y
		//Start The Game
		frame.startGame();
		Map map = frame.getMap(); 

		//Move ghost 
		map.move("ghost1", new Location(x+1, y-1), Map.Type.GHOST); 

		HashSet<Map.Type> expRes1 = new HashSet<>();
		HashSet<Map.Type> expRes2 = new HashSet<>(); 

		expRes1.add(Map.Type.PACMAN); 
		expRes2.add(Map.Type.GHOST); 


		assertTrue(map.getLoc(new Location(x,y)).contains(Map.Type.PACMAN)); 
		assertTrue(!map.getLoc(new Location(x,y)).contains(Map.Type.GHOST)); 

		assertTrue(map.getLoc(new Location(x+1,y-1)).contains(Map.Type.GHOST));
		assertTrue(!map.getLoc(new Location(x+1,y-1)).contains(Map.Type.PACMAN));

	}
}
