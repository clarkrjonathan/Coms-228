package edu.iastate.cs2280.hw1;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
/**
 * @author Jonathan Clark
 */
public class BadgerTest {
	@ParameterizedTest
	@ValueSource(ints = {0,1,2,3,4,100})
	void construct1(int age) {
		Plain plain = new Plain(4);
		Badger badger = new Badger(plain, 0, 0, age);
		
		Assertions.assertEquals(age, badger.myAge());
		
		Assertions.assertEquals(State.BADGER, badger.who());
	}
	
	@Test
	void nextTest1() throws FileNotFoundException {
		Plain plainOld = new Plain("public1-3x3.txt");
		Plain newPlain = new Plain("public1-3x3.txt");
		
		plainOld.getGrid()[0][1].next(newPlain);
		System.out.println(newPlain);
		
		Assertions.assertEquals(State.BADGER, plainOld.getGrid()[0][1].who());
		Assertions.assertEquals(State.FOX, newPlain.getGrid()[0][1].who());
		
	}
	
	@Test
	void nextTest2() throws FileNotFoundException {
		Plain plainOld = new Plain("public2-6x6.txt");
		Plain newPlain = new Plain("public2-6x6.txt");
		
		plainOld.getGrid()[1][0].next(newPlain);
		System.out.println(newPlain);
		
		Assertions.assertEquals(State.BADGER, plainOld.getGrid()[1][0].who());
		Assertions.assertEquals(State.FOX, newPlain.getGrid()[1][0].who());
		
	}
	
	@Test
	void nextTest3() throws FileNotFoundException {
		Plain plainOld = new Plain("public2-6x6.txt");
		Plain newPlain = new Plain("public2-6x6.txt");
		
		plainOld.getGrid()[3][0].next(newPlain);
		
		Assertions.assertEquals(State.BADGER, plainOld.getGrid()[3][0].who());
		Assertions.assertEquals(State.EMPTY, newPlain.getGrid()[3][0].who());
		
	}
	
	@Test
	void nextTest4() throws FileNotFoundException {
		Plain plainOld = new Plain("allOld.txt");
		Plain plainNew = new Plain("allOld.txt");
		
		plainOld.getGrid()[0][1].next(plainNew);
		
		Assertions.assertEquals(State.EMPTY, plainNew.getGrid()[0][1].who());
		
	}
}
