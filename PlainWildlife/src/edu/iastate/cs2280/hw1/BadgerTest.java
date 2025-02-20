package edu.iastate.cs2280.hw1;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BadgerTest {
	@ParameterizedTest
	@ValueSource(ints = {0,1,2,3,4,100})
	void construct1(int age) {
		Plain plain = new Plain(4);
		Badger badger = new Badger(plain, 0, 0, age);
		
		Assertions.assertEquals(age, badger.myAge());
		
		Assertions.assertEquals(State.BADGER, badger.who());
	}
	
	void nextTest() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3");
	}
}
