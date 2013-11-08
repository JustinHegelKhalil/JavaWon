package com.example.testapp;


public enum Signs {
	Capricorn("Capricorn", "Earth"), 
	Aquarius("Aquarius","Esdrth"), 
	Pisces("Pisces", "Eawr"), 
	Aries("Aries", "Eawrth"), 
	Taurus("Taurus", "Eawrth"), 
	Gemini("Gemini", "Eaewrth"), 
	Cancer("Cancer", "Eaw2rth"), 
	Leo("Leo", "Eawrth"), 
	Virgo("Virgo", "Eawrth"), 
	Libra("Libra", "Eawrllgth"), 
	Scorpio("Scorpio", "Eawrth"), 
	Sagittarius("Sagittarius", "Eyawrth");
	
	final String signName;
	final String elementName;
	
	
	private Signs(String signName, String elementName) {
		this.signName = signName;
		this.elementName = elementName;
		
		
		
	}
	public String setSignName(){
		return signName;
	}
	public String setEleentName(){
		return elementName;
	}
	
}
