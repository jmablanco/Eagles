import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;	
	}

	public boolean move() {
		ArrayList<Location> validMoves = this.get_valid_moves();
		Random moveAlgorithm = new Random();
		int numberOfMoves = validMoves.size(), 
			direction = moveAlgorithm.nextInt(numberOfMoves);
		Location desiredLocation = validMoves.get(direction);

		//If there are no valid moves, return false
		if (size == 0)
			return false;

		//Move Pacman to its desired location on the map, and sets its instance's location.
		myMap.move(myName, desiredLocation, Map.Type.PACMAN);
		myLoc = desiredLocation;

		return true;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
