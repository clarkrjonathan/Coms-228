package edu.iastate.cs2280.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;


/**
 *  
 * @author Jonathan Clark
 *
 */

/**
 * 
 * This class implements selection sort.   
 *
 */

public class SelectionSorter extends AbstractSorter
{
	// Other private instance variables if you need ... 
	
	/**
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts  
	 */
	public SelectionSorter(Point[] pts)  
	{
		super(pts);
		super.algorithm = "selection sort";

	}
	/** 
	 * Apply selection sort on the array points[] of the parent class AbstractSorter.  
	 * 
	 */
	@Override 
	public void sort()
	{
		int smallestIndex = 0;
		
		for(int i = 0; i < super.points.length; i++) {
			smallestIndex = i;
			for(int j = i; j < super.points.length; j++) {
				if(super.pointComparator.compare(super.points[j], super.points[smallestIndex]) < 0) {
					smallestIndex = j;
				}
			}
			super.swap(i, smallestIndex);
		}
	}	
}
