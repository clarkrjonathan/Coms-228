package edu.iastate.cs2280.hw1;

/**
 * @author Jonathan Clark
 */
/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (Plain p, int r, int c) 
	{
		plain = p;
		row = r;
		column = c;
	}
	
	public State who()
	{
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		Living obj;
		int population[] = new int[NUM_LIFE_FORMS];
		
		census(population);
		
		if(population[RABBIT] >= 3 * population[GRASS]) {
			obj = new Empty(plain, row, column);
		} else if (population[RABBIT] >= 3) {
			obj = new Rabbit(plain, row, column, 0);
		} else {
			obj = this;
		}
		
		pNew.setLivingThing(row, column, obj);
		
		return obj; 
	}
}
