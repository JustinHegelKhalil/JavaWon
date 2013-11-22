package com.JHKhalil.testapp.zodiacData;

// to-do: add date ranges, birth stones, and sign characteristics list for quiz
public class Information {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

}
	/*
	 * cap 12-22 - 1 19
	 * aqu 1-20  - 2-19
	 * pis 2-20  - 3-20
	 * ari 3-21 - 4-19
	 * tau 4-20 - 5-20
	 * gem 5-21 - 6-20
	 * can 6-21 - 7-22
	 * leo 7-23 - 8-22
	 * vir 8-23 - 9-22
	 * lib 9-23 - 10-23
	 * sco 10-24 - 11-22
	 * sag 11-23 - 12-21
	 */
	public enum Signs {
		Capricorn("Capricorn:", "Earth", "The Goat", 12, 22, 1, 19), 
		Aquarius("Aquarius:", "Air", "The Water-Bearer", 1, 20, 2, 19), 
		Pisces("Pisces:", "Water", "The Fishes", 2, 20, 3, 20), 
		Aries("Aries:", "Fire", "The Ram", 3, 21, 4, 19), 
		Taurus("Taurus:", "Earth", "The Bull", 4, 20, 5, 20), 
		Gemini("Gemini:", "Air", "The Twins", 5, 21, 6, 20), 
		Cancer("Cancer:", "Water", "The Crab", 6, 21, 7, 22), 
		Leo("Leo:", "Fire", "The Lion", 7, 23, 8, 22), 
		Virgo("Virgo:", "Earth", "The Maiden", 8, 23, 9, 22), 
		Libra("Libra:", "Air", "The Scales", 9, 23, 10, 23), 
		Scorpio("Scorpio:", "Water", "The Scorpion", 10, 24, 11, 22), 
		Sagittarius("Sagittarius:", "Fire", "The (Centaur) Archer", 11, 23, 12, 21);
		
		final String signName;
		final String elementName;
		final String symbolName;
		final int birthMonthStart;
		final int birthDayStart;
		final int birthMonthEnd;
		final int birthDayEnd;
		
		private Signs(String signName, String elementName, String symbolName, int birthMonthStart, int birthDayStart, int birthMonthEnd, int birthDayEnd) {
			this.signName = signName;
			this.elementName = elementName;
			this.symbolName = symbolName;
			this.birthMonthStart = birthMonthStart;
			this.birthDayStart = birthDayStart;
			this.birthMonthEnd = birthMonthEnd;
			this.birthDayEnd = birthDayEnd;
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
		public int setBirthMonthStart(){
			return birthMonthStart;
		}
		public int setBirthMonthEnd(){
			return birthMonthEnd;
		}
		public int setBirthDayStart(){
			return birthDayStart;
		}
		public int setBirthDayEnd(){
			return birthDayEnd;
		}
	}
		

		
		
}