package com.example.testapp;

public class JSONThingyFile {
	
	public enum Signs {
		CAP("Capricorn:", "Earth", "The Goat"), 
		AQU("Aquarius:", "Air", "The Water-Bearer"), 
		PIS("Pisces:", "Water", "The Fishes"), 
		ARI("Aries:", "Fire", "The Ram"), 
		TAU("Taurus:", "Earth", "The Bull"), 
		GEM("Gemini:", "Air", "The Twins"), 
		CAN("Cancer:", "Water", "The Crab"), 
		LEO("Leo:", "Fire", "The Lion"), 
		VIR("Virgo:", "Earth", "The Maiden"), 
		LIB("Libra:", "Air", "The Scales"), 
		SCO("Scorpio:", "Water", "The Scorpion"), 
		SAG("Sagittarius:", "Fire", "The (Centaur) Archer");
		
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
		public String setEleentName(){
			return elementName;
		}
		
	}
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
