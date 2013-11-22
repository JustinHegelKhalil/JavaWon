package com.example.testapp;
//Justin Hegel Khalil- testApp- FullSail- Java-1



// import org.w3c.dom.Document;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.JHKhalil.testapp.zodiacData.GoGet;
import com.JHKhalil.testapp.zodiacData.JSON;
import com.JHKhalil.testapp.zodiacData.signSelectedSpinner;




public class MainActivity extends Activity {
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
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	
    	noConnectionError = getString(R.string.noConnection);
    	// View vi = li.inflate(R.layout.linear_for_grid, R.layout.activity_main); 
    	
    	setContentView(R.layout.activity_main);
    	LinearLayout existing_ll = (LinearLayout) findViewById(R.id.linlay_two);
    	iv = (ImageView)getLayoutInflater().inflate(R.layout.element_image, null);
    	existing_ll.addView(iv);
    	
    	
    	
    	
    	spinster = (Spinner) findViewById(R.id.sign_spinner);
    	
    	// spinster.setSelection(3);
    	int i;
    	boolean savedData = false;
    	String xist = GoGet.readStringFromFile("userSign", null);
    	if (xist.length() > 0){
    		currentItems = getResources().getStringArray(R.array.signArray);
    		
    		for(i = 0; i <= currentItems.length; i++) {
    			String theOneHere = currentItems[i].toString();
    			if (theOneHere.equals(xist)){
    				spinster.setSelection(i);
    				System.out.println(" outputting for a match: " + theOneHere + xist);
    				break;
    			}
    			
				
    			  
    			}
    		// signSelectedSpinner sa = new signSelectedSpinner();
    		// check file's data
    		// loadAndSetHoroscope(xist);
    		// set spinner to saved sign
    		// System.out.println(" there is a file there containing: " + xist);
    		// spinster.setSelection(i);
    	}
    	
    	currentContext = this;
    	currentItems = getResources().getStringArray(R.array.signArray);
    	horoscopeRegion = (TextView) findViewById(R.id.horoscopeDisplay);
    	saveButton = (Button) findViewById(R.id.signSelectedButton);
    	saveToFileButton = (Button) findViewById(R.id.saveSetting);
    	lastSignLoaded = "";
    	horoscopeRegion.setText(R.string.loading);
    	addListenerOnSpinnerItemSelection();
    	
    	
    	saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	loadAndSetHoroscope(signFromSpinner);
            } 
        });
    	saveToFileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	// save sign to file for defaults on startup
            	GoGet.writeStringToFile(signFromSpinner, "userSign", false);
            	GoGet.writeFile(signFromSpinner);
            } 
        });
    	signFromSpinner = spinster.getSelectedItem().toString();
    	final Handler h = new Handler();
        h.postDelayed(new Runnable()
        {
        	
           
            @Override
            public void run()
            {
            	if (lastSignLoaded != signFromSpinner){
            		refreshInfo();
            	}
            }}, 2500);
    	
    	
    	
        
    	if (savedData == true){
    		
    	} else if (savedData == false){
    		
    	}
    	// LinearLayout linear = new LinearLayout(this);
    	// LinearLayout linear = (LinearLayout)getLayoutInflater().inflate(R.layout.linear_for_grid, null);
    	
    	// itemRegion.setText("test");
    	// LinearLayout ll = (LinearLayout) findViewById(R.id.linlay_two);
    	// LinearLayout ll = (LinearLayout)getLayoutInflater().inflate(R.layout.linear_for_grid, null);

    	// TextView tv = (TextView) findViewById(R.id.grid_item_label);
    	// tv.setText(xist);
    	// ll.addView(tv);
    	
    	// ImageView imagev = new ImageView(this);
    	// existing_ll.addView(imagev);
    	// ViewGroup vg = (ViewGroup)getCurrentFocus().getParent();
    	// Context con = (Context)getApplicationContext().get.getParent();
    	
    	//existing_ll.setLayoutParams(lp);
    	//existing_ll.addView(ll);
    }
    

    
      public void setText(String inputString, String targetId, String elementName){
    	  if (targetId == "horoscopeRegion"){
    		  String newLine = "\n";
    		String appNamePrefix = getString(R.string.app_name);
      		setTitle(appNamePrefix + " for " + signFromSpinner);
    		final TextView horoscopeRegion = (TextView) findViewById(R.id.horoscopeDisplay);
    		appendableData = JSON.readJSON(signFromSpinner);
    		String elementString = JSON.readElement(signFromSpinner);
    		horoscopeRegion.setText(appendableData + newLine + inputString);
    		if (elementString != null){
    			System.out.println(elementString);
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
      /*
      public static void showOrClearElements(String signString){
    	  if (horoscopeText != null){
    		horoscopeRegion.setVisibility(View.VISIBLE);
    		horoscopeRegion.setText(horoscopeText);
    	  } else {
    		horoscopeRegion.setVisibility(View.GONE);
    	  }
      }
      */
      public void addListenerOnSpinnerItemSelection() {
    		spinster = (Spinner) findViewById(R.id.sign_spinner);
    		spinster.setOnItemSelectedListener(new signSelectedSpinner());
    		
      }
      public void loadAndSetHoroscope(String stringToGet){
    	  new Thread(new Runnable() { 
              public void run(){
            	  signFromSpinner = spinster.getSelectedItem().toString();
            	  GoGet gg = new GoGet();
            	  horoscopeText = gg.horoscope(getApplicationContext(), signFromSpinner);
            	  runOnUiThread(new Runnable() {
            		  public void run() {
            			  if (horoscopeText.length() > 0){
            				  setText(horoscopeText, "horoscopeRegion", null);
            				  // showOrClearElements(horoscopeText);
            				  appendableData = JSON.readJSON(signFromSpinner);
            				  // setHoroscopeText(horoscopeText);
            				  lastSignLoaded = signFromSpinner;
            			  } else {
            				  horoscopeText = getString(R.string.noConnection);
            			  }
         

            		  }
            	  });
              }}).start();
    	  if (horoscopeText != null){
    		  if (horoscopeText.length() <= 0){
    			  horoscopeText = getString(R.string.noConnection);
    		  }
    		  
    	  } else if (horoscopeText == null){
    		  horoscopeText = getString(R.string.noConnection);
    		  horoscopeRegion.setText(horoscopeText);
    		  
    		  
    	  }
    	  
      }
      
      public static void setHoroscopeText(String newText){
    	  if (newText != null){
    		  if (newText.length() <= 0){
    			  horoscopeText = noConnectionError;
    		  }
    		  
    	  } else {
    		  horoscopeRegion.setText(horoscopeText);
    	  }
    	  horoscopeRegion.setText(newText + horoscopeText);
    	  horoscopeRegion.setVisibility(View.VISIBLE);
    	  
      }
      
      
      public Context relayContext(){
    	  return currentContext;
      }
      public void setLoadedSign(String signString){
    	  lastSignLoaded = signString;
      }
      public void refreshInfo(){
    	  final Handler h = new Handler();
          h.postDelayed(new Runnable()
          {
          	
              @Override
              public void run()
              {
              	if (lastSignLoaded != signFromSpinner){
              		loadAndSetHoroscope(signFromSpinner);
                      
                      Log.d("Timer", signFromSpinner + lastSignLoaded);
                      h.postDelayed(this, 2500);
              	}
              	
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
     
}
