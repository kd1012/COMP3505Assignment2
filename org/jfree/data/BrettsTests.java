package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeTest {

//	private Range exampleRange;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	@BeforeEach
	void setUp() throws Exception {
	}
	
//	@Test
//	void test() {
//		exampleRange = new Range(-1, 1);
//		assertEquals(0, exampleRange.getCentralValue(), 0.1d,"The central value of (-1, 1) is 0");
//	}
	
//	 equals
//
//	 public boolean equals(java.lang.Object obj)
//
//	     Tests this object for equality with an arbitrary object. 
	
	@Test
	void testEqualsEquivalentRange() {
		Range r1 = new Range(1.0, 5.0);
		Range r2 = new Range(1.0, 5.0);
		assertTrue(r1.equals(r2));
	}

	@Test
	void testEqualsDifferentUpperRange() {
		Range r1 = new Range(1.0, 5.0);
		Range r2 = new Range(1.0, 6.0);
		assertFalse(r1.equals(r2));
	}

	@Test
	void testEqualsDifferentLowerRange() {
		Range r1 = new Range(1.0, 5.0);
		Range r2 = new Range(2.0, 5.0);
		assertFalse(r1.equals(r2));
	}

	@Test
	void testEqualsNullRange() {
		Range r1 = new Range(1.0, 5.0);
		assertFalse(r1.equals(null));
	}

	@Test
	void testEqualsNonRangeObject() {
		Range r1 = new Range(1.0, 5.0);
		Object obj = new Object();
		assertFalse(r1.equals(obj));
	}
	
//	 expand
//
//	 public static Range expand(Range range,
//	                            double lowerMargin,
//	                            double upperMargin)
//
//	     Creates a new range by adding margins to an existing range. For example: expand(new Range(2, 6), 0.25, 0.5) returns a range from 1 to 8. 
	
//	https://www.geeksforgeeks.org/java/lambda-expressions-java-8/
	@Test
	void testExpandNullRangeThrowsException() {
		assertThrows(InvalidParameterException.class, () -> Range.expand(null, 0.5, 0.5));
	}

	@Test
	void testExpandNegativeMargins() {
		Range base = new Range (5, 10);
		Range result = Range.expand(base, -0.5, -0.75);

		assertEquals(7.5, result.getLowerBound(), 0.00001);
		assertEquals(6.25, result.getUpperBound(), 0.00001);
	}

	@Test
	void testExpandPositiveMargins() {
		Range base = new Range (5, 10);
		Range result = Range.expand(base, 0.5, 0.75);

		assertEquals(2.5, result.getLowerBound(), 0.00001);
		assertEquals(13.75, result.getUpperBound(), 0.00001);
	}

	@Test
	void testExpandZeroedMargins() {
		Range base = new Range (5, 10);
		Range result = Range.expand(base, 0.0, 0.0);

		assertEquals(5.0, result.getLowerBound(), 0.00001);
		assertEquals(10.0, result.getUpperBound(), 0.00001);
	}
	
//	 expandToInclude
//
//	 public static Range expandToInclude(Range range,
//	                                     double value)
//
//	     Returns a range that includes all the values in the specified range AND contains the specified value. 
	
	
	
	@AfterEach
	void tearDown() throws Exception {
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}
