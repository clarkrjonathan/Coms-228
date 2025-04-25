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
 * This class implements insertion sort.   
 *
 */

public class InsertionSorter extends AbstractSorter 
{
	// Other private instance variables if you need ... 
	
	/**
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 * 
	 * @param pts  
	 */
	public InsertionSorter(Point[] pts) 
	{
		super(pts);
		super.algorithm = "insertion sort";
	}	

	
	/** 
	 * Perform insertion sort on the array points[] of the parent class AbstractSorter.  
	 */
	@Override 
	public void sort()
	{
		
		int i = 1;
		Point temp;
		while(i < super.points.length) {
			
			int j = i - 1;
			temp = super.points[i];
			
			while(j >= 0) {
				
				if(super.pointComparator.compare(temp, super.points[j]) < 0) {
					super.points[j + 1] = super.points[j];
					if(j == 0) {
						super.points[0] = temp;
					}
				} else {
					super.points[j+1] = temp;
					break;
				}
				j--;
				
			}
			i++;
			
		}
	}		
}
