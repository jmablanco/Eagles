import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

import com.sun.jdi.Location;

public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE		
	}
	
	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components; 
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet; 

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
		
	public boolean move(String name, Location loc, Type type) {
		//update locations, components, and field
		//use the setLocation method for the component to move it to the new location
		return false;
	}
	
	public HashSet<Type> getLoc(Location loc) {
		//wallSet and emptySet will help you write this method
		return null;
	}

	public boolean attack(String Name) {
		
		//check if Ghost & Pacman have a location and component
		if (locations.containsKey(Name) && components.containsKey(Name) && locations.containsKey("pacman") && components.containsKey("pacman")) {
			
			Location ghost_coord = locations.get(Name);

			Location pac_coord = location.get("pacman");
			
			//check if ghost is within pacman's vicinity
			int x = ghost_coord.x;
			int y = ghost_coord.y;
				
			for (int i = x-1; i <= x+1; i++) {
				for (int j = y-1; j <= y+1; j++) { 
					//Check coordinates around the ghost
					if ( (i != x || j != y) && i >= 0 && j >= 0) {
							
						//pacman is found in vicinity
						if (pac_coord.x == i && pac_coord.y == j) {
								
							//remove pacman
							locations.remove("pacman");
							locations.remove("pacman");
								
							//update game
							gameOver = true;
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		return null;
	}
}
