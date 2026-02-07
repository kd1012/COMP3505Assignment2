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




class RangeTest {
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
// 5.0-10.0 combined with 3.0-4.0 would return 3.0-10.0 etc...
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
		assertEquals(Range.combine(rangeOver1, rangeOver2).getUpperBound(), 6.0, "Range upper should be 6.0");
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
//		assertEquals(Range.combine(rangeInside1, rangeInside2).getLowerBound(), 2.0, "Range inside another should have lower bound of larger range: 2.0");
//		assertEquals(Range.combine(rangeInside1, rangeInside2).getUpperBound(), 8.0, "Range inside another should have upper bound of larger range: 8.0");
		assertEquals(Range.combine(rangeInside1, rangeInside2), rangeInside1, "Range should equal larger range");
	}
	@Test
	void testCombineNegative() throws Exception{
		Range rangeNeg1 = new Range(-4.0, -1.0);
		Range rangeNeg2 = new Range(-8.0, -5.0);
		assertEquals(Range.combine(rangeNeg1, rangeNeg2).getLowerBound(), -8.0, "Range should have lower bound of lowest negative: -8.0");
		assertEquals(Range.combine(rangeNeg1, rangeNeg2).getUpperBound(), -1.0, "Range should have upper bound of highest number: -1.0");
	}
	// Constrain function - Returns the value within the range that is closest to the specified value.
	// range 5.0-10.0 constrain 7.0 should return, below should return lowest value, above should return highest value
	@Test
	void testConstrainInside() throws Exception{
		Range rangeInside = new Range(1.0, 8.0);
		assertEquals(rangeInside.constrain(5.0), 5.0, "5.0 exists inside 1.0-8.0");
	}
	@Test
	void testConstrainBelow() throws Exception{
		Range rangeBelow = new Range(5.0, 10.0);
		assertEquals(rangeBelow.constrain(3.0), 5.0, "Value below range should return lower bound: 5.0");
	}
	@Test
	void testConstrainAbove() throws Exception{
		Range rangeAbove = new Range(5.0, 10.0);
		assertEquals(rangeAbove.constrain(13.0), 10.0, "Value above range should return upper bound: 10.0");
	}
	@Test
	void testConstrainBound() throws Exception{
		Range rangeBound = new Range(5.0, 10.0);
		assertEquals(rangeBound.constrain(5.0), 5.0, "Value at the lower bound should return :5.0");
		assertEquals(rangeBound.constrain(10.0), 10.0, "Value at the upper bound should return: 10.0");
	}
	@Test
	void testConstrainNegative() throws Exception{
		Range rangeConstrainNegative = new Range(-8.0, -1.0);
		assertEquals(rangeConstrainNegative.constrain(-5.0), -5.0, "Negative value inside range should be returned: -5.0");
	}
	@Test
	void testConstrainEmpty() throws Exception{
		Range rangeConstrainEmpty= new Range(2.0, 2.0);
		assertEquals(rangeConstrainEmpty.constrain(10.0), 2.0, "Constrained value on empty range should return value of range: 2.0");
	}
	// Shift -  Returns a range the size of the input range, which has been moved positively (to the right) by the delta value.
	// 3.0-7.0 shifted 5 should return 8.0-12.0, negative values should shift lower
	@Test
	void testShiftPositive() throws Exception{
		Range rangeShiftPos = new Range(2.2, 3.5);
		Range rangeShiftPosShifted = new Range(5.2, 6.5);
		assertEquals(Range.shift(rangeShiftPos, 3), rangeShiftPosShifted, "Shifted range should match new range");
	}
	@Test
	void testShiftNegative() throws Exception{
		Range rangeShiftNeg = new Range(2.0, 3.0);
		Range rangeShiftNegShifted = new Range(1.0,2.0);
		assertEquals(Range.shift(rangeShiftNeg, -1), rangeShiftNegShifted, "Shifted range should be 1.0-2.0");
	}
	@Test
	void testShiftNone() throws Exception{
		Range rangeShiftNone = new Range(2.0, 5.0);
		assertEquals(Range.shift(rangeShiftNone, 0), rangeShiftNone, "Shifted by none should return same range");
	}
}
