package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach; 


//The doc does not specify whether or not the
//contains should be inclusive or exclusive, for the
//purpose of these tests I am assuming it is inclusive.
//Also no verify method is needed because it is not mocking anything up


class RangeContainsTest {
	
	private Range exampleRange;
	

  	@BeforeEach
  	void setUp() throws Exception {
  		exampleRange = new Range(-1, 1);
  		
  	}
	
//Values can be below the lower limit, return false
  	@Test
  	void testValueBelowLowerLimit() {
  		assertFalse(exampleRange.contains(-1.1), "False: Value is below the lower limit");
  	}
  	
  	
//Values can be on the lower limit, return true (see assumption above)
  	@Test
  	void testValueEqualLowerLimit() {
  		assertTrue(exampleRange.contains(-1.0), "True: Value is equal to the lower limit");
  	}
  	
  	
//Values can be inside the range, return true
	@Test
	void testValueInsideRange() {
		assertTrue(exampleRange.contains(0.0), "True: Value is inside the range");
		
	}
	

//Values can be on the upper limit, return true (see assumption above)
	@Test
  	void testValueEqualUpperLimit() {
  		assertTrue(exampleRange.contains(1.0), "True: Value is equal to the upper limit");
  	}
	
	
//Values can be above the upper limit, return false
	@Test
  	void testValueAboveUpperLimit() {
  		assertFalse(exampleRange.contains(1.1), "False: Value is above the upper limit");
  	}

	

}
