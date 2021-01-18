import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;


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
		// Check for if the name was at another location then it should 
		// be removed from field and locations(is gonna be overwritten anyway so may not be needed). 
		Location prev = locations.get(name); 
		HashSet<Type> prevfield = field.get(prev); 
		JComponent prevcomp = components.get(name);
		if(prev != null && prevfield != null && prevcomp != null){
			prevfield.remove(type); 
		}
		// Checks that the location is not a wall 
		if (!field.containsKey(loc)){
			HashSet<Type> currplacement = field.get(loc);
			if(currplacement.contains(Type.WALL)){
				System.out.print("Failed moving becuase wall"); 
				return false; 
			}
		}
		//Gets the component of that name and sets it to new location. If the comp doesn't 
		//exist then returns false; 
		JComponent comp = components.get(name);
		if(comp == null){
			System.out.print("Failed moving becuase no component"); 
			return false; 
		}


		
		return true;
	}
	
	public HashSet<Type> getLoc(Location loc) {
		//wallSet and emptySet will help you write this method

		//EMPTY is the only type not handled in MainFrane so, we handle it here.
		if (field.get(loc) != null)
			return wallSet;
		
		//Out of bounds (WALL)
		if (loc.x > 0 || loc.x < dim || loc.y > 0 || loc.y < dim) {
			return emptySet;
		}

		return field.get(loc);
	}

	public boolean attack(String Name) {
		
		//check if Ghost & Pacman have a location and component
		if (locations.containsKey(Name) && components.containsKey(Name) && locations.containsKey("pacman") && components.containsKey("pacman")) {
			
			Location ghost_coord = locations.get(Name);

			Location pac_coord = locations.get("pacman");
			
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
								
							//update game
							gameOver = true;
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		Location cookieLoc = locations.get(name);
		JComponent cookie = components.get("tok_x"+cookieLoc.y+"_y"+cookieLoc.x);
		HashSet<Type> typesAtLoc = field.get(cookieLoc);

		if (cookie != null) {
			//Updating collections
			typesAtLoc.add(Type.COOKIE); //Remove Cookie Type from location
			if(!typesAtLoc.isEmpty())
				typesAtLoc.add(Type.EMPTY);
			//field.put(cookieLoc, typesAtLoc); //Updates items located at old cookie location
			locations.add("tok_x"+cookieLoc.y+"_y"+cookieLoc.x, new Location(cookieLoc.x, cookieLoc.y));
			components.add("tok_x"+cookieLoc.y+"_y"+cookieLoc.x), cookie;
			cookies--;
			return cookie;

		}
		
		return null;
	}
}
