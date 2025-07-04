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
		Living obj;
		int population[] = new int[NUM_LIFE_FORMS];
		census(population);
		
		if(age >= BADGER_MAX_AGE) {
			obj = new Empty(plain, row, column);
		} else if (population[BADGER] == 1 && population[FOX] > 1) {
			obj = new Fox(plain, row, column, 0);
			
		} else if(population[BADGER]+ population[FOX]> population[RABBIT]) {
			obj = new Empty(plain, row, column);
			
		}else {
			obj = this;
		}
		
		age++;
		pNew.setLivingThing(row, column, obj);

		return obj;
	}
}
