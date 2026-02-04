package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KierasTests {


  	@BeforeAll
  	static void setUpBeforeClass() throws Exception {
  	}
  	
  	@BeforeEach
  	void setUp() throws Exception {
  	}
  	
//We are combining the files together. This file is a combination of the Range Contains Test
// and the Range GetLength test
	
	
//CONTAINS TEST

	
  	//Values can be below the lower limit, return false
  	@Test
  	void testValueBelowLowerLimit() {
  		Range exampleRange = new Range (-1.0, 1.0);
  		assertFalse(exampleRange.contains(-1.1), "False: Value is below the lower limit");
  	}
  	
  	
  	//Values can be on the lower limit, return true (see assumption above)
  	@Test
  	void testValueEqualLowerLimit() {
  		Range exampleRange = new Range (-1.0, 1.0);
  		assertTrue(exampleRange.contains(-1.0), "True: Value is equal to the lower limit");
  	}
  	
  	
  	//Values can be inside the range, return true
	@Test
	void testValueInsideRange() {
		Range exampleRange = new Range (-1.0, 1.0);
		assertTrue(exampleRange.contains(0.0), "True: Value is inside the range");
		
	}
	

	//Values can be on the upper limit, return true (see assumption above)
	@Test
  	void testValueEqualUpperLimit() {
		Range exampleRange = new Range (-1.0, 1.0);
  		assertTrue(exampleRange.contains(1.0), "True: Value is equal to the upper limit");
  	}
	
	
	//Values can be above the upper limit, return false
	@Test
  	void testValueAboveUpperLimit() {
		Range exampleRange = new Range (-1.0, 1.0);
  		assertFalse(exampleRange.contains(1.1), "False: Value is above the upper limit");
  	}
	

//GET LENGTH TEST	
	@Test
	void testLengthBothNegWhole(){
		Range exampleRange = new Range (-5.0, -1.0);
		assertEquals(4.0, exampleRange.getLength(), "Length is upper limit minus lower limit, range starts and ends in negatives whole numbers");
		//System.out.println("a " + exampleRange);
		
	}
	@Test
	void testLengthBothNegDecimal(){
		Range exampleRange = new Range (-4.2, -1.6);
		assertEquals(2.6, exampleRange.getLength(), "Length is upper limit minus lower limit, range starts and ends in negative decimal numbers");
		//System.out.println("a " + exampleRange);
		
	}

	@Test
	void testLengthNegativeToPositiveWhole() {
		Range exampleRange = new Range (-1.0, 1.0);
		assertEquals(2.0, exampleRange.getLength(), "Length is upper limit minus lower limit, range spans across zero, whole numbers");
		//System.out.println( "b " + exampleRange);
	}
	
	@Test
	void testLengthNegativeToPositiveDecimal() {
		Range exampleRange = new Range (-1.5, 1.9);
		assertEquals(3.4, exampleRange.getLength(), "Length is upper limit minus lower limit, range spans across zero, decimal numbers");
		//System.out.println( "b " + exampleRange);
	}
	
	@Test
	void testLengthBothPosWhole(){
		Range exampleRange = new Range (2.0, 7.0);
		assertEquals(5.0, exampleRange.getLength(), "Length is upper limit minus lower limit, range starts and ends in positive whole numbers");
		//System.out.println("c " + exampleRange);
		
	}
	
	@Test
	void testLengthBothPosDecimal(){
		Range exampleRange = new Range (2.5, 6.3);
		assertEquals(3.8, exampleRange.getLength(), "Length is upper limit minus lower limit, range starts and ends in positive decimal numbers");
		//System.out.println("c " + exampleRange);
		
	}
	
	@Test
	void testLengthSameNumbers(){
		Range exampleRange = new Range (0.0, 0.0);
		assertEquals(0.0, exampleRange.getLength(), "Length is upper limit minus lower limit, range is the same number");
		//System.out.println("d " + exampleRange);
		
	}

	//Supposed to fail, the docs state they should be illegal arguments
	@Test
	void testLengthLowerGreaterThanUpper(){
		Range exampleRange = new Range (5.0, 3.0);
		assertEquals(2.0, exampleRange.getLength(), "FAIL: Lower limit is greater than upper limit");
		//System.out.println("e " +exampleRange);
		
	}
	
	
  	@AfterEach
  	void tearDown() throws Exception {
  	}
  	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}

	
}
