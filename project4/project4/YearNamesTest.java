package project4;

import static org.junit.Assert.*;

import org.junit.Test;

public class YearNamesTest {

	@Test
	public void testAdd() {
		YearNames test = new YearNames(1880);
		
		Name chris = new Name("Zbby","F",1000);
		Name chris2 = new Name("Zbby","F",1000);
		Name abby = new Name("Xbby","F",700);
		Name abby6 = new Name("Xbby","F",710);
		Name abby2 = new Name("Mbby","F",800);
		Name abby3 = new Name("Kbby","F",500);
		Name abby4 = new Name("Fbby","F",600);
		Name abby5 = new Name("Zbby","F",1300);
		Name abby7 = new Name("Zvby","F",1300);
		Name abby8 = null;
		
		
		try {
			test.add(abby8);
		} catch (Exception e) {
			System.out.println("Caught the null");
		}
		
		try {
			test.add(chris);
			test.add(chris2);
		} catch (Exception e) {
			System.out.println("Caught the duplicate");
		}

		

	}
	
	@Test
	public void testGetCountByName() {
		YearNames test = new YearNames(1880);
		
		Name abby = new Name("abby","f",1);
		Name chris = new Name("Chris","M",2);
		Name erick = new Name("ERICK", "M", 3);
		Name clauds = new Name("Clauds", "F", 4);
		Name fake = new Name("Fake","M",2);
		
		test.add(abby);
		test.add(chris);
		test.add(erick);
		test.add(clauds);
		test.add(fake);
		
		int ans = test.getCountByName("cHrIs","m");
		int ans2 = test.getCountByName("ABBY", "F");
		int ans3 = test.getCountByName("erick", "M");
		int ans4 = test.getCountByName("ClaudS", "F");
		int ans5 = test.getCountByName("George", "F");

		
		assertTrue("Get Count by Name is wrong",ans==chris.getCount());
		assertTrue("Get Count by Name is wrong",ans2==abby.getCount());
		assertTrue("Get Count by Name is wrong",ans3==erick.getCount());
		assertTrue("Get Count by Name is wrong",ans4==clauds.getCount());
		assertFalse("Get Count by Name is wrong",ans5==fake.getCount());
		
		
	}
	
	@Test
	public void testFractionMethod() {
		YearNames test = new YearNames(1880);
		
		Name abby = new Name("abby","f",1);
		Name chris = new Name("Chris","M",1);
		
		test.add(abby);
		test.add(chris);
		
		try {
			test.getFractionByName(null, "F");
		} catch (Exception e) {
			System.out.println("Caught the null in the get fraction method");
		}
		

		try {
			test.getFractionByName("F", null);
		} catch (Exception e) {
			System.out.println("Caught the null in the get fraction method");
		}
		

		try {
			test.getFractionByName("Foobar", "Z");
		} catch (Exception e) {
			System.out.println("Caught the incorrect value in the get fraction method");
		}
		
		double ans = test.getFractionByName("ABBY", "F");
		double ans2 = test.getFractionByName("cHRIS", "m");
		
		assertTrue("There is a problem with the getFraction method",ans==0.5);
		assertTrue("There is a problem with the getFraction method",ans2==0.5);
		
	}

}
