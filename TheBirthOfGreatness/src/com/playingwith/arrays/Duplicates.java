package com.playingwith.arrays;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;




public class Duplicates {
	
	//test case
	public void testEmptyContainer(Hashtable<Integer, Integer> container) {
		//this is actually a test case....what happens if the method receives a table
		//with no keys?
		container.clear();
		playWithTheHashtable(container);
	}
	
	@SuppressWarnings("rawtypes")
	public void playWithTheHashtableStringKey(Hashtable<String, Integer> playWithMe) {
		if (!playWithMe.isEmpty()) {
			System.out.println("***************************************");
			System.out.println("PLAY WITH ME: START");
			System.out.println(playWithMe);
			
			Enumeration<Integer> tableElements = playWithMe.elements();
			while (tableElements.hasMoreElements()) {
				System.out.println("element: " + tableElements.nextElement());
			}
			
			System.out.println("***************************************");
			
			Set set = playWithMe.entrySet();
			Iterator iterator = set.iterator();
			
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry)iterator.next();
				System.out.println("set key: " + entry.getKey());
				System.out.println("set value: " + entry.getValue());
			}
			
			System.out.println("PLAY WITH ME: END");
			
		} else
			System.out.println("we have an empty container");
		
		
	}
	@SuppressWarnings("rawtypes")
	public void playWithTheHashtableStringValue(Hashtable<Integer, String> playWithMe) {
		if (!playWithMe.isEmpty()) {
			System.out.println("***************************************");
			System.out.println("PLAY WITH ME: START");
			System.out.println(playWithMe);
			
			Enumeration<String> tableElements = playWithMe.elements();
			while (tableElements.hasMoreElements()) {
				System.out.println("element: " + tableElements.nextElement());
			}
			
			System.out.println("***************************************");
			
			Set set = playWithMe.entrySet();
			Iterator iterator = set.iterator();
			
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry)iterator.next();
				System.out.println("set key: " + entry.getKey());
				System.out.println("set value: " + entry.getValue());
			}
			
			System.out.println("PLAY WITH ME: END");
			
		} else
			System.out.println("we have an empty container");
		
		
	}
	
	@SuppressWarnings("rawtypes")
	public void playWithTheHashtable(Hashtable<Integer, Integer> playWithMe) {
		if (!playWithMe.isEmpty()) {
			System.out.println("***************************************");
			System.out.println("PLAY WITH ME: START");
			System.out.println(playWithMe);
			
			Enumeration<Integer> tableElements = playWithMe.elements();
			while (tableElements.hasMoreElements()) {
				System.out.println("element: " + tableElements.nextElement());
			}
			
			System.out.println("***************************************");
			
			Set set = playWithMe.entrySet();
			Iterator iterator = set.iterator();
			
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry)iterator.next();
				System.out.println("set key: " + entry.getKey());
				System.out.println("set value: " + entry.getValue());
			}
			
			System.out.println("PLAY WITH ME: END");
			
		} else
			System.out.println("we have an empty container");
		
		
	}
	
	//assumes the array is not sorted when it comes in
	//{1,2,1,3,2,1,3,4,5,3,4,2,1} <--e.g.
	public Hashtable<Integer, Integer> accumlateDups(ArrayList<Integer> unSortedArray) {
		Hashtable<Integer, Integer> dupTable = new Hashtable<Integer, Integer>();
		
		System.out.println("unsorted array: " + unSortedArray);
		int counter = 0;
		
		while (counter < unSortedArray.size()) {
			int element = unSortedArray.get(counter++);
			int dupElement;
			if (dupTable.containsKey(element)) {
				
				//get the current value for this dupKey
				dupElement = dupTable.get(element);
				//System.out.println("dupElement: " + dupElement);
				
				//update the key/value pair
				dupTable.put(element, ++dupElement);
				
				
			} else {
				//insert a new key/value pair
				dupTable.put(element, 1);
				
			}
			
		}
		
		return dupTable;
	}
	
	@SuppressWarnings("serial")
	public Hashtable<Integer, Integer> createDummyHashtable() {
		return new Hashtable<Integer, Integer>() {{
			put(7,2);
			put(0,3);
			put(1,4);
			put(9,12);
			put(2,14);
		}};
		
	}
	
	@SuppressWarnings("serial")
	public Hashtable<Integer, String> createDummyHashtableStringValue() {
		return new Hashtable<Integer, String>() {{
			put(5,"2");
			put(0,"3!");
			put(1,"4-");
			put(2,"dong");
			put(7,"14x");
			put(3,"14x");
		}};
	}
	
	@SuppressWarnings("serial")
	public Hashtable<String, Integer> createDummyHashtableStringKey() {
		return new Hashtable<String, Integer>() {{
			put("2",5);
			put("3!",8);
			put("4-",7);
			put("dong",1);
			put("14x",2);
		}};
	}

	@SuppressWarnings("serial")
	public ArrayList<Integer> createArray() {
		
		return new ArrayList<Integer>() {{ 
		add(1); 
		add(1); 
		add(1); 
		add(5); 
		add(9); 
		add(new Integer(1));
		add(new Integer(1));
		add(2);
		add(4);
		add(2);
		add(5);
		add(9);
		add(9);
		add(2);
		add(2);
		add(1);
		}};
	}
	
	public static void main(String[] args) {
		Duplicates dups = new Duplicates();
	
		ArrayList<Integer> dupsArray = dups.createArray();
		Hashtable<Integer, Integer> theDups = dups.accumlateDups(dupsArray);
		System.out.println("the dups: " + theDups);
		
		//dups.testEmptyContainer(theDups);
		
		//dups.playWithTheHashtable(theDups);
		dups.playWithTheHashtable(dups.createDummyHashtable());
		dups.playWithTheHashtableStringValue(dups.createDummyHashtableStringValue());
		dups.playWithTheHashtableStringKey(dups.createDummyHashtableStringKey());
	}
}

