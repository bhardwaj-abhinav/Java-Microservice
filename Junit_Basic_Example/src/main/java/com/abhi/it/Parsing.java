package com.abhi.it;

public class Parsing {

	public Integer stringTOInt(String s) {
		
		if(s==null || s.trim().length()==0) {
			throw new IllegalArgumentException("Input is null or empty");
		}
		
		return Integer.parseInt(s);
	}
	
}
