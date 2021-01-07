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

		int x = myLoc.x;
		int y = myLoc.y;
		
		//go through all coords that surround myLoc
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {
				
				//Don't check coordinates that equal current location or less than 0 
				if ( (i != x || j != y) && i >= 0 && j >= 0) {
					if (!myMap.getLoc(new Location(x, y)).contains(Map.Type.WALL))
						temp.add(new Location(x, y));
				}
			}
		}
		return temp;
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		int x = myLoc.x;
		int y = myLoc.y;
		
		//go through all coords that surround myLoc
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {
				
				//Don't check coordinates that equal current location or less than 0 
				if ( (i != x || j != y) && i >= 0 && j >= 0) {

					//create Location object
					Location coord = new Location(i,j);
					
					HashSet<Map.Type> loc = myMap.getLoc(coord);
					
					if (loc.contains(Map.Type.GHOST))
						return true;   
				}
			}
		}
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
