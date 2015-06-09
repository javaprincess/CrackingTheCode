package com.playingwith.arrays;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class MaximumMinimum {
	
	public MaximumMinimum() {
		
	}
	
	@SuppressWarnings("serial")
	public List<Integer> createArray() {
		
		return new ArrayList<Integer>() {{ 
			add(1); 
			add(3);
			add(99);
			add(15);
			add(-1);
			add(0);
			add(4);
			add(1);
			add(45);
		}};
	}
	
	public int findMin(List<Integer> theList) {
		int min = 0;
		
		for (Integer element : theList) {
			if (element < min)
				min = element;
		}
		return min;
	}
	
	public int findMax(List<Integer> theList) {
		int max = 0;
		
		for (Integer element : theList) {
			if (element > max)
				max = element;
		}
		
		return max;
	}
	
	public int findMean(List<Integer> theList) {
		int mean = 0;
		
		for (Integer element : theList) {
			mean = element + mean;
		}
		return mean/theList.size();
	}
	
	public int findMode(List<Integer> theList) {
		int mode = 0;
		
		
		//find dups
		Hashtable<Integer, Integer> dupsTable = findDups(theList);
		Enumeration<Integer> enumeration = dupsTable.elements();
		
		
		while (enumeration.hasMoreElements()) {
			Integer element = enumeration.nextElement();
			
			if (element > mode)
				mode = element;
		}
		return dupsTable.get(mode);
	}
	
	private Hashtable<Integer, Integer> findDups(List<Integer> theList) {
		Hashtable<Integer, Integer> dupsTable = new Hashtable<Integer, Integer>();
		
		int counter = 0;
		Integer element = 0;
		
		
		while (counter++ < theList.size()) {
			int dupsElement = 1;
			
			if (dupsTable.containsKey(element)) {
				dupsTable.put(element, ++dupsElement);
			} else {
				dupsTable.put(element, dupsElement);
			}
		}
		
		return dupsTable;
	}
	public int findMedian(List<Integer> theList) {
		int median = 0;
		
		median = theList.size()/2;
		
		median = theList.get(median);
		
		return median;
	}
	
	public static void main(String[] args) {
		MaximumMinimum maxMin =  new MaximumMinimum();
		List<Integer> theList = maxMin.createArray();
		
		//System.out.println(maxMin.findMin(theList));
		//System.out.println(maxMin.findMax(theList));
		//System.out.println(maxMin.findMean(theList));
		System.out.println(maxMin.findMode(theList));
		System.out.println(maxMin.findMedian(theList));
	}

}
