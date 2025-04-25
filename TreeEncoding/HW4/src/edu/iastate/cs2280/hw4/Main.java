package edu.iastate.cs2280.hw4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Main class
 * @author Jonathan Clark
 *
 */
public class Main {
	
	/**
	 * Reads in file from arguments and prints both the encoding provided as well as the decoded
	 * message using that encoding
	 * @param args - args[0] should be the file name
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		String fileName;
		try {
			fileName = args[0];
		} catch (IndexOutOfBoundsException e){
			throw new IllegalArgumentException("Invalid number of arguments");
		}

		Scanner scner = new Scanner(new FileReader(fileName));
		
		//should only be max 3 lines
		String lines[] = new String[3];
		int numLines = 0;
		
		while(scner.hasNextLine() && numLines < 3) {
			lines[numLines] = scner.nextLine();
			numLines++;
		}
		
		String encoding;
		String message;
		
		if(numLines == 3) {
			encoding = lines[0] + "\n" + lines[1];
			message = lines[2];
		} else if (numLines == 2) {
			encoding = lines[0];
			message = lines[1];
		} else {
			throw new IllegalArgumentException("Invalid number of lines in .arch file");
		}
		
		MsgTree tree = new MsgTree(encoding);
		
		System.out.println("character  code\r\n"
				+ "-------------------------");
		
		MsgTree.printCodes(tree, "");
		System.out.println("\nMESSAGE: ");
		decode(tree, message);

	}
	
	/**
	 * Decodes and prints the passed message using the passed tree
	 * @param codes - encoding tree
	 * @param msg - message to be decoded
	 */
	public static void decode (MsgTree codes, String msg) {
		MsgTree currNode = codes;
		String output = "";
		
		//iterate through string for parsing
		int i = 0;
		while(i < msg.length()) {
			
			//doesn't matter if we look at left or right node both will be null at a leaf
			while(currNode.left != null) {
				
				if(msg.charAt(i) == '0') {
					currNode = currNode.left;
				} else {
					currNode = currNode.right;
				}
				i++;
				
			}
			
			//append parsed char
			output += currNode.payloadChar;
			
			//reset to top of tree
			currNode = codes;
			
		}
		
		System.out.println(output);
		
	}

}	
