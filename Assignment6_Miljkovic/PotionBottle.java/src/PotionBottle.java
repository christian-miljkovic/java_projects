
class Potion {
	private static int bottleSize = 0;
	private static String ingredients="null";
	
	Potion () {
		bottleSize = 10;
		ingredients= "null";
	}
	
	Potion (int newBottleSize) {
		bottleSize = newBottleSize;
		ingredients= "null";
	}
	
	public boolean addIngredient(char ingredient) {
		if (ingredients.length() < bottleSize) 
			Potion.ingredients += ingredient;
		
		return false;
		
	}

	
	public String toString() {
		String ingredientsList ="null";
		for (int i=0; i < Potion.ingredients.length(); i++) {
			ingredientsList +=Potion.ingredients.charAt(i);
		}
		return ingredientsList;
	}
	
}






