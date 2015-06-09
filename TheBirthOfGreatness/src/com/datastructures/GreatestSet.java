package com.datastructures;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class GreatestSet {

	private Set<Integer> outgoingSet = new HashSet<Integer>();
	private Hashtable<Set<Integer>, Integer> allSets = new Hashtable<Set<Integer>, Integer>();
	
	
	public void saveSmallerValue(Integer previous, Integer current) {
		//save the smaller value
		previous = current;
	
		//add smaller value to the set
		outgoingSet.add(previous);
	}
	
	public void saveLargerValue(Integer previous, Integer current) {
		//store all the sets in a hashtable
		//the set is the key and the length is the value
		allSets.put(outgoingSet, outgoingSet.size());
		
		
		//reset the set
		outgoingSet = new HashSet<Integer>();
		
		//add current to the next set
		outgoingSet.add(current);
		
		//save the larger value
		previous = current;
	}
	
	public Set<Integer> getGreatestSet() {
		return this.outgoingSet;
	}
	
	public Hashtable<Set<Integer>, Integer> getAllSets() {
		return this.allSets;
	}
}
