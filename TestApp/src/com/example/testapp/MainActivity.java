package com.example.testapp;
//Justin Hegel Khalil- testApp- FullSail- Java-1



// import org.w3c.dom.Document;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.JHKhalil.testapp.zodiacData.GoGet;
import com.JHKhalil.testapp.zodiacData.JSON;
import com.JHKhalil.testapp.zodiacData.signSelectedSpinner;




public class MainActivity extends Activity {
	// a bunch of variables for several things
	public final static String PUBLIC_KEY = "KEYFORSIGN";
	Context currentContext;
	String[] currentItems;
	String[] inflatedItems;
	static TextView horoscopeRegion;
	EditText userText;
	String signFromSpinner;
	static String horoscopeText;
	static Button saveButton;
	Spinner spinster;
	String lastSignLoaded;
	LayoutInflater inflate;
	String element;
	String symbol;
	String appendableData;
	Button saveToFileButton;
	static String noConnectionError;
	ImageView iv;
	GridLayout first_gl;
	ViewFlipper viewflipper;
    Button openWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	// string for error message
    	noConnectionError = getString(R.string.noConnection);
    	//  view creation
    	 
    	
    	// contentview set to default
    	setContentView(R.layout.activity_main);
    	// trgeting element within layout for inflated item injection
    	GridLayout firstLayout = (GridLayout)findViewById(R.id.grid_one);
    	View spinnerView = getLayoutInflater().inflate(R.layout.spinner_layout, firstLayout, false);
    	View secondRowView = getLayoutInflater().inflate(R.layout.second_row_layout,  firstLayout, false);
    	// adding views to layout
    	firstLayout.addView(spinnerView);
    	firstLayout.addView(secondRowView);
    	
