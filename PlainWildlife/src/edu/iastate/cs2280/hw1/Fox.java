package edu.iastate.cs2280.hw1;
/**
 * @author Jonathan Clark
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
		Living obj;
		int population[] = new int[NUM_LIFE_FORMS];
		census(population);
		
		if(age >=FOX_MAX_AGE) {
			obj = new Empty(plain, row, column);
		} else if (population[BADGER] > population[FOX]){
			obj = new Badger(plain, row, column, 0);
		} else if (population[BADGER] + population[FOX] > population[RABBIT]) {
			obj = new Empty(plain, row, column);
		} else {
			obj = this;
		}
		
		age++;
		pNew.setLivingThing(row, column, obj);
		
		return obj; 
	}
}
