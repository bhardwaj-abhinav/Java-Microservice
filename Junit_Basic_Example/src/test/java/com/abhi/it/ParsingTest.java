package com.abhi.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ParsingTest {
	private Parsing p = new Parsing();

	@Test
	public void testStringToInt1() {
		Parsing p = new Parsing();
		Integer actual = p.stringTOInt("123");
		assertEquals(123, actual);
	}
	
	@Test
	public void testStringToInt2() {
		assertThrows(IllegalArgumentException.class, ()-> p.stringTOInt(null));
	}
	
	@Test
	public void testStringToInt3() {
		assertThrows(IllegalArgumentException.class, ()-> p.stringTOInt(""));
	}
}
