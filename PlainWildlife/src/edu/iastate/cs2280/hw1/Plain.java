package edu.iastate.cs2280.hw1;

/**
 *  
 * @author Jonathan Clark
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner; 
import java.util.Random; 

/**
 * 
 * The plain is represented as a square grid of size width x width. 
 *
 */
public class Plain 
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{		
        // TODO 
		// 
		// Assumption: The input file is in correct format. 
		// 
		// You may create the grid plain in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		// 2) Creates a grid object. 
		// 
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done.
		
		File inputFile = new File(inputFileName);
		Scanner scanner = new Scanner(inputFile);
		
		//set width
		width = 0;
		if(scanner.hasNextLine()) {
			String firstLine = scanner.nextLine();
			Scanner stringScan = new Scanner(firstLine);

			while (stringScan.hasNext()) {
				stringScan.next();
				width++;
			}
			stringScan.close();
		}
		scanner.close();
		
		grid = new Living[width][width];
		
		scanner = new Scanner(inputFile);
		String stringElement;
		int row = 0;
		int col = 0;
		while (scanner.hasNextLine()) {
			
			col = 0;
			String line = scanner.nextLine();
			Scanner lineScan = new Scanner(line);
			while(lineScan.hasNext()) {
				
				stringElement = lineScan.next();
				switch (stringElement.charAt(0)) {
					case 'B':
						grid[row][col] = new Badger(this, row, col, 
								Character.getNumericValue(stringElement.charAt(1)));
						break;
					case 'F':
						grid[row][col] = new Fox(this, row, col, 
								Character.getNumericValue(stringElement.charAt(1)));
						break;
					case 'R':
						grid[row][col] = new Rabbit(this, row, col, 
								Character.getNumericValue(stringElement.charAt(1)));
						break;
					case 'G':
						grid[row][col] = new Grass(this, row, col);
						break;
					case 'E':
						grid[row][col] = new Empty(this, row, col);
						break;
						
					default:
						System.out.println();
				}
						
				col++;
			}
			lineScan.close();
			row++;
			
		}
		scanner.close();
	}
	
	/**
	 * constructs a plain from an existing grid
	 * @param grid to initialize plain with
	 */
	public Plain(Living[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Constructor that builds a w x w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Plain(int w)
	{
		grid = new Living[w][w];
	}
	
	/**
	 * Accessor for grid to check neighborhood
	 * returns a shallow copy to ensure its not mutated
	 * @return A clone of the grid of living things
	 */
	public Living[][] getGrid() {
		return grid.clone();
	}
	
	/**
	 * Sets living thing on grid to what is passed to it
	 * @param r row
	 * @param c column
	 * @param thing living thing being passed
	 */
	public void setLivingThing(int r, int c, Living thing) {
		grid[r][c] = thing;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Initialize the plain by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random(); 
		 
		// TODO 
	}
	
	
	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String output = "";
		for(int i = 0; i < width; i++) {
			for (int j = 0; j< width; j++) {
				
				switch (grid[i][j].who()) {
				case RABBIT:
					output += "R";
					output += ((Animal) grid[i][j]).myAge() + " ";
					break;
				case BADGER:
					output += "B";
					output += ((Animal) grid[i][j]).myAge() + " ";
					break;
				case EMPTY:
					output += "E  ";
					break;
				case FOX:
					output += "F";
					output += ((Animal) grid[i][j]).myAge() + " ";
					break;
				case GRASS:
					output += "G  ";
					break;
				default:
					break;
				}
			}
			output += "\n";
			
		}
		return output; 
	}
	

	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly 
	 * generated plain for debugging purpose. 
	 * @throws IOException 
	 */
	public void write(String outputFileName)
	{
		// TODO 
		// 
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file. 
		try {
			
			FileWriter file = new FileWriter(outputFileName);
			file.write(this + "");
			file.close();
			System.out.println(this);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}			
}
