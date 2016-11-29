package project4;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest {

	/**
	 * Test to compare two objects where the output should be zero
	 */
	@Test
	public void testCompareToPositive() {
		Name n1 = new Name("tEsT", "m", 500);
		Name n2 = new Name("Test", "M", 500);

		int expectedOutput = 0;
		int actualOutput = n1.compareTo(n2);

		assertEquals("testCompareToPositive failed", expectedOutput, actualOutput);
	}

	/**
	 * Test to compare two objects where the output is nonzero
	 */
	@Test
	public void testCompareToNegativeName() {
		Name n1 = new Name("Aaaaa", "F", 500);
		Name n2 = new Name("Bbbb", "f", 500);

		int actualOutput = n1.compareTo(n2);

		// assertEquals(expectedOutput, actualOutput);
		assertTrue("testCompareToNegativeGender failed", actualOutput < 0);

		actualOutput = n2.compareTo(n1);

		// assertEquals(expectedOutput, actualOutput);
		assertTrue("testCompareToNegativeGender failed", actualOutput > 0);
	}

	/**
	 * Test to compare two objects where the output is nonzero
	 */
	@Test
	public void testCompareToNegativeGender() {
		Name n1 = new Name("Test", "F", 500);
		Name n2 = new Name("Test", "M", 500);

		// int expectedOutput = new String("F").compareTo(new String("M"));
		int actualOutput = n1.compareTo(n2);

		// assertEquals(expectedOutput, actualOutput);
		assertTrue("testCompareToNegativeGender failed", actualOutput != 0);
	}


	/**
	 * Test to compare two objects where the output is nonzero
	 */
	@Test
	public void testCompareToNegativeCount() {
		Name n1 = new Name("Test", "F", 500);
		Name n2 = new Name("Test", "F", 200);

		int actualOutput = n1.compareTo(n2);

		assertTrue("testCompareToNegativeCount failed", actualOutput != 0);
	}
	/**
	 * Test to compare two objects where the output is nonzero
	 */
	@Test public void testCompareToNonZero() {
		Name n1 = new Name("Test","M",500);
		Name n2 = new Name("Test","f",500);
		
		int actualOutput = n1.compareTo(n2);
		
		assertTrue("testCompareToNonZero failed",actualOutput == 1);
		
		
	}
	
	/**
	 * Test to compare two objects where the output is nonzero
	 */
	@Test public void testCompareToNegative() {
		Name n1 = new Name("Test","F",500);
		Name n2 = new Name("Test","m",500);
		
		int actualOutput = n1.compareTo(n2);
		
		assertTrue("testCompareToNegative failed",actualOutput == -1);
		
		
	}
	
	/**
	 * Test to compare two objects where the output is nonzero
	 */
	@Test public void testCompareToPositiveOne() {
		Name n1 = new Name("Test","F",600);
		Name n2 = new Name("Test","f",500);
		
		int actualOutput = n1.compareTo(n2);
		
		assertTrue("testCompareToPostivieOne failed",actualOutput == 1);
		
		
	}

	
	/**
	 * Test to compare two objects where the output is nonzero
	 */
	@Test public void testCompareTo() {
		Name n1 = new Name("Test","F",500);
		Name n2 = new Name("Test","f",600);
		
		int actualOutput = n1.compareTo(n2);
		
		assertTrue("testCompareTo failed",actualOutput == -1);
		
		
	}
	
	/**
	 * Test to compare two objects where the output is nonzero
	 */
	@Test public void testCompareToZero() {
		Name n1 = new Name("Test","F",600);
		Name n2 = new Name("Test","f",600);
		
		int actualOutput = n1.compareTo(n2);
		
		assertTrue("testCompareToZero failed",actualOutput == 0);
		
		
	}
}
