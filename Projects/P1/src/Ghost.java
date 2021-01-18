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
		ArrayList<Location> temp = new ArrayList<>();

		int x = myLoc.x;
		int y = myLoc.y;
		
		//go through all coords that surround myLoc
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {
				
				//Don't check coordinates that equal current location or less than 0 
				if ( (i != x || j != y) && i >= 0 && j >= 0) {
					if (!myMap.getLoc(new Location(i, j)).contains(Map.Type.WALL))
						temp.add(new Location(i, j));
				}
			}
		}
		return temp;
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
		int x = myLoc.y;
		int y = myLoc.x;

		//go through all coords that surround myLoc
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {

				//Don't check coordinates that equal current location or less than 0 
				if (i != x || j != y && i >= 0 && j >= 0) {
					HashSet<Map.Type> loc = myMap.getLoc(new Location(i,j));

					if (loc.contains(Map.Type.PACMAN)){
						return true;   
					}
				}
			}
		}
		return false;
	}

	public boolean attack() {
		if(!is_pacman_in_range())
			return false;
		
		return myMap.attack(myName);
	}
}
