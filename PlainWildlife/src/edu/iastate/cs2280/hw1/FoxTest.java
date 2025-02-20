package edu.iastate.cs2280.hw1;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FoxTest {
	@ParameterizedTest
	@ValueSource(ints = {0,1,2,3,4,5,6})
	void construct(int age) {
		Plain p = new Plain(3);
		Fox fox = new Fox(p, 0, 0, age);
		
		Assertions.assertEquals(age, fox.myAge());
		Assertions.assertEquals(State.FOX, fox.who());
	}

}
