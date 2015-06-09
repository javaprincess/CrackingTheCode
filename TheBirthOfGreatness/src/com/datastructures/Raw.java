package com.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Raw {
	
	private boolean isGreater(Integer current, Integer previous) {
		boolean isGreater = false;
		
		if (current > previous)
			isGreater = true;
		
		return isGreater;
	}
	
	public Set<Integer> findLongestAscendingSet(List<Integer> theList) {
		Set<Integer> outgoingSet = null;
		//Hashtable<Set<Integer>, Integer> allSets = new Hashtable<Set<Integer>, Integer>();
		
		GreatestSet greatestSet = new GreatestSet();
		
		Integer previous = 0;
		
		for (Integer current : theList) {
			
			if (isGreater(current, previous)) {
				greatestSet.saveSmallerValue(previous, current);		
			} else {
				//if we are here, then there is a break in the ascension
				greatestSet.saveLargerValue(previous, current);
			}
		}
		
		//find the longest set in allSets
		//I think the set is already sorted...let's check
		outgoingSet = greatestSet.getGreatestSet();
		
		System.out.println(greatestSet.getAllSets());
		
		return outgoingSet;
	}
	
	public HashMap<String, Integer> findDupsInMap(List<String> theList) {
		HashMap<String, Integer> outgoingMap = new HashMap<String, Integer>();
		
		Integer dup = 0;
		
		for (String element : theList) {
			
			if (outgoingMap.containsKey(element)) {
				dup  = outgoingMap.get(element);
				outgoingMap.put(element, ++dup);
			} else {
				outgoingMap.put(element, 1);
			}
		}
		return outgoingMap;
	}
	
	public Hashtable<String, Integer> findDups(List<String> theList) {
		//this will contain the count per element
		Hashtable<String, Integer> organizeTheDups = new Hashtable<String, Integer>();
		
		System.out.println(theList);
		
		//will hold the value of the dup counter for the given key
		Integer dupCounter = 1;
		
		//loop through theList to count the dups
		for (String element : theList ) {
			System.out.println("the element: " + element);
			
			if (organizeTheDups.containsKey(element)) {
				dupCounter = organizeTheDups.get(element);
				organizeTheDups.put(element, ++dupCounter);
			} else {
				organizeTheDups.put(element, 1);
			}
		}
		return organizeTheDups;
	}
	
	public static void main(String[] argv) {
		Raw raw = new Raw();
		
		//input is a String...need to put it into my List
		System.out.println("first argv: " + argv[0]);
		
		int counter = 0;
		
		List<Integer> theIntegerList = new ArrayList<Integer>();
		
		//for string input
		//List<String> theList = new ArrayList<String>();
		String uglyInput = argv[0];
		
		int initialInputSize = uglyInput.length();
		
		//create the list from the first argv
		while (counter++ < initialInputSize) {
			theIntegerList.add(new Integer(uglyInput.substring(0,1)));
			uglyInput = uglyInput.substring(1);
		} 
		
		//System.out.println(raw.findDups(theList));
		//System.out.println(raw.findDupsInMap(theList));
		System.out.println(raw.findLongestAscendingSet(theIntegerList));
	}

}
