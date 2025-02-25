package edu.iastate.cs2280.hw1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author Jonathan Clark
 */
public class PlainTest {
	@Test
	void public1Construct() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		Assertions.assertEquals(3, plain.getWidth());
		Assertions.assertEquals(plain.toString(), "G  B0 F0 \n"
		+ "F0 F0 R0 \n"
		+ "F0 E  G  \n");
	}
	
	@Test
	void writeTest() throws IOException {
		String fileName = "TestFile.txt";
		File file = new File(fileName);
		file.delete();

		Plain plain = new Plain("public1-3x3.txt");
		plain.write("TestFile.txt");
		Assertions.assertTrue(new File(fileName).isFile());
	}
	
	
	//checking file can be read, saved to a file, read again and the class objects will be "equal" comparison through string
	@Test
	void writeTest2() throws IOException {
		String fileName = "TestFile.txt";
		File file = new File(fileName);
		file.delete();

		Plain plain = new Plain("public1-3x3.txt");
		plain.write("TestFile.txt");
		
		Plain plain2 = new Plain("TestFile.txt");
		
		Assertions.assertEquals(plain.toString(), plain2.toString());
	}
	
	@Test
	void accessorTest() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		plain.setLivingThing(0, 0, new Empty(plain, 0,0));
		
		Assertions.assertEquals(State.EMPTY, plain.getGrid()[0][0].who());
	}


	@Test
	void public2Construct() throws FileNotFoundException {
		Plain plain = new Plain("public2-6x6.txt");
		Assertions.assertEquals(plain.toString(), "F0 E  E  F0 E  E  \n"
												+ "B0 F0 B0 R0 G  R0 \n"
												+ "R0 E  R0 B0 B0 G  \n"
												+ "B0 E  E  R0 F0 E  \n"
												+ "B0 E  E  G  E  R0 \n"
												+ "G  G  E  B0 R0 E  \n");
	}

	@Test
	void public3Construct() throws FileNotFoundException {
		Plain plain = new Plain("public3-10x10.txt");
		Assertions.assertEquals(plain.toString(), "B0 E  B0 E  B0 R0 E  R3 E  G  \n"
												+ "G  E  B0 E  F0 R0 E  B4 G  G  \n"
												+ "G  G  G  G  E  E  R0 E  G  G  \n"
												+ "F0 E  G  G  E  R0 R0 B0 B0 G  \n"
												+ "F0 F1 E  E  E  E  E  E  B0 E  \n"
												+ "G  G  R1 R0 R0 R0 R0 B0 B0 E  \n"
												+ "E  G  R0 R1 R2 R2 G  E  G  G  \n"
												+ "B0 B0 G  R0 R0 R0 G  B0 E  G  \n"
												+ "E  G  G  F4 R2 R0 E  G  G  G  \n"
												+ "G  G  E  E  E  G  G  G  G  G  \n");
	}
	
	@Test
	void setLivingTest() {
		Plain plain = new Plain(3);
		plain.randomInit();
		
		plain.setLivingThing(0, 0, new Badger(plain, 0, 0, 2));
		Assertions.assertEquals(State.BADGER, plain.getGrid()[0][0].who());
		Assertions.assertEquals(2, ((Animal) plain.getGrid()[0][0]).myAge());
	}
	//no assertions
	@Test
	void randomInitTest() throws FileNotFoundException {
		Plain plain = new Plain(3);
		plain.randomInit();
		plain.write("RandomInitPlain.txt");
	}
}
