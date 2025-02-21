package edu.iastate.cs2280.hw1;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RabbitTest {
	@Test
	void construct() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		Rabbit grass = (Rabbit) plain.getGrid()[0][0];
		
		
		Assertions.assertEquals(State.RABBIT, grass.who());
	}
	
	@Test
	void next1() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		Plain newPlain = new Plain("public1-3x3.txt");
		
		plain.getGrid()[0][0].next(newPlain);
		
		Assertions.assertEquals(State.GRASS, newPlain.getGrid()[0][0].who());
	}
	
	@Test
	void next2() throws FileNotFoundException {
		Plain plain = new Plain("public2-6x6.txt");
		Plain newPlain = new Plain("public2-6x6.txt");
		
		plain.getGrid()[4][3].next(newPlain);
		
		Assertions.assertEquals(State.GRASS, newPlain.getGrid()[4][3].who());
	}
	
	@Test
	void next3() throws FileNotFoundException {
		Plain plain = new Plain("public3-10x10.txt");
		Plain newPlain = new Plain("public3-10x10.txt");
		
		plain.getGrid()[6][6].next(newPlain);
		
		Assertions.assertEquals(State.RABBIT, newPlain.getGrid()[6][6].who());
	}
	
	@Test
	void next4() throws FileNotFoundException {
		Plain plain = new Plain("rabbits.txt");
		Plain newPlain = new Plain("rabbits.txt");
		
		plain.getGrid()[1][1].next(newPlain);
		
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[1][1].who());
	}
	
	@Test
	void next5() throws FileNotFoundException {
		Plain plain = new Plain("allOld.txt");
		Plain newPlain = new Plain("allOld.txt");
		
		plain.getGrid()[0][3].next(newPlain);
		
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[0][3].who());
	}
}
