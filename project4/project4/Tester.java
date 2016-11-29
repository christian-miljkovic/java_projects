package project4;

public class Tester {

	public static void main(String[] args) {
		
		YearNames test = new YearNames(1880);
		
		
		Name chris = new Name("Zbby","F",1000);
		Name abby = new Name("Xbby","F",700);
		Name abby2 = new Name("Mbby","F",800);
		Name abby3 = new Name("Kbby","F",500);
		Name abby4 = new Name("Fbby","F",600);
		Name abby5 = new Name("Abby","F",300);
		Name chris2 = new Name("Zbby","F",1100);
		
		test.add(chris);
		test.add(abby);
		test.add(chris2);
		test.add(abby2);
		test.add(abby3);
		test.add(abby4);
		test.add(abby5);
		
		System.out.println(test.toStringTreeFormat());
		
		BSTNode current = test.root;
		
	/*	while(current!=null) {
			System.out.println(current.getLeft() + " " + current.getRight());
			current = current.getLeft();
		}*/
		
	
		
		
		
		System.out.println(abby3.compareTo(abby));
		System.out.println(test.contains(abby5));

	}

}
