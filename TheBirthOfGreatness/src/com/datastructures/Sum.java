package com.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Sum {
	public List<Integer> add(List<Integer> list1, List<Integer> list2) {
		List<Integer> sum = new ArrayList<Integer>();
		
		list1.add(2);
		list1.add(4);
		list2.add(10);
		
		System.out.println(list1);
		System.out.println(list2);
		
		int i=list1.size()-1;

		while (i>=0) {
			if (i<list2.size())
				sum.add(list1.get(i) + list2.get(i));
			else
				sum.add(list1.get(i));
			i--;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Sum sum = new Sum();
		Creation create = new Creation();
		
		List<Integer> list1 = create.createIntegerArrayList();
		List<Integer> list2 = create.createIntegerArrayList();
		System.out.println(sum.add(list1, list2));
	}

}
