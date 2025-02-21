package edu.iastate.cs2280.hw1;

/**
 *  
 * @author
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (Plain p, int r, int c, int a) 
	{
		plain = p;
		row = r;
		column = c;
		age = a;
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a fox. 
//		Empty if the Fox is currently at age 6;
//		b) otherwise, Badger, if there are more Badgers than Foxes in the neighborhood;
//		c) otherwise, Empty, if Badgers and Foxes together outnumber Rabbits in the neighborhood;
//		d) otherwise, Fox (the fox will live on).
		Living obj;
		int population[] = new int[NUM_LIFE_FORMS];
		census(population);
		
		if(age >=6) {
			obj = new Empty(plain, row, column);
		} else if (population[BADGER] > population[FOX]){
			obj = new Badger(plain, row, column, 0);
		} else if (population[BADGER] + population[FOX] > population[RABBIT]) {
			obj = new Empty(plain, row, column);
		} else {
			obj = this;
		}
		
		pNew.setLivingThing(row, column, obj);
		
		return obj; 
	}
}
