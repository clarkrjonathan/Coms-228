package edu.iastate.cs2280.hw1;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class EmptyTest {
	@Test
	void construct() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		Empty empty = (Empty) plain.getGrid()[2][1];
		
		
		Assertions.assertEquals(State.EMPTY, empty.who());
	}
	
	@Test
	void next1() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		Plain newPlain = new Plain("public1-3x3.txt");
		
		plain.getGrid()[2][1].next(newPlain);
		
		Assertions.assertEquals(State.FOX, newPlain.getGrid()[2][1].who());
	}
	
	@Test
	void next2() throws FileNotFoundException {
		Plain plain = new Plain("public2-6x6.txt");
		Plain newPlain = new Plain("public2-6x6.txt");
		//(0,1) (0,2), (0,4) (0,5)
		//(2,1) (3,1)
		plain.getGrid()[0][1].next(newPlain);
		plain.getGrid()[0][2].next(newPlain);
		plain.getGrid()[0][4].next(newPlain);
		plain.getGrid()[0][5].next(newPlain);
		plain.getGrid()[2][1].next(newPlain);
		plain.getGrid()[4][1].next(newPlain);
		
		Assertions.assertEquals(State.FOX, newPlain.getGrid()[0][1].who());
		Assertions.assertEquals(State.FOX, newPlain.getGrid()[0][2].who());
		Assertions.assertEquals(State.RABBIT, newPlain.getGrid()[0][4].who());
		Assertions.assertEquals(State.GRASS, newPlain.getGrid()[0][5].who());
		Assertions.assertEquals(State.RABBIT, newPlain.getGrid()[2][1].who());
		Assertions.assertEquals(State.BADGER, newPlain.getGrid()[4][1].who());
	}
	
	@Test
	void next3() throws FileNotFoundException {
		Plain plain = new Plain("allEmpty.txt");
		Plain newPlain = new Plain("allEmpty.txt");
		
		
		plain.getGrid()[1][1].next(newPlain);
		
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[1][1].who());
		
	}

}
