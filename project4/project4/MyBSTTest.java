package project4;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyBSTTest {

	
	//test if the isEmpty method works without adding anything
	@Test
	public void isEmptyTest() {
		MyBST test = new MyBST();
		
		//output should be true
		boolean ans = test.isEmpty();
		
		assertTrue("The isEmpty Test is not working",ans);
		
		
	}
	
	@Test
	public void addMethodTest() {
		MyBST test = new MyBST();
		
		Name abby = new Name("Chris","F",600);
		Name chris = new Name("Chris","M",500);
		Name finn = new Name("Finn","M",500);
		
		
		boolean a = test.add(chris);
		boolean b = test.add(abby);
		boolean c = test.add(finn);
		
		//output should be false
		boolean ans = test.isEmpty();
		
		assertFalse("The add method is not working",ans);
		assertTrue("The add method is not working",a);
		assertTrue("The add method is not working",b);
		assertTrue("The add method is not working",c);
		
	}
	
	@Test
	public void addMethodTestDuplicate() {
		MyBST test = new MyBST();
		
		Name abby = new Name("Chris","F",600);
		Name abby2 = new Name("Chris","F",600);
		Name abby3 = null;
		
		
		boolean ans = test.add(abby);
		boolean ans2 = test.add(abby2);
		boolean ans3 = test.add(abby3);

		
		assertTrue("The add method is not working with duplicates",ans);
		assertFalse("The add method is not working with duplicates",ans2);
		assertFalse("The add method is not working with duplicates",ans3);
		
	}
	
	//test if the isEmpty method works with adding something
	@Test
	public void isEmptyTestFalse() {
		MyBST test = new MyBST();
		Name abby = new Name("Chris","F",600);
		test.add(abby);
		
		
		//output should be false
		boolean ans = test.isEmpty();
		
		assertFalse("The isEmpty Test is not working",ans);
		
		
	}
	
	
	@Test
	public void addMethodTestNull() {
		MyBST test = new MyBST();
		
		Name abby = null;
		
		test.add(abby);
		
		//output should be true
		boolean ans = test.isEmpty();
		
		assertTrue("The add method is not working",ans);
		
		
	}
	
	@Test
	public void TestContainsMethod() {
		MyBST test = new MyBST();
		
		Name abby = new Name("Abby","F",600);
		Name chris = new Name("Chris","M",500);
		Name finn = null;
		
		test.add(finn);
		test.add(chris);
		test.add(abby);

		
		//output should be true
		boolean ans = test.contains(abby);
		boolean ans2 = test.contains(chris);
		
		//should be false
		boolean ans3 = test.contains(finn);
		
		assertFalse("The contains method doesn't work with nulls",ans3);
		assertTrue("The contains method doesn't work",ans);
		assertTrue("The contains method doesn't work",ans2);
		
	}
	
	@Test
	public void TestFirstMethod() {
		MyBST test = new MyBST();
		
		
		Name chris = new Name("Zbby","F",1000);
		Name abby = new Name("Xbby","F",700);
		Name abby2 = new Name("Mbby","F",800);
		Name abby3 = new Name("Kbby","F",500);
		Name abby4 = new Name("Fbby","F",600);
		Name abby5 = new Name("Abby","F",300);
		
		test.add(chris);
		test.add(abby);
		test.add(abby2);
		test.add(abby3);
		test.add(abby4);
		test.add(abby5);

		
		assertTrue("The method first doesn't work",abby5.equals(test.first()));
	}
	
	
	@Test
	public void TestLastMethod() {
		MyBST test = new MyBST();
		
		
		Name chris = new Name("Abby","F",1000);
		Name abby = new Name("Bbby","F",700);
		Name abby2 = new Name("Cbby","F",800);
		Name abby3 = new Name("Ebby","F",500);
		Name abby4 = new Name("Fbby","F",600);
		Name abby5 = new Name("Gbby","F",300);
		
		test.add(chris);
		test.add(abby);
		test.add(abby2);
		test.add(abby3);
		test.add(abby4);
		test.add(abby5);

		
		assertTrue("The method first doesn't work",abby5.equals(test.last()));
	}
	
	@Test
	public void TestRemoveMethod() {
		MyBST test = new MyBST();
		
		
		Name chris = new Name("Zbby","F",1000);
		Name abby = new Name("Xbby","F",700);
		Name abby6 = new Name("Xbby","F",710);
		Name abby2 = new Name("Mbby","F",800);
		Name abby3 = new Name("Kbby","F",500);
		Name abby4 = new Name("Fbby","F",600);
		Name abby5 = new Name("Zbby","F",1300);
		Name abby7 = new Name("Zvby","F",1300);
		
		test.add(chris);
		test.add(abby);
		test.add(abby2);
		test.add(abby3);
		test.add(abby4);
		test.add(abby5);
		test.add(abby6);

		boolean ans = test.remove(null); //test a null object removed
		boolean ans2 = test.remove(abby7); //test an object that is not in the BST
		boolean ans3 = test.remove(abby5); //remove the right side of the tree no left side
		boolean ans4 = test.remove(abby3); //remove with a left node
		boolean ans5 = test.remove(abby); //remove the node with both left and right
		
		assertFalse("The method remove method doesn't work",ans);
		assertFalse("The method remove method doesn't work",ans2);
		assertTrue("The method remove method doesn't work",ans3);
		assertTrue("The method remove method doesn't work",ans4);
		assertTrue("The method remove method doesn't work",ans5);
		
		assertTrue("The remove method doesn't work",test.contains(chris));
		assertTrue("The remove method doesn't work",test.contains(abby2));
		assertTrue("The remove method doesn't work",test.contains(abby4));
		assertTrue("The remove method doesn't work",test.contains(abby6));
	}
	
	
	
	
}
