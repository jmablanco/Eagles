import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Random;

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
			for(int j = i-1; j <= i+1; j++) {
				
				//Don't check coordinates that equal current location or less than 0 
				if ( (i != x && j != y) && i >= 0 && j >= 0) {
					if (!myMap.getLoc(new Location(x, y)).contains(Map.Type.WALL))
						temp.add(new Location(x, y));
				}
			}
		}
		return temp;
	}

	public boolean move() {
		ArrayList<Location> validMoves = this.get_valid_moves();
		Random moveAlgorithm = new Random();
		int numberOfMoves = validMoves.size(), 
			direction = moveAlgorithm.nextInt(numberOfMoves);
		Location desiredLocation = validMoves.get(direction);

		//If there are no valid moves, return false
		if (numberOfMoves == 0){
			return false;
		}

		//Move Pacman to its desired location on the map, and sets its instance's location.
		boolean res = myMap.move(myName, desiredLocation, Map.Type.PACMAN);
		myLoc = desiredLocation;

		return res;
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
 		HashSet<Map.Type> currLoc = myMap.getLoc(myLoc); //Gets the list of what is located at pacmans location
		//If the location has a cookie then call eat cookie from Map 
		if(currLoc.contains(Map.Type.COOKIE)){
			return myMap.eatCookie(myName); 
		}
		return null;
	}
}
