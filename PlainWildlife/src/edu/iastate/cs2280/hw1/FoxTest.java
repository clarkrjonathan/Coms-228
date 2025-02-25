package edu.iastate.cs2280.hw1;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
/**
 * @author Jonathan Clark
 */
public class FoxTest {
	@ParameterizedTest
	@ValueSource(ints = {0,1,2,3,4,5,6})
	void construct(int age) {
		Plain p = new Plain(3);
		Fox fox = new Fox(p, 0, 0, age);
		
		Assertions.assertEquals(age, fox.myAge());
		Assertions.assertEquals(State.FOX, fox.who());
	}
	
	@Test
	void next1() throws FileNotFoundException {
		Plain plain = new Plain("allOld.txt");
		Plain newPlain = new Plain("allOld.txt");
		
		plain.getGrid()[0][0].next(newPlain);
		
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[0][0].who());
	}
	
	@Test
	void next2() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		Plain newPlain = new Plain("public1-3x3.txt");
		
		plain.getGrid()[0][2].next(newPlain);
		plain.getGrid()[1][0].next(newPlain);
		plain.getGrid()[1][1].next(newPlain);
		plain.getGrid()[2][0].next(newPlain);
		
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[0][2].who());
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[1][0].who());
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[1][1].who());
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[2][0].who());
	}
	
	@Test
	void next3() throws FileNotFoundException {
		Plain plain = new Plain("public2-6x6.txt");
		Plain newPlain = new Plain("public2-6x6.txt");
		
		plain.getGrid()[0][0].next(newPlain);
		plain.getGrid()[3][4].next(newPlain);
		
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[0][0].who());
		Assertions.assertEquals(State.BADGER, newPlain.getGrid()[3][4].who());
	}
	
	@Test
	void next4() throws FileNotFoundException {
		Plain plain = new Plain("public3-10x10.txt");
		Plain newPlain = new Plain("public3-10x10.txt");
		
		plain.getGrid()[8][3].next(newPlain);
		
		Assertions.assertEquals(State.FOX, newPlain.getGrid()[8][3].who());
	}
	



}
