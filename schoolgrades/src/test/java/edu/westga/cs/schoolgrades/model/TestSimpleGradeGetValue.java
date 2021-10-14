package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Blair Pattison
 * @version 10/14/2021
 *
 */
class TestSimpleGradeGetValue {
	
	
	@Test
	public void shouldGetValueOfTwo() {
		SimpleGrade testGrade = new SimpleGrade(2.0);
		assertEquals(testGrade.getValue(), 2.0);
	}
	
	@Test
	public void shouldGetValueOfFourFromNoDecimal() {
		SimpleGrade testGrade = new SimpleGrade(4);
		assertEquals(testGrade.getValue(), 4.0);
	}
	
	@Test
	public void shouldGetValueOfNegativeFifty() {
		SimpleGrade testGrade = new SimpleGrade(-50);
		assertEquals(testGrade.getValue(), -50.0);
	}
	
	@Test
	public void shouldGetValueOfZero() {
		SimpleGrade testGrade = new SimpleGrade(0);
		assertEquals(testGrade.getValue(), 0.0);
	}


}
