package com.abhi.it;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator c = new Calculator();
		int ActualResult = c.add(1, 2);
		int expectedResult = 3;
		
		assertEquals(expectedResult, ActualResult);
	}
	
	@Test
	public void testMul() {
		Calculator c = new Calculator();
		int actaulResult = c.mul(2,3);
		int expectedResult = 6;
		
		assertEquals(expectedResult, actaulResult);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"liril", "madam", "abhi"})
	public void testispalindrome(String s) {
		Calculator c= new Calculator();
		boolean actual = c.isPanindrome(s);
		
		assertTrue(actual);
	}
	
}
