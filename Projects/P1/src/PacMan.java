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
		return false;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		HashSet<Type> currLoc = Map.getLoc(myLoc); //Gets the list of what is located at pacmans location
		//If the location has a cookie then call eat cookie from Map 
		if(currLoc.contains(Type.COOKIE)){
			return Map.eatCookie(myName); 
		}
		return null;
	}
}
