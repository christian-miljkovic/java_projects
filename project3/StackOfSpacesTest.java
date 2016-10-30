package project3;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 *  This is a JUnit test that tests the methods of the StackOfSpaces Class
 * @author christianmiljkovic
 *
 */
public class StackOfSpacesTest {

	@Test
	public void TestSetOfSpaces() {
		StackOfSpaces tester = new StackOfSpaces();

		// test whether the reference variable points to something
		assertNotNull("There is a bug with the constructor", tester);

	}

	@Test
	public void TestAdd() {

		// create a new StackOfSpaces object and SquarePosition object then add
		// the SquarePosition object
		// to the StackOfSpaces object
		StackOfSpaces tester = new StackOfSpaces();
		SquarePosition s = new SquarePosition(1, 1);

		tester.add(s);

		// test to see if the StackofSpaces is empty or not
		boolean output = tester.isEmpty();

		// return a problem if the output is false indicating the add method did
		// not work
		assertFalse("The StackOfSpaces add method has a bug.", output);

	}

	@Test
	public void TestAdd2() {

		// create a new StackOfSpaces object and two SquarePosition objects then
		// add the two SquarePosition objects
		// to the StackOfSpaces object
		StackOfSpaces tester = new StackOfSpaces();
		SquarePosition s = new SquarePosition(1, 1);
		SquarePosition t = new SquarePosition(2, 2);

		tester.add(s);
		tester.add(t);

		// check if the second item did not accidently erase the stack by losing
		// the reference to the first top object
		assertNotNull("The StackOfSpaces add method has a bug.", tester);

	}

	@Test
	public void TestAdd3() {

		// create a new StackOfSpaces object and two SquarePosition objects then
		// add the two SquarePosition objects
		// to the StackOfSpaces object
		StackOfSpaces tester = new StackOfSpaces();
		SquarePosition s = new SquarePosition(1, 1);
		SquarePosition t = new SquarePosition(1, 1);

		tester.add(s);
		tester.add(t);

		// remove the elements from the queue in order to make sure that adding
		// another element
		// did not create any problems
		SquarePosition s2 = tester.remove();
		SquarePosition t2 = tester.remove();

		// since they are equal SquarePostitions they should be equal or else
		// the add method has a bug
		assertEquals("The StackOfSpaces add method has a bug.", s2, t2);

	}
	
	@Test
	public void TestAdd4() {
		//test if adding null changes the size of the Stack
		StackOfSpaces tester = new StackOfSpaces();
		SquarePosition s = null;
		
		tester.add(s);
		
		assertTrue("The Stack should not have any elements in it.",tester.isEmpty());
		
	}

	@Test
	public void TestIsEmpty() {
		// create a new StackOfSpaces object and then check to see if it empty
		StackOfSpaces tester = new StackOfSpaces();
		boolean output = tester.isEmpty();

		// if the output is false that indicates the empty method did not work
		assertTrue("The StackOfSpaces isEmpty method has a bug.", output);
	}

	@Test
	public void TestRemove() {
		// create a new StackOfSpaces object and SquarePosition object then add
		// the SquarePosition object
		// to the StackOfSpaces object
		StackOfSpaces tester = new StackOfSpaces();
		SquarePosition s = new SquarePosition(1, 1);
		SquarePosition t = new SquarePosition(2, 2);

		tester.add(s);
		tester.add(t);

		// collect the output to determine if the returned value from using
		// remove on a StackOfSpaces
		// with a SquarePosition in it is correct
		SquarePosition output = tester.remove();
		SquarePosition output2 = tester.remove();

		// if output doesn't equal the initial SquarePosition then the remove
		// method didn't work
		assertEquals("The StackOfSpaces remove method has a problem removing top element", t, output);
		assertEquals("The StackOfSpaces remove method has a problem removing the following element", s, output2);
		assertNull("The StackOfSpaces remove method should have returned null",tester.remove());
	}

	@Test
	public void TestRemove1() {
		QueueOfSpaces tester = new QueueOfSpaces();

		assertNull("The remove method has a bug.", tester.remove());

	}

}