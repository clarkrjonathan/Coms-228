package edu.iastate.cs2280.hw1;
/**
 * @author Jonathan Clark
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AnimalTest {
	
	@Test
	void ageTest() {
		Badger badger = new Badger(new Plain(2), 0, 0, 2);
		Assertions.assertEquals(2, badger.myAge());
	}
}
