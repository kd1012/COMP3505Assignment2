package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SunnysTests {

  	@BeforeAll
  	static void setUpBeforeClass() throws Exception {
  	}
  	
  	@BeforeEach
  	void setUp() throws Exception {
  	}
	
	// getLowerBound()
	@Test
	void getLowerBound_NormalRange_ReturnsLowerBound() {
		Range range = new Range(-5, 10);
		assertEquals(-5, range.getLowerBound(), 0.0001, "Lower bound of (-5, 10) should be -5");
	}
	@Test
	void getLowerBound_DegenerateRange_ReturnsLowerBound() {
		Range range = new Range(0, 0);
		assertEquals(0, range.getLowerBound(), 0.0001, "Lower bound of (0, 0) should be 0");
	}
	@Test
	void getLowerBound_PositiveRange_ReturnsLowerBound() {
		Range range = new Range(100, 200);
		assertEquals(100, range.getLowerBound(), 0.0001, "Lower bound of (100, 200) should be 100");
	}

	// getUpperBound()
	@Test
	void getUpperBound_NormalRange_ReturnsUpperBound() {
		Range range = new Range(-5, 10);
		assertEquals(10, range.getUpperBound(), 0.0001, "Upper bound of (-5, 10) should be 10");
	}
	@Test
	void getUpperBound_DegenerateRange_ReturnsUpperBound() {
		Range range = new Range(0, 0);
		assertEquals(0, range.getUpperBound(), 0.0001, "Upper bound of (0, 0) should be 0");
	}
	@Test
	void getUpperBound_PositiveRange_ReturnsUpperBound() {
		Range range = new Range(100, 200);
		assertEquals(200, range.getUpperBound(), 0.0001, "Upper bound of (100, 200) should be 200");
	}

	// intersects() 
	@Test
	void intersects_OverlappingRight_ReturnsTrue() {
		Range range = new Range(0, 10);
		assertTrue(range.intersects(5, 15), "Range (0,10) should intersect (5,15)");
	}
	@Test
	void intersects_OverlappingLeft_ReturnsTrue() {
		Range range = new Range(0, 10);
		assertTrue(range.intersects(-5, 5), "Range (0,10) should intersect (-5,5)");
	}
	@Test
	void intersects_NoOverlap_ReturnsFalse() {
		Range range = new Range(0, 10);
		assertFalse(range.intersects(15, 20), "Range (0,10) should not intersect (15,20)");
	}
	@Test
	void intersects_SpecifiedRangeFullyInside_ReturnsTrue() {
		Range range = new Range(0, 10);
		assertTrue(range.intersects(2, 8), "Range (0,10) should intersect (2,8)");
	}
	@Test
	void intersects_SpecifiedRangeFullyContains_ReturnsTrue() {
		Range range = new Range(0, 10);
		assertTrue(range.intersects(-2, 12), "Range (0,10) should intersect (-2,12)");
	}
	@Test
	void intersects_AdjacentNoOverlap_ReturnsFalse() {
		Range range = new Range(0, 10);
		assertFalse(range.intersects(10, 20), "Range (0,10) should not intersect (10,20) when no overlap");
	}

	// shift())
	@Test
	void shift_PositiveDelta_ShiftsRangeRight() {
		Range base = new Range(0, 10);
		Range result = Range.shift(base, 5);
		assertEquals(5, result.getLowerBound(), 0.0001, "Shifted range lower bound should be 5");
		assertEquals(15, result.getUpperBound(), 0.0001, "Shifted range upper bound should be 15");
	}
	@Test
	void shift_NegativeToPositive_ShiftsRangeRight() {
		Range base = new Range(-10, 0);
		Range result = Range.shift(base, 10);
		assertEquals(0, result.getLowerBound(), 0.0001, "Shifted range lower bound should be 0");
		assertEquals(10, result.getUpperBound(), 0.0001, "Shifted range upper bound should be 10");
	}
	@Test
	void shift_ZeroWidthRange_ShiftsPositionOnly() {
		Range base = new Range(3, 3);
		Range result = Range.shift(base, 7);
		assertEquals(10, result.getLowerBound(), 0.0001, "Shifted degenerate range lower should be 10");
		assertEquals(10, result.getUpperBound(), 0.0001, "Shifted degenerate range upper should be 10");
	}
	@Test
	void shift_ZeroDelta_PreservesRange() {
		Range base = new Range(1, 5);
		Range result = Range.shift(base, 0);
		assertEquals(1, result.getLowerBound(), 0.0001, "Zero delta should preserve lower bound");
		assertEquals(5, result.getUpperBound(), 0.0001, "Zero delta should preserve upper bound");
	}

	@AfterEach
  	void tearDown() throws Exception {
  	}
	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}
}
