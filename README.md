
# Project 1: PacMan

## Group Members:
  * Sierra Seabrease 
  * Teddy Rosemond 
  * David Eluma
  * Ritik Sharma

## Playing Pacman

## Running from Command Line
In order to compile and run this program: <br/>
``javac -cp "src/" src/*.java``  <br/>
``java -cp "src/" StartMenu``

## Functions

  ### Map
  * eatCookie
  * attack:
    - Implementation: Get ghost and pacman’s location from locations HashSet. Go through all coordinates surrounding the ghost to see if pacman’s coordinates
  match one of these. If so, remove pacman and update gameOver to true and return true.
    - Test: Have two ghosts in different locations. One is next to pacman while the other is not. The first ghost should return true when using attack while 
  the other should return false.
  * getLoc:
    - Implementation: Simply return the Type value (Wrapped in a HashSet) of the HashMap "field" based on the location key. Return the emptySet when there is no such mapping.
    - Test: Creates a Ghost and Pacman at certain locations and sees whether getLoc returns them at those locations.
  * move:
    - Implementation: Moves the specified object to the new location provided if able to. Returns true if move was successful and false otherwise. 
    - Test: Tests that when a ghost moves, it is only located at it's new specified location by checking the contents of the previous location and the new location. 

  ### Ghost
  * get_valid_moves:
    - Implementation: Goes through all surrounding coordinates that surround myLoc and determines whether they should be added to the arraylist to return. If the surrounding location is a wall, it should not be added.
    - Test: Creates a ghost at a certain location and determines whether the method correctly returns the proper surrounding locations.
  * attack:
  * move:
    - Implementation: Use get_valid_moves() to get an arraylist of all available moves. Then use the Random class to select a random location from the arraylist.
    Then change the ghost’s location to the random available location and use Map’s move method.
    - Test: If the Ghost’s number of available moves is greater than 0 have Ghost’s move method return true else 
    if Ghost’s available moves is less than 1 have Ghost’s move method return false.
  * is_pacman_in_range
    - Implementation: checks the surronding x +/- 1, y +/- 1 location to see if any of them contain a pacman
    - Test: Tests that when a ghost is in range of a pacman it returns true and when another pacman is not in range it returns null. 

  ### Pacman 
  * get_valid_moves:
    - Implementation: Goes through all surrounding coordinates that surround myLoc and determines whether they should be added to the arraylist to return. If the surrounding location is a wall, it should not be added.
    - Test: Creates a pacman at a certain location and determines whether the method correctly returns the proper surrounding locations.
  * consume:
    - Implementation: If there is a cookie at this current location then consumes that cookie by calling map eat-cookie. It returns the cookie if eating was successful otherwise it returns null. 
    - Test: Tests by checking that a pacman trying to consume a cookie that is not at it's location returns null. Tests another pacman located on a cookie is able to consume the cookie and return it. 
  * move
  * is_ghost_in_range:
    - Implementation: Uses a nested for loop that goes through all the locations that surround pacman’s current location. 
    If one of these coordinates contain a Type “GHOST” return true else return false.
    - Test: First test with pacman & a ghost next to each other. This should resolve to true. 
    Another assertion should be false when pacman & ghost are further than (x±1,y±1)

