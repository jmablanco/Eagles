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
		ArrayList<Location> temp = new ArrayList<>();
		//Above
		temp.add(new Location(myLoc.x-1, myLoc.y+1));
		temp.add(new Location(myLoc.x, myLoc.y+1));
		temp.add(new Location(myLoc.x+1, myLoc.y+1));

		//Left or right
		temp.add(new Location(myLoc.x-1, myLoc.y));
		temp.add(new Location(myLoc.x+1, myLoc.y));

		//Below
		temp.add(new Location(myLoc.x-1, myLoc.y-1));
		temp.add(new Location(myLoc.x, myLoc.y-1));
		temp.add(new Location(myLoc.x+1, myLoc.y-1));

		return temp;
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
