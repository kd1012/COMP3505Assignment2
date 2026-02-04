package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



//Assumption is that length is upper limit minus lower limit

class RangeGetLengthTest {

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
}