    	// define button parameters
    	openWeb = (Button)findViewById(R.id.openWeb);
    	openWeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	// get string for url
            	String signThingy = getSignFromSpinner();
            	openWebView(signThingy);
            } 
        });
    	// add element image by inflating element xml file.
    	LinearLayout existing_ll = (LinearLayout) findViewById(R.id.linlay_two);
    	iv = (ImageView)getLayoutInflater().inflate(R.layout.element_image, null);
    	existing_ll.addView(iv);
    	//
    	setContentView(firstLayout);
    	
    	
    	// define spinner
    	// get simple signs list for correlating with full sign array strings
    	spinster = (Spinner) findViewById(R.id.sign_spinner);
    	String[] signsArray = getResources().getStringArray(R.array.oneWordSignArray);
		  
    	int i;
    	String xist = GoGet.readStringFromFile("userSign", null);
    	if (xist.length() > 0){
    		currentItems = getResources().getStringArray(R.array.signArray);
    		// determine what the string of the currently saved item is
    		// check it against spinner items
    		for(i = 0; i <= currentItems.length; i++) {
    			String theOneHere = signsArray[i];
    			if (theOneHere.equals(xist)){
    				// set selection to saved item
    				spinster.setSelection(i);
    				System.out.println(" outputting for a match: " + theOneHere + xist);
    				break;
    			}
    			
				
    			  
    			}
    	}
    	// make a bunch of referencing objects
    	currentContext = this;
    	currentItems = getResources().getStringArray(R.array.signArray);
    	horoscopeRegion = (TextView) findViewById(R.id.horoscopeDisplay);
    	saveButton = (Button) findViewById(R.id.signSelectedButton);
    	saveToFileButton = (Button) findViewById(R.id.saveSetting);
    	lastSignLoaded = "";
    	//// set horoscope area with loading message
    	horoscopeRegion.setText(R.string.loading);
    	addListenerOnSpinnerItemSelection();
    	
    	
    	saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	// refreshbutton details.
            	// get string from spinner
            	String signThingy = getSignFromSpinner();
            	// load data and change layout based on sign
            	loadAndSetHoroscope(signThingy);
            } 
        });
    	saveToFileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	// save sign to file for defaults on startup
            	String signThingy = getSignFromSpinner();
            	GoGet.writeStringToFile(signThingy, "userSign", false);
            	GoGet.writeFile(signThingy);
            	// testoutput
            	System.out.println("testing this: " + signThingy);
            } 
        });
    	// String signThingy = getSignFromSpinner();
    	signFromSpinner = spinster.getSelectedItem().toString();
    	final Handler h = new Handler();
        h.postDelayed(new Runnable()
        {
        	// do a bit of looping through the loading process
        	// many httpget attempts (to my api) time-out. 
           
            @Override
            public void run()
            {
            	String signThingy = getSignFromSpinner();
            	if (lastSignLoaded != signThingy){
            		refreshInfo();
            	}
            }}, 2500);
    	
    }
    

    
      public void setText(String inputString, String targetId, String elementName){
    	// some of this is leftover from testing phase
    	  if (targetId == "horoscopeRegion"){
    		  String newLine = "\n";
    		String signThingy = getSignFromSpinner();
    		String appNamePrefix = getString(R.string.app_name);
      		setTitle(appNamePrefix + " for " + signThingy);
    		final TextView horoscopeRegion = (TextView) findViewById(R.id.horoscopeDisplay);
    		appendableData = JSON.readJSON(signThingy);
    		String elementString = JSON.readElement(signThingy);
    		// get element to define imageview and colors for the horoscope box
    		horoscopeRegion.setText(appendableData + newLine + inputString);
    		lastSignLoaded = signThingy;
    		if (elementString != null){
    			System.out.println(elementString);
    			// set image and colors
    			if (elementString == "Fire"){
        			iv.setImageResource(R.drawable.fire_el);
        			horoscopeRegion.setBackground(getResources().getDrawable(R.drawable.rounded_box_gradient_red));
        		} else if (elementString == "Water"){
        			iv.setImageResource(R.drawable.water_el);
        			horoscopeRegion.setBackground(getResources().getDrawable(R.drawable.rounded_box_gradient_blue));
        		} else if (elementString == "Earth"){
        			iv.setImageResource(R.drawable.earth_el);
        			horoscopeRegion.setBackground(getResources().getDrawable(R.drawable.rounded_box_gradient_brown));
        		} else if (elementString == "Air"){
        			iv.setImageResource(R.drawable.air_el);
        			horoscopeRegion.setBackground(getResources().getDrawable(R.drawable.rounded_box_gradient_paleblue));
        		}
    		}
    		
    		
    	  }
    	  
      }
     
      public void addListenerOnSpinnerItemSelection() {
    		spinster = (Spinner) findViewById(R.id.sign_spinner);
    		spinster.setOnItemSelectedListener(new signSelectedSpinner());
      }
      public void loadAndSetHoroscope(String stringToGet){
    	// use string as key for calling horoscope method in GoGet
    	  new Thread(new Runnable() { 
              public void run(){
            	  String signThingy = getSignFromSpinner();
            	  signFromSpinner = spinster.getSelectedItem().toString();
            	  GoGet gg = new GoGet();
            	  horoscopeText = gg.horoscope(getApplicationContext(), signThingy);
            	  runOnUiThread(new Runnable() {
            		  public void run() {
            			// check response for viability
            			  String signThingy = getSignFromSpinner();
            			  if (horoscopeText.length() > 0){
            				  
            				  setText(horoscopeText, "horoscopeRegion", null);
            				  appendableData = JSON.readJSON(signThingy);
            				  lastSignLoaded = signThingy;
            			  } else {
            				// if it isn't any good, display the error
            				  horoscopeText = getString(R.string.noConnection);
            			  }
         

            		  }
            	  });
              }}).start();
    	  if (horoscopeText != null){
    		// again, checking for errors
    		  if (horoscopeText.length() <= 0){
    			  horoscopeText = getString(R.string.noConnection);
    		  }
    		  
    	  } else if (horoscopeText == null){
    		// again, checking for more errors
    		  horoscopeText = getString(R.string.noConnection);
    		  horoscopeRegion.setText(horoscopeText);
    		  
    		  
    	  }
    	  
      }
      
      public static void setHoroscopeText(String newText){
    	  if (newText != null){
    		  if (newText.length() <= 0){
    			// again, displaying errors
    			  horoscopeText = noConnectionError;
    		  }
    		  
    	  } else {
    		  horoscopeRegion.setText(horoscopeText);
    	  }
    	  horoscopeRegion.setText(newText + horoscopeText);
      }
      
      
      public Context relayContext(){
    	// method for returning context to other classes
    	  return currentContext;
      }
      public void setLoadedSign(String signString){
    	  lastSignLoaded = signString;
    	// method for setting lastloaded string for comparing with currently selected string
      }
      public void refreshInfo(){
    	// basically just checks customizable elements and updates them if they are out of step
    	  final Handler h = new Handler();
          h.postDelayed(new Runnable()
          {
          	  @Override
              public void run()
              {
            	  int limiter = 0;
            	  String signThingy = getSignFromSpinner();
              	if (lastSignLoaded != signThingy){
              		limiter++;
              		if (limiter < 10){
              			loadAndSetHoroscope(signThingy);
              			Log.d("Timer", signThingy + lastSignLoaded + limiter);
                        
              		}
              		
                      
                      
              	}// h.postDelayed(this, 2500);
              	
              }}, 2500);
      }
      public View getView(int position, View convertView, ViewGroup parent) {
    	    if (convertView == null) {
    	        convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.linear_for_grid, parent, false);
    	    }
    	 
    	    return convertView;
    	}
      public static String getHoroscopeTextForComparison(){
    	  return horoscopeText;
      }
      public static void getError(String type){
    	  horoscopeText = type;
      }
      public String getSignFromSpinner(){
    	// use array from resources for correlating with spinner array
    	  String[] signsArray = getResources().getStringArray(R.array.oneWordSignArray);
    	  
    	  int indexy = spinster.getSelectedItemPosition();
    	  String returner = signsArray[indexy];
    	  return returner;
      }
      private void openWebView(String sign){
    	// functionally similar in concept to the horoscope, using sign as key for loading.
    	// load webview intent, sending it the sign for url construction
    	  String signThingy = getSignFromSpinner();	
    	  Intent intent = new Intent(this, WebViewActivity.class);
    	  intent.putExtra(PUBLIC_KEY, signThingy);
    	  startActivity(intent);
    	  loadAndSetHoroscope(signThingy);
      }
}	
