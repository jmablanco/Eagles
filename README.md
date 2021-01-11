
# Project 1: PacMan

## Group Members:
  * Sierra Seabrease 
  * Teddy Rosemond 
  * David Eluma
  * Ritik Sharma

## Playing Pacman

## Running from Command Line
In order to compule and run this program: 
``javac -cp "src/" src/*.java
java -cp "src/" StartMenu``

## Functions

  ### Map
  * eatCookie
  * attack
  * getLoc
  * move:
    - Implementation: Moves the specified object to the new location provided if able to. Returns true if move was successful and false otherwise. 
    - Test: Tests that when a ghost moves, it is only located at it's new specified location by checking the contents of the previous location and the new location. 

  ### Ghost
  * get_valid_moves
  * attack:
  * move
  * is_pacman_in_range
    - Implementation: checks the surronding x +/- 1, y +/- 1 location to see if any of them contain a pacman
    - Test: Tests that when a ghost is in range of a pacman it returns true and when another pacman is not in range it returns null. 

  ### Pacman 
  * get_valid_moves
  * consume:
    - Implementation: If there is a cookie at this current location then consumes that cookie by calling map eat-cookie. It returns the cookie if eating was successful otherwise it returns null. 
    - Test: Tests by checking that a pacman trying to consume a cookie that is not at it's location returns null. Tests another pacman located on a cookie is able to consume the cookie and return it. 
  * move
  * is_ghost_in_range
