import java.util.HashSet;
import java.util.ArrayList;

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
		return false;
	}

	public boolean is_pacman_in_range() { 
		int x = myLoc.x;
		int y = myLoc.y;

		//go through all coords that surround myLoc
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {

				//Don't check coordinates that equal current location or less than 0 
				if ( (i != x || j != y) && i >= 0 && j >= 0) {
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
		return false;
	}
}
