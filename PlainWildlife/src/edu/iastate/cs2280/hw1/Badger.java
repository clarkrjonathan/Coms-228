package edu.iastate.cs2280.hw1;

/**
 *  
 * @author Jonathan Clark
 *
 */

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{
	
	Plain plain;
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Badger (Plain p, int r, int c, int a) 
	{
		row = r;
		column = c;
		age = a;
		plain = p; 
	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		return State.BADGER; 
	}
	
	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group of foxes. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		// TODO 
		// MAKE SURE NOT TO CHANGE THE GRID OF THE CURRENT PLAIN OR ANY OF THE OBJECTS
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a badger. 
		//Living[][] grid = plain.getGrid().clone();
		//grid[]
		
		
		return new Badger(plain, 0, 0, 0);
	}
}
