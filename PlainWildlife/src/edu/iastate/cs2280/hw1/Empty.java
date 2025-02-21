package edu.iastate.cs2280.hw1;

/**
 *  
 * @author
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Plain p, int r, int c) 
	{
		plain = p;
		row = r;
		column = c;
	}
	
	public State who()
	{
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		// TODO  delete comments
		//  
//		Rabbit, if more than one neighboring Rabbit;
//		b) otherwise, Fox, if more than one neighboring Fox;
//		c) otherwise, Badger, if more than one neighboring Badger;
//		d) otherwise, Grass, if at least one neighboring Grass;
//		e) otherwise, Empty.
		Living obj;
		int population[] = new int[NUM_LIFE_FORMS];
		census(population);
		
		if(population[RABBIT] > 1) {
			obj = new Rabbit(plain, row, column, 0);
		} else if (population[FOX] > 1) {
			obj = new Fox(plain, row, column, 0);
		} else if (population[BADGER] > 1) {
			obj = new Badger(plain, row, column, 0);
		} else if (population[GRASS] > 0) {
			obj = new Grass(plain, row, column);
		} else {
			obj = this;
		}
		
		pNew.setLivingThing(row, column, obj);
		
		return obj; 
	}
}
