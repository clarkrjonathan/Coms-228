package edu.iastate.cs2280.hw2;

import java.io.File;

/**
 * 
 * @author Jonathan Clark
 *
 */

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * This class sorts all the points in an array of 2D points to determine a reference point whose x and y 
 * coordinates are respectively the medians of the x and y coordinates of the original points. 
 * 
 * It records the employed sorting algorithm as well as the sorting time for comparison. 
 *
 */
public class PointScanner  
{

	private Point[] points; 
	
	private Point medianCoordinatePoint;  // point whose x and y coordinates are respectively the medians of 
	                                      // the x coordinates and y coordinates of those points in the array points[].
	private Algorithm sortingAlgorithm;    
	
	private String algString;
		
	protected long scanTime; 	       // execution time in nanoseconds. 
	
	/**
	 * This constructor accepts an array of points and one of the four sorting algorithms as input. Copy 
	 * the points into the array points[].
	 * 
	 * @param  pts  input array of points 
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException
	{
		points = pts.clone();
		sortingAlgorithm = algo;
	}
	
	

	
	/**
	 * This constructor reads points from a file. 
	 * 
	 * @param  inputFileName
	 * @throws FileNotFoundException 
	 * @throws InputMismatchException   if the input file contains an odd number of integers
	 */
	protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException
	{
		int numPoints = getNumPoints(inputFileName);
		points = new Point[numPoints];
		File file = new File(inputFileName);
		Scanner scanner = new Scanner(file);
		
		
		for(int i = 0; i < numPoints; i++) {
			points[i] = new Point(scanner.nextInt(), scanner.nextInt());
		}
		
		scanner.close();
		sortingAlgorithm = algo;
		
	}

	
	/**
	 * Carry out two rounds of sorting using the algorithm designated by sortingAlgorithm as follows:  
	 *    
	 *     a) Sort points[] by the x-coordinate to get the median x-coordinate. 
	 *     b) Sort points[] again by the y-coordinate to get the median y-coordinate.
	 *     c) Construct medianCoordinatePoint using the obtained median x- and y-coordinates.     
	 *  
	 * Based on the value of sortingAlgorithm, create an object of SelectionSorter, InsertionSorter, MergeSorter,
	 * or QuickSorter to carry out sorting.       
	 * @param algo
	 * @return
	 */
	public void scan()
	{
		AbstractSorter aSorter; 
		
		switch (sortingAlgorithm) {
		case InsertionSort:
			algString = "InsertionSort";
			aSorter = new InsertionSorter(points);
			break;
		case MergeSort:
			algString = "MergeSort    ";
			aSorter = new MergeSorter(points);
			break;
		case QuickSort:
			algString = "QuickSort    ";
			aSorter = new QuickSorter(points);
			break;
		case SelectionSort:
			algString = "SelectionSort";
			aSorter = new SelectionSorter(points);
			break;
		default:
			algString = "N/A";
			aSorter = null;
			break;
		
		}
		
		// create an object to be referenced by aSorter according to sortingAlgorithm. for each of the two 
		// rounds of sorting, have aSorter do the following: 
		// 
		//     a) call setComparator() with an argument 0 or 1. 
		//
		//     b) call sort(). 		
		// 
		//     c) use a new Point object to store the coordinates of the medianCoordinatePoint
		//
		//     d) set the medianCoordinatePoint reference to the object with the correct coordinates.
		//
		//     e) sum up the times spent on the two sorting rounds and set the instance variable scanTime. 
		
		int medX;
		int medY;
		
		
		aSorter.setComparator(0);
		
		long startTime = System.nanoTime();
		aSorter.sort();
		scanTime = System.nanoTime() - startTime;
		
		medX = aSorter.getMedian().getX();
		
		aSorter.setComparator(1);

		startTime = System.nanoTime();
		aSorter.sort();
		scanTime += System.nanoTime() - startTime;
		
		medY = aSorter.getMedian().getY();
		
		medianCoordinatePoint = new Point(medX, medY);
		
	}
	
	private int getNumPoints(String inputFileName) throws FileNotFoundException, InputMismatchException {
		File file = new File(inputFileName);
		Scanner scanner = new Scanner(file);
		
		int numInputs = 0;
		
		while(scanner.hasNextInt()) {
			scanner.nextInt();
			numInputs++;
		}
		scanner.close();
		
		
		if(!(numInputs % 2 == 0)) {
			throw new InputMismatchException();
		}
		
		return numInputs/2;
	}
	
	
	/**
	 * Outputs performance statistics in the format: 
	 * 
	 * <sorting algorithm> <size>  <time>
	 * 
	 * For instance, 
	 * 
	 * selection sort   1000	  9200867
	 * 
	 * Use the spacing in the sample run in Section 2 of the project description. 
	 */
	public String stats()
	{
		String output = algString + "    " + points.length + "  " + scanTime;
		return output;
	}
	
	
	/**
	 * Write MCP after a call to scan(),  in the format "MCP: (x, y)"   The x and y coordinates of the point are displayed on the same line with exactly one blank space 
	 * in between. 
	 */
	@Override
	public String toString()
	{
		String output;
		output = "MCP: " + medianCoordinatePoint;
		return output;
	}

	
	/**
	 *  
	 * This method, called after scanning, writes point data into a file by outputFileName. The format 
	 * of data in the file is the same as printed out from toString().  The file can help you verify 
	 * the full correctness of a sorting result and debug the underlying algorithm. 
	 * @throws IOException 
	 */
	public void writeMCPToFile() throws IOException
	{
		String outputFileName = "output.txt";
		File file = new File(outputFileName);
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter writer = new FileWriter(file);
		writer.write(this.toString());
		
		writer.close();
	}	

	

		
}
