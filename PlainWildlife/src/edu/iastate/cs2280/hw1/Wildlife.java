package edu.iastate.cs2280.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Jonathan Clark
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with
 * squares inhabited by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class Wildlife 
{
	/**
	 * Update the new plain from the old plain in one cycle. 
	 * @param pOld  old plain
	 * @param pNew  new plain 
	 */
	public static void updatePlain(Plain pOld, Plain pNew)
	{
	
		int width = pOld.getWidth();
		Living grid[][] = pOld.getGrid();
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				grid[i][j].next(pNew);
			}
		}
	}
	
	/**
	 * Repeatedly generates plains either randomly or from reading files. 
	 * Over each plain, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		
		int trial = 1;
		int select = 0;
		int cycles = 0;
		int width = 0;
		
		String fileName = "";
						// the plain after an odd number of cycles
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Simulation of Wildlife of the Plain\r\n"
				+ "keys: 1 (random plain) 2 (file input) 3 (exit)\n");
		
		while (select != 3) {
			Plain even;   				 // the plain after an even number of cycles 
			Plain odd;    
			
			System.out.print("Trial " + trial + ": ");
			select = scanner.nextInt();
			
			if (select == 1) {
				System.out.println("Plain input from file");
				System.out.print("File name: ");
				
				fileName = scanner.next();
				
				odd = new Plain(fileName);
				even = new Plain(fileName);
				
			} else if (select == 2) {
				System.out.println("Random plain");
				System.out.print("Enter grid width: ");
				
				width = scanner.nextInt();
				
				odd = new Plain(width);
				even = new Plain(width);
				
				even.randomInit();
			} else {
				break;
			}
			
			System.out.print("Enter the number of cycles: ");
			cycles = scanner.nextInt();
			
			System.out.println("\nInitial Plain: ");
			System.out.println(even);
			
			int i = 0;
			while (i < cycles) {
				if(i % 2 == 0) {
					Wildlife.updatePlain(odd, even);
				} else {
					Wildlife.updatePlain(even, odd);
				}
				i++;
				
			}
			
			System.out.println("Final plain:\n");
			System.out.println(cycles % 2 == 0 ? odd : even);
			               
			trial++;
		}
		
		scanner.close();
		
	}
}
