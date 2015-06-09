package com.datastructures;

import java.util.ArrayList;

public class Merger {
	
	public ArrayList<String> merge(String[] words, String[] more) {
		ArrayList<String> sentence = new ArrayList<String>();
		
		words[0] = "Tracy";
		words[1] = "changed";
		words[2] =  "the";
		words[3] = "words.";
		
		for (String w: words) 
			sentence.add(w);
		
		for (String w : more) 
			sentence.add(w);
		
		return sentence;
	}

	public static void main(String[] argv) {
		
		String[] words = {"This", "is", "the", "first", "string", "array."};
		String[] more = {"The", "second", "looks", "like", "this."};
		
		Merger merger = new Merger();
		System.out.println(merger.merge(words, more));
		
		for (String w : words)
			System.out.println(w);
		
	}
}
