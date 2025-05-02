package com.abhi.it;

public class Calculator {
	
	public Integer add(int i, int j) {
		return i+j;
	}
	
	public Integer mul(int i, int j) {
		return i*j;
	}
	
	public boolean isPanindrome(String s) {
		String rev="";
		int len = s.length();
		
		for(int i = len-1; i>=0; i--) {
			rev = rev + s.charAt(i);
		}
		
		if(s.equals(rev)){
			return true;
		}
		else {
			return false;
		}
	}
}
