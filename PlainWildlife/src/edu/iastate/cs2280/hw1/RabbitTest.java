package edu.iastate.cs2280.hw1;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * @author Jonathan Clark
 */
public class RabbitTest {
	@Test
	void construct() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		Rabbit rabbit = (Rabbit) plain.getGrid()[1][2];
		
		
		Assertions.assertEquals(State.RABBIT, rabbit.who());
	}
	
	@Test
	void next1() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		Plain newPlain = new Plain("public1-3x3.txt");
		
		plain.getGrid()[1][2].next(newPlain);
		
		Assertions.assertEquals(State.FOX, newPlain.getGrid()[1][2].who());
	}
	
	@Test
	void next2() throws FileNotFoundException {
		Plain plain = new Plain("public2-6x6.txt");
		Plain newPlain = new Plain("public2-6x6.txt");
		
		plain.getGrid()[2][0].next(newPlain);
		
		//should still be a rabbit, because there are at least as many badgers + foxes as rabbits
		//but the foxes arent more than badgers, and there arent more badgers than rabbits
		plain.getGrid()[3][3].next(newPlain);
		plain.getGrid()[5][4].next(newPlain);
		plain.getGrid()[4][5].next(newPlain);
		plain.getGrid()[1][3].next(newPlain);
		plain.getGrid()[2][2].next(newPlain);
		
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[2][0].who());
		Assertions.assertEquals(State.RABBIT, newPlain.getGrid()[5][4].who());
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[4][5].who());
		Assertions.assertEquals(State.BADGER, newPlain.getGrid()[1][3].who());
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[2][2].who());
	}
	
	@Test
	void next3() throws FileNotFoundException {
		Plain plain = new Plain("public3-10x10.txt");
		Plain newPlain = new Plain("public3-10x10.txt");
		
		plain.getGrid()[5][4].next(newPlain);
		
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[5][4].who());
	}
	
	@Test
	void next5() throws FileNotFoundException {
		Plain plain = new Plain("allOld.txt");
		Plain newPlain = new Plain("allOld.txt");
		
		plain.getGrid()[0][2].next(newPlain);
		
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[0][2].who());
	}
	
	@Test
	void next6() throws FileNotFoundException {
		Plain plain = new Plain("rabbitTest.txt");
		Plain newPlain = new Plain(3);
		
		plain.getGrid()[1][1].next(newPlain);
		
		Assertions.assertEquals(State.RABBIT, newPlain.getGrid()[1][1].who());
	}
}
