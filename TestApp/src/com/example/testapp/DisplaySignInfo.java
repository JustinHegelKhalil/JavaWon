package com.example.testapp;

// import org.json.JSONException;
// import org.json.JSONObject;

// import java.io.File;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.JHKhalil.testapp.zodiacData.ConnectionCzech;
import com.JHKhalil.testapp.zodiacData.GoGet;
import com.JHKhalil.testapp.zodiacData.JSON;
// import java.io.FileNotFoundException;
// import java.io.OutputStreamWriter;
// import android.util.Log;
// import android.content.Context;
// import com.JHKhalil.testapp.zodiacData.GoGet;

public class DisplaySignInfo extends Activity {

	static String signConst = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		boolean connected = ConnectionCzech.CheckInternetConnection(getApplicationContext());
		if (GoGet.readFromStatusFile().length() <= 1){
			// connected = false;
		}
		// super basic setup stuff.
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_sign_info);
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.USER_INPUT);
		signConst = message;
		LinearLayout linear;
		linear = new LinearLayout(this);
		linear.setOrientation(LinearLayout.VERTICAL);
		TextView signTitle = new TextView(this);
		signTitle.setText(message);
		linear.addView(signTitle);
		setContentView(linear);
		// a lot of this is here for testing, as the JSON object is built-up 
		// gradually, the raw output is helpful.
		String info = JSON.readJSON(message);
		signTitle.setText(info);
		LinearLayout leftSide;
		leftSide = new LinearLayout(this);
		linear.addView(leftSide);
		String elementString = JSON.readElement(message);
		String symbolString = JSON.readSymbol(message);
		// Layout code
		RelativeLayout relativeLayout = new RelativeLayout(this);
		
        // setting relativeLayout layout parameters
        RelativeLayout.LayoutParams rellaypar = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        // new textviews for element
        TextView name = new TextView(this);
        TextView element = new TextView(this);
        TextView symbol = new TextView(this);
        name.setText(message);
        name.setTextSize(30);
        element.setText(elementString);
        element.setTextSize(20);
        symbol.setText(symbolString);
        symbol.setTextSize(20);
        // creating subViews (that's iOS thinking, gotta not do that.)
        // creating "nested" views. Or, views for nesting.
        RelativeLayout.LayoutParams nameLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        nameLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        
        RelativeLayout.LayoutParams Llaypar = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        Llaypar.addRule(RelativeLayout.CENTER_HORIZONTAL);
        
        RelativeLayout.LayoutParams midPar = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        // midPar.addRule(RelativeLayout.CENTER_HORIZONTAL);
        
        // Setting the parameters on the text
        name.setLayoutParams(nameLayout);
        RelativeLayout centerLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams centerLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        centerLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        centerLayout.setLayoutParams(centerLayoutParams);
        // Adding the name to the centered layout
        // also retrofitting layouts with ID numbers so that they can reference
        // each-other for alignment purposes.
        centerLayout.addView(name);
        centerLayout.setId(111);
        midPar.setMargins(20, 10, 90, 10);
        element.setLayoutParams(midPar);
        element.setId(101);
        name.setId(010);
        symbol.setId(3232);
        midPar.addRule(RelativeLayout.BELOW, centerLayout.getId());
        Llaypar.addRule(RelativeLayout.BELOW, element.getId());
        Llaypar.addRule(RelativeLayout.ALIGN_LEFT, element.getId());
        symbol.setLayoutParams(Llaypar);
        TextView noticeText = new TextView(this);
        RelativeLayout.LayoutParams noticeP = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
    	// noticeP.addRule(RelativeLayout.CENTER_HORIZONTAL);
    	// noticeP.addRule(RelativeLayout.CENTER_VERTICAL);
        
        noticeText.setLayoutParams(noticeP);
        relativeLayout.addView(centerLayout);
        relativeLayout.addView(element);
        relativeLayout.addView(symbol);
        noticeP.setMargins(20, 5, 20, 10);
        
        // checking for internet connection.
        TextView hScope = new TextView(this);
        hScope.setLayoutParams(noticeP);
        
        
        if (connected == false) {
        	noticeText.setText(R.string.noConnection);
        	hScope.setText(R.string.noConnection);
            relativeLayout.addView(hScope);
            hScope.setId(201);
        	hScope.setTextSize(20);
        	
        }
        	
        	
        	if (connected == true) {
        	// some of my testing protocols are strange, but I find them helpful, as I often -
        	// forget things I've done earlier so it helps to have visual reminders.
        	
        	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        	StrictMode.setThreadPolicy(policy); 
        	
        	String horrorScope = ConnectionCzech.getHoroscope(getApplicationContext(), message);
        	
        	
        	hScope.setText(horrorScope);
        	hScope.setId(201);
        	hScope.setTextSize(20);
        	
        	
        	
        	TextView hIdentifier = new TextView(this);
        	hIdentifier.setText(R.string.Horoscope);
        	hIdentifier.setTextSize(20);
        	hIdentifier.setId(2121);
        	RelativeLayout.LayoutParams hip = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
        	hip.addRule(RelativeLayout.BELOW, symbol.getId());
        	// hip.addRule(RelativeLayout.ALIGN_LEFT, hScope.getId());
        	hip.setMargins(20, 10, 20, 5);
        	hIdentifier.setLayoutParams(hip);
        	relativeLayout.addView(hIdentifier);
        	noticeP.addRule(RelativeLayout.BELOW, hIdentifier.getId());
        	relativeLayout.addView(hScope);
        	
        	Button saveButton = new Button(this);
        	saveButton.setText(R.string.saveButtonText);
        	relativeLayout.addView(saveButton);
        	
        	saveButton.setOnClickListener(new View.OnClickListener() {
    			@Override
    			public void onClick(View v) {
    				String externalStoragePath = Environment.getExternalStorageDirectory().toString();
    				File root = new File(Environment.getExternalStorageDirectory(), "savers");
    				if (!root.exists()) {
    		            root.mkdirs();
    		        }
					File theFile = new File(externalStoragePath, "userSign.txt");
    				FileOutputStream outputStream;
    				try {
    				    outputStream = new FileOutputStream(theFile);
    				   	String data = signConst;
    				    outputStream.write(data.toString().getBytes());
    				} catch (IOException e) {
    				    e.printStackTrace();
    				    try {
    				    	theFile.createNewFile();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
    				} 
    				    } 
    				
    				
    			}
    		);
        	
        	Button reselectButton = new Button(this);
        	reselectButton.setText(R.string.reselect);
        	
        	RelativeLayout.LayoutParams rech = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
        	rech.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        	rech.addRule(RelativeLayout.ALIGN_TOP);
        	reselectButton.setLayoutParams(rech);
        	relativeLayout.addView(reselectButton);
        	reselectButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String externalStoragePath = Environment.getExternalStorageDirectory().toString();
    				
    				File theFile = new File(externalStoragePath, "userSign.txt");
    				theFile.delete();
    				finish();
				}
			});
        }
        	
        
        // System.out.println(newString);
        // name.setText(newString);
        // add centered layout to main layout
        
        // adding supplemental textviews to main layout
        // why does Eclipse add 'misspelling' underlines in comments?
        // that's just annoying.
        
        
        

        // setting the content view
        setContentView(relativeLayout, rellaypar);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_sign_info, menu);
		return true;
	}
	
}
