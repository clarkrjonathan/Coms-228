package edu.iastate.cs2280.hw1;

/**
 * @author Jonathan Clark
 */
/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (Plain p, int r, int c, int a) 
	{
		plain = p;
		row = r;
		column = c;
		age = a;
	}
		
	// Rabbit occupies the square.
	public State who()
	{ 
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
		Living obj;
		int population[] = new int[NUM_LIFE_FORMS];
		
		census(population);
		
		if(age > RABBIT_MAX_AGE) {
			obj = new Empty(plain, row, column);
		} else if (population[GRASS] == 0) {
			obj = new Empty(plain, row, column);
		} else if (population[FOX] + population[BADGER] >= population[RABBIT]
				&& population[FOX] > population[BADGER]) {
			obj = new Fox(plain, row, column, 0);
		} else if (population[BADGER] > population[RABBIT]) {
			obj = new Badger(plain, row, column, 0);
		} else {
			obj = this;
		}
		
		age++;
		pNew.setLivingThing(row, column, obj);
		return null; 
	}
}
