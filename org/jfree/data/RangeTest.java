//package org.jfree.data;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//class RangeTest {
//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//
//}


package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.AfterAll; 
import org.junit.jupiter.api.AfterEach; 
import org.junit.jupiter.api.BeforeAll;
 import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;
 
class RangeTest {
              	private Range exampleRange;
              	@BeforeAll
              	static void setUpBeforeClass() throws Exception {
              	}
              	@BeforeEach
              	void setUp() throws Exception {
              	}
              	
              	@Test                	
              	void test() {
              		exampleRange = new Range(-1,1);
              		assertEquals(0, exampleRange.getCentralValue(), 0.1d, "The central value of (-1,1) is 0");
              	            //  	fail("Not yet implemented");
              	}
              	@AfterEach
              	void tearDown() throws Exception {
              	}
@AfterAll
              	static void tearDownAfterClass() throws Exception {
              	}
}