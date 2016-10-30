package project3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *  This is a JUnit test that tests the methods of the StackOfSpaces Class
 * @author christianmiljkovic
 *
 */
public class QueueOfSpacesTest {

	@Test
	public void TestSetOfSpaces() {
		QueueOfSpaces tester = new QueueOfSpaces();

		// test whether the reference variable points to something
		assertNotNull("There is a bug with the constructor", tester);

	}

	@Test
	public void TestAdd() {

		// create a new QueueOfSpaces object and SquarePosition object then add
		// the SquarePosition object
		// to the QueueOfSpaces object
		QueueOfSpaces tester = new QueueOfSpaces();
		SquarePosition s = new SquarePosition(1, 1);

		tester.add(s);

		// test to see if the QueueofSpaces is empty or not
		boolean output = tester.isEmpty();

		// return a problem if the output is false indicating the add method did
		// not work
		assertFalse("The QueueOfSpaces add method has a bug because the item was not added properly.", output);

	}

	@Test
	public void TestAdd2() {

		// create a new QueueOfSpaces object and two SquarePosition objects then
		// add the two SquarePosition objects
		// to the QueueOfSpaces object
		QueueOfSpaces tester = new QueueOfSpaces();
		SquarePosition s = new SquarePosition(1, 1);
		SquarePosition t = new SquarePosition(2, 2);

		tester.add(s);
		tester.add(t);

		// check if the second item did not accidently mess up
		// the queue by losing the reference to the front object
		assertNotNull("The QueueOfSpaces add method has a bug.", tester);

	}

	@Test
	public void TestAdd3() {

		// create a new QueueOfSpaces object and two SquarePosition objects then
		// add the two SquarePosition objects
		// to the QueueOfSpaces object
		QueueOfSpaces tester = new QueueOfSpaces();
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
		assertEquals("The QueueOfSpaces add method has a bug.", s2, t2);

	}
	
	@Test
	public void TestAdd4() {
		//test if adding null changes the size of the Queue
		QueueOfSpaces tester = new QueueOfSpaces();
		SquarePosition s = null;
		
		tester.add(s);
		
		assertTrue("The Queue should not have any elements in it.",tester.isEmpty());
		
	}

	@Test
	public void TestIsEmpty() {
		// create a new QueueOfSpaces object and then check to see if it empty
		QueueOfSpaces tester = new QueueOfSpaces();
		boolean output = tester.isEmpty();

		// if the output is false that indicates the empty method did not work
		assertTrue("The QueueOfSpaces isEmpty method has a bug since the boolean return was incorrect.", output);
	}

	@Test
	public void TestRemove() {
		// create a new QueueOfSpaces object and SquarePosition object then add
		// the SquarePosition object
		// to the QueueOfSpaces object
		QueueOfSpaces tester = new QueueOfSpaces();
		SquarePosition s = new SquarePosition(1, 1);
		SquarePosition t = new SquarePosition(2, 2);

		tester.add(s);
		tester.add(t);

		// collect the output to determine if the returned value from using
		// remove on a QueueOfSpaces
		// with a SquarePosition in it is correct
		SquarePosition output = tester.remove();
		SquarePosition output2 = tester.remove();

		// if output doesn't equal the initial SquarePosition then the remove
		// method didn't work
		assertEquals("The QueueOfSpaces remove method has a bug and should" + 
		" have returned the 1st SquarePosition object",
				s, output);
		assertEquals("The QueueOfSpaces remove method had a problem returning the following element",output2,t);
	

	}

	@Test
	public void TestRemove2() {
		QueueOfSpaces tester = new QueueOfSpaces();

		assertNull("The remove method has a bug.", tester.remove());

	}

}
