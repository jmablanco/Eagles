import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;
	}

	public boolean move() {
		ArrayList<Location> moves = get_valid_moves();
		
		//check to see that a vaild move exists
		if (moves.size() > 0) {
			Random x = new Random();
			//Random.nextInt goes up from 0 to size-1
			int ran_index = x.nextInt(moves.size());
			
			//picks a random direction for the ghost to go
			Location new_move = moves.get(ran_index);
			
			//set ghost location to new_move
			myLoc = new_move;
			myMap.move(myName, new_move, Map.Type.GHOST);
			return true;
		}
		//no valid moves available
		return false;
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
