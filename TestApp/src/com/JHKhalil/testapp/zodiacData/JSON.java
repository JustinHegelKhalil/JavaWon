package com.JHKhalil.testapp.zodiacData;

import com.JHKhalil.testapp.zodiacData.Information.Signs;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;



public class JSON {
	ArrayList<String> _signTags;
	
	public static JSONObject buildJSON(){
		
			// create signs object
			JSONObject signsObject = new JSONObject();
		try {
			// make query object.
			
			JSONObject queryObject = new JSONObject();
				
				
			// make signs objects.
			
			for (Signs sign : Signs.values()){
				// make sign details object
				
				JSONObject signObject = new JSONObject();
				
				signObject.put("name", sign.setSignName());
				
				signObject.put("element", sign.setElementName());
				
				signObject.put("symbol", sign.setSymbolName());
				
				queryObject.put(sign.name().toString(), signObject);
			}
			
			signsObject.put("query", queryObject);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return signsObject;
	}
	
	public static String readJSON (String selected) {
		
		String result, signName, elementName, symbolName;
		JSONObject returnedObject = buildJSON();
		
		try {
			signName = returnedObject.getJSONObject("query").getJSONObject(selected).getString("name");
			elementName = returnedObject.getJSONObject("query").getJSONObject(selected).getString("element");
			symbolName = returnedObject.getJSONObject("query").getJSONObject(selected).getString("symbol");
			
			result = "Sign: " + signName + "\r\n" + "Element: " + elementName + "\r\n" + "Symbol: " + symbolName;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.toString();
		}
		return result;
	}
public static String readElement (String selected) {
		// get element alone for customizable interface
		String result, elementName;
		JSONObject returnedObject = buildJSON();
		
		try {
			elementName = returnedObject.getJSONObject("query").getJSONObject(selected).getString("element");
			
			result = "Element: " + elementName;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.toString();
		}
		return result;
	}
public static String readSymbol (String selected) {
	// get symbol alone for customizable interface
	String result, symbolName;
	JSONObject returnedObject = buildJSON();
	
	try {
		symbolName = returnedObject.getJSONObject("query").getJSONObject(selected).getString("symbol");
		
		result = "Symbol: " + symbolName;
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		result = e.toString();
	}
	return result;
}
	
	// to-do: create method to assign numerical values, 1-366, for each day of the year
	// including leap-days, and use it to correlate with birthdays...
	// birthdays will need to be reduced to numerical values.
	// january dates will be unchanged. feb dates are added to 31, 
	// if sum is 60 and month value is 02, it's a leap day birthday
	// else it's a march 1st birthday.
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
