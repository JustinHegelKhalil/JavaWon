package info;


public class Information {	
	public enum Signs {
		Capricorn("Capricorn:", "Earth", "The Goat"), 
		Aquarius("Aquarius:", "Air", "The Water-Bearer"), 
		Pisces("Pisces:", "Water", "The Fishes"), 
		Aries("Aries:", "Fire", "The Ram"), 
		Taurus("Taurus:", "Earth", "The Bull"), 
		Gemini("Gemini:", "Air", "The Twins"), 
		Cancer("Cancer:", "Water", "The Crab"), 
		Leo("Leo:", "Fire", "The Lion"), 
		Virgo("Virgo:", "Earth", "The Maiden"), 
		Libra("Libra:", "Air", "The Scales"), 
		Scorpio("Scorpio:", "Water", "The Scorpion"), 
		Sagittarius("Sagittarius:", "Fire", "The (Centaur) Archer");
		
		final String signName;
		final String elementName;
		final String symbolName;
		
		
		private Signs(String signName, String elementName, String symbolName) {
			this.signName = signName;
			this.elementName = elementName;
			this.symbolName = symbolName;
			
			
			
		}
		public String setSignName(){
			return signName;
		}
		
		public String setElementName(){	
			return elementName;
		}
		
		public String setSymbolName(){	
			return symbolName;
		}
	}
		

		
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub

	}

}