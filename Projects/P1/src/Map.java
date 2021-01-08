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
		//update locations, components, and field
		//use the setLocation method for the component to move it to the new location
		
		// Check for if the name was at another location then it should 
		// be removed from field and locations(is gonna be overwritten anyway so may not be needed). 
		Location prev = locations.get(name); 
		HashSet<Type> prevfield = field.get(prev); 
		JComponent prevcomp = components.get(name);
		if(prev != null && prevfield != null && prevcomp != null){
			prevfield.remove(type); 
		}


		// Checks that the location is not a wall 
		if (field.containsKey(loc)){
			HashSet<Type> currplacement = field.get(loc);
			if(currplacement.contains(Type.WALL)){
				return false; 
			}
		}

		// Adds name to locations list
		locations.put(name, loc);
		// if there is nothing at that location then make a new set, otherwise add 
		// to the other set. 
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);

		//Gets the component of that name and sets it to new location. If the comp doesn't 
		//exist then returns false; 
		JComponent comp = components.get(name);
		if(comp == null){
			return false; 
		}
		comp.setLocation(loc.x, loc.y);
		return true;
	}
	
	public HashSet<Type> getLoc(Location loc) {
		//wallSet and emptySet will help you write this method
		return null;
	}

	public boolean attack(String Name) {
		//update gameOver
		return false;
	}
	
	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		return null;
	}
}
