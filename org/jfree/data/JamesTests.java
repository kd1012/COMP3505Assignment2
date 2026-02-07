package org.jfree.data;
// import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//	https://docs.junit.org/5.0.1/api/org/junit/jupiter/api/Assertions.html

// combine(Range range1, Range range2)
// both null first null second null,
// far away values, adjacent values, overlapping values
//	same values, one range inside the other, negative values
//
// constrain(double value)
// value inside range, below range, above range, at the boundary of range, negative range
// empty/zero range, letters?
//
//
// shift(Range base, double delta, boolean allowZeroCrossing)
// positive delta, negative delta, no delta
// zero delta, null input,
// toString()
// positive values, negative values, across zero values, decimals,




class JamesTests {
//	Here if I need them, IDK how I'm building these yet.
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception{
//
//	}
//	@BeforeEach
//	void setUp() throws Exception {
//
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//
//	}
//	@AfterAll
//	static void tearDownAfterClass() throws Exception{
//
//	}
// Combine function tests - Creates a new range by combining two existing ranges.
	@Test
	void testCombineBothNull() throws Exception{
		assertNull( Range.combine(null, null),"Two nulls return a null");
	}
	@Test
	void testCombineFirstNull() throws Exception{
		Range rangeNull1 = new Range(1.0, 3.0);
		Range rangeNull2 = Range.combine(null,  rangeNull1);
		assertEquals(rangeNull1, rangeNull2, "A null in first place should return second place");
	}
	@Test
	void testCombineSecondNull() throws Exception{
		Range rangeNull1=new Range(2.0, 4.0);
		Range rangeNull2= Range.combine(rangeNull1, null);
		assertEquals(rangeNull2, rangeNull1, "A null in second place should return first place");
	}
	@Test
	void testCombineFar() throws Exception{
		Range rangeFar1 = new Range(2.0, 4.0);
		Range rangeFar2 = new Range(8.0, 10.0);
		Range resultRangeFar = Range.combine(rangeFar1, rangeFar2);
		assertEquals(resultRangeFar.getLowerBound(), 2.0, "Lower bound should be 2.0");
		assertEquals(resultRangeFar.getUpperBound(), 10.0, "Upper bound should be 10.0");
	}
	@Test
	void testCombineAdjacent() throws Exception{
		Range rangeNext1 = new Range(2.0, 4.0);
		Range rangeNext2 = new Range(4.0, 8.0);
		assertEquals(Range.combine(rangeNext1, rangeNext2).getLowerBound(), 2.0, "Range lower bound should be 2.0");
		assertEquals(Range.combine(rangeNext1, rangeNext2).getUpperBound(), 8.0, "Upper should be 8.0");
	}
	@Test
	void testCombineOverlap() throws Exception{
		Range rangeOver1 = new Range(2.0, 4.0);
		Range rangeOver2 = new Range(3.0, 6.0);
		assertEquals(Range.combine(rangeOver1, rangeOver2).getLowerBound(), 2.0, "Range lower should be 2.0");
		assertEquals(Range.combine(rangeOver1, rangeOver2).getUpperBound(), 6.0, "Range upper should be 8.0");
	}
	@Test
	void testCombineSame() throws Exception{
		Range rangeSame1 = new Range(2.0, 4.0);
		Range rangeSame2 = new Range(2.0, 4.0);
		assertEquals(Range.combine(rangeSame1, rangeSame2), rangeSame1, "Same range should equal any one range");
		assertEquals(Range.combine(rangeSame1, rangeSame2), rangeSame2, "Same range should equal any one range");
	}
	@Test
	void testCombineInside() throws Exception{
		Range rangeInside1 = new Range(2.0, 8.0);
		Range rangeInside2 = new Range(3.0, 7.0);
		assertEquals(Range.combine(rangeInside1, rangeInside2).getLowerBound(), 2.0, "Range inside another should have lower bound of larger range: 2.0");
		assertEquals(Range.combine(rangeInside1, rangeInside2).getUpperBound(), 8.0, "Range inside another should have upper bound of larger range: 8.0");
	}
	@Test
	void testCombineNegative() throws Exception{
		Range rangeNeg1 = new Range(-4.0, -1.0);
		Range rangeNeg2 = new Range(-8.0, -5.0);
		assertEquals(Range.combine(rangeNeg1, rangeNeg2).getLowerBound(), -8.0, "Range should have lower bound of lowest negative: -8.0");
		assertEquals(Range.combine(rangeNeg1, rangeNeg2).getUpperBound(), -1.0, "Range should have upper bound of highest number: -1.0");
	}
	// Constrain function - Returns the value within the range that is closest to the specified value.
	@Test
	void testConstrainInside() throws Exception{

	}
}
