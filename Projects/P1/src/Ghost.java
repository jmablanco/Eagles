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
		//Gets the sets from all possible locations in the range. 
		HashSet<Type> upright = myMap.getLoc(new Location(myLoc.x+1, myLoc.y+1)); 
		HashSet<Type> upleft = myMap.getLoc(new Location(myLoc.x+1, myLoc.y-1)); 
		HashSet<Type> upmid = myMap.getLoc(new Location(myLoc.x+1, myLoc.y)); 
		HashSet<Type> midright = myMap.getLoc(new Location(myLoc.x, myLoc.y+1));
		HashSet<Type> midleft = myMap.getLoc(new Location(myLoc.x, myLoc.y-1));
		HashSet<Type> downleft = myMap.getLoc(new Location(myLoc.x-1, myLoc.y-1)); 
		HashSet<Type> downmid = myMap.getLoc(new Location(myLoc.x-1, myLoc.y)); 
		HashSet<Type> downright = myMap.getLoc(new Location(myLoc.x-1, myLoc.y+1)); 

		//If a pacman type is included in any of these sets then there is a pacman in the range of the ghost
		return upright.contains(Type.PACMAN)||upleft.contains(Type.PACMAN)||upmid.contains(Type.PACMAN)
		|| midright.contains(Type.PACMAN)|| midleft.contains(Type.PACMAN)||downleft.contains(Type.PACMAN)||downmid.contains(Type.PACMAN)||downright.contains(Type.PACMAN))

	}

	public boolean attack() {
		return false;
	}
}
