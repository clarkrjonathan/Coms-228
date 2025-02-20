package edu.iastate.cs2280.hw1;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlainTest {
	@Test
	void public1Construct() throws FileNotFoundException {
		Plain plain = new Plain("public1-3x3.txt");
		Assertions.assertEquals(3, plain.getWidth());
		Assertions.assertEquals(plain.toString(), "G  B0 F0 \n"
		+ "F0 F0 R0 \n"
		+ "F0 E  G  \n");
	}
//	
//	@Test
//	void public1_5cycles() throws FileNotFoundException {
//		Plain plainOld = new Plain("public1-3x3.txt");
//		Plain plainNew = new Plain("public1-3x3.txt");
//		
//		for(int i = 0; i < 5; i++) {
//			Wildlife.updatePlain(plainOld, plainNew);
//			plainOld = plainNew;
//			plainNew = new Plain("public1-3x3.txt");
//		}
//		
//		
//		
//		Assertions.assertEquals(plainNew.toString(),  "G  F0 E \n"
//													+ "E  E  F0\n"
//													+ "F0 F0 G");
//	}
//	
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
//	
//	@Test
//	void public2_8cycles() throws FileNotFoundException {
//		Plain plainOld = new Plain("public2-6x6.txt");
//		Plain plainNew = new Plain(6);
//		
//		for(int i = 0; i < 8; i++) {
//			Wildlife.updatePlain(plainOld, plainNew);
//			plainOld = plainNew;
//			plainNew = new Plain(6);
//		}
//		
//		Assertions.assertEquals(plainNew.toString(),  "F0 E  E  E  R0 E \n"
//													+ "E  F0 F6 R0 R0 E \n"
//													+ "R0 E  R0 E  R0 E \n"
//													+ "R1 R2 R0 R0 E  E \n"
//													+ "R0 R1 R1 R1 R0 E \n"
//													+ "G  G  R0 R2 R0 E \n");
//	}
//	
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
//	
//	@Test
//	void public3_6cycles() throws FileNotFoundException {
//		Plain plainOld = new Plain("public2-6x6.txt");
//		Plain plainNew = new Plain(6);
//		
//		for(int i = 0; i < 8; i++) {
//			Wildlife.updatePlain(plainOld, plainNew);
//			plainOld = plainNew;
//			plainNew = new Plain(6);
//		}
//		
//		Assertions.assertEquals(plainNew.toString(),  "B0 E  B0 E  E  R0 E  R0 R2 E \n"
//													+ "G  E  B0 R0 B4 R0 E  R0 R3 R1\n"
//													+ "G  G  R2 R0 E  R0 R0 E  E  E \n"
//													+ "G  F5 R3 R0 E  R0 R0 E  E  R0\n"
//													+ "R2 E  E  E  R0 R0 E  E  B1 G \n"
//													+ "R0 R0 R0 R0 R0 E  B1 R0 G  G \n"
//													+ "E  E  R0 E  R0 E  B1 R0 G  G \n"
//													+ "B4 E  R0 E  R0 E  E  E  R0 G \n"
//													+ "G  R2 R3 E  R0 E  R0 R3 R1 G \n"
//													+ "G  R0 R1 E  R0 E  R0 R2 R0 G ");
//	}
}
