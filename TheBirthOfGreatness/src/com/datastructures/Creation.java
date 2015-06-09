package com.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;



public class Creation {
	
	@SuppressWarnings("serial")
	public Hashtable<String, Integer> createHashtable() {
		return new Hashtable<String, Integer>()
				{{put("one", 1);}};
				
	}
	
	@SuppressWarnings("serial")
	public HashMap<String, Integer> createHashMap() {
		return new HashMap<String, Integer>()
				{{put("one", 1);}};
				
	}
	

	@SuppressWarnings("serial")
	public List<String> createArrayList() {
		return new ArrayList<String>()
				{{add("one");}};
				
	}
	
	@SuppressWarnings("serial")
	public List<Integer> createIntegerArrayList() {
		return new ArrayList<Integer>()
				{{add(1);}};
				
	}

	
	@SuppressWarnings("serial")
	public List<String> createLinkedList() {
		return new LinkedList<String>()
				{{add("one");}};
				
	}
	
	@SuppressWarnings("serial")
	public Set<String> createHashSet() {
		return new HashSet<String>() 
				{{ add("one"); }};
	}

}
