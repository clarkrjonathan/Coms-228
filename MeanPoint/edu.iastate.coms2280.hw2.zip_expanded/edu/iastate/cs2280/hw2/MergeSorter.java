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
 * This class implements the mergesort algorithm.   
 *
 */

public class MergeSorter extends AbstractSorter
{
	// Other private instance variables if needed
	
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts   input array of integers
	 */
	public MergeSorter(Point[] pts) 
	{
		super(pts);
		super.algorithm = "merge sort";
	}


	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter. 
	 * 
	 */
	@Override 
	public void sort()
	{
		super.points = mergeSortRec(super.points);
	}

	
	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One 
	 * way is to make copies of the two halves of pts[], recursively call mergeSort on them, 
	 * and merge the two sorted subarrays into pts[].   
	 * 
	 * @param pts	point array 
	 */
	
    private Point[] mergeSortRec(Point[] pts) {
        if (pts.length < 2) {
            return pts;
        }
        int mid = pts.length / 2;
        Point[] left = new Point[mid];
        Point[] right = new Point[pts.length - mid];

        System.arraycopy(pts, 0, left, 0, mid);
        System.arraycopy(pts, mid, right, 0, pts.length - mid);

        left = mergeSortRec(left);
        right = mergeSortRec(right);

        return merge(left, right);
    }

    private Point[] merge(Point[] left, Point[] right) {
        Point[] merged = new Point[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (super.pointComparator.compare(left[i], right[j]) <= 0) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }

        while (i < left.length) {
            merged[k++] = left[i++];
        }
        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return merged;
    }

	
	// Other private methods if needed ...

}
