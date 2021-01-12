import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(3, 4), "G1", Color.blue);

		//frame.startGame();

		//for (Location z: ghost.get_valid_moves()) {
		//	System.out.println(z.x + "" + z.y);
		//}

		int x = 3;
		int y = 4;
		
		//go through all coords that surround myLoc
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {
				//Don't check coordinates that equal current location or less than 0 
				if ( (i != x || j != y) && i >= 0 && j >= 0) {
					if (!frame.getMap().getLoc(new Location(i, j)).contains(Map.Type.WALL))
						assertTrue(ghost.get_valid_moves().contains(new Location(i, j)));
				}
			}
		}
	}
}
