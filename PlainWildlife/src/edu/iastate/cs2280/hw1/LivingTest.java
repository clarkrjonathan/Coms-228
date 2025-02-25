package edu.iastate.cs2280.hw1;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Jonathan Clark
 */
public class LivingTest {
	@Test
	void census1() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		int population[] = new int[Living.NUM_LIFE_FORMS];
		
		plain.getGrid()[1][1].census(population);
		
		Assertions.assertEquals(1, population[Living.EMPTY]);
		Assertions.assertEquals(4, population[Living.FOX]);
	}
	
	void census2() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		int population[] = new int[Living.NUM_LIFE_FORMS];
		plain.getGrid()[1][0].census(population);
		
		Assertions.assertEquals(1, population[Living.EMPTY]);
		Assertions.assertEquals(3, population[Living.FOX]);
	}

}
