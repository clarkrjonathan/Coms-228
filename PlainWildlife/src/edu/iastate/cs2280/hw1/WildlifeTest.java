package edu.iastate.cs2280.hw1;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Jonathan Clark
 */

public class WildlifeTest {
	@Test
	void public1() throws FileNotFoundException {
		Plain oddPlain = new Plain("public1-3x3.txt");
		Plain evenPlain = new Plain(3);
		System.out.println(0);
		System.out.println(oddPlain);
		
		int i = 0;
		while (i < 5) {
			if(i % 2 == 0) {
				Wildlife.updatePlain(oddPlain, evenPlain);
				System.out.println(i + 1);
				System.out.println(evenPlain);
			} else {
				System.out.println(i + 1);
				Wildlife.updatePlain(evenPlain, oddPlain);
				System.out.println(oddPlain);
			}
			i++;
			
		}
		
		Assertions.assertEquals(State.EMPTY, evenPlain.getGrid()[1][1].who());
		Assertions.assertEquals(new Plain("public1-5cycles.txt").toString(), evenPlain.toString());
		
	}
	

}
