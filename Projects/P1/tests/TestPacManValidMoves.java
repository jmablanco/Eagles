import junit.framework.*;
import java.awt.Color;
import java.io.*;

import jdk.tools.jimage.resources.jimage;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(2, 3));

		//frame.startGame();

		//for (Location z: pacman.get_valid_moves()) {
		//	System.out.println(z.x + "" + z.y);
		//}

		int x = 2;
		int y = 3;
		
		//go through all coords that surround myLoc
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {
				//Don't check coordinates that equal current location or less than 0 
				if ( (i != x || j != y) && i >= 0 && j >= 0) {
					//Assumes no walls near postion (2,3)
					assertTrue(pacman.get_valid_moves().contains(new Location(i, j)));
				}
			}
		}

	}
}
