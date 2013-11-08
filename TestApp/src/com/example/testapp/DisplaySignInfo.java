package com.example.testapp;

import info.JSON;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplaySignInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_sign_info);
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.USER_INPUT);
		LinearLayout linear;
		linear = new LinearLayout(this);
		linear.setOrientation(LinearLayout.VERTICAL);
		TextView signTitle = new TextView(this);
		signTitle.setText(message);
		linear.addView(signTitle);
		setContentView(linear);
		String info = JSON.readJSON(message);
		signTitle.setText(info);
		LinearLayout leftSide;
		leftSide = new LinearLayout(this);
		linear.addView(leftSide);
		String elementString = JSON.readElement(message);
		String symbolString = JSON.readSymbol(message);
		// Layout code
		RelativeLayout relativeLayout = new RelativeLayout(this);

        // relativeLayout layout parameters.
        
        RelativeLayout.LayoutParams rellaypar = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        // new textview for element
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
        midPar.addRule(RelativeLayout.CENTER_HORIZONTAL);
        midPar.addRule(RelativeLayout.CENTER_VERTICAL);
        // Setting the parameters on the TextView
        name.setLayoutParams(nameLayout);
        element.setLayoutParams(midPar);
        element.setId(100);
        name.setId(20);
        midPar.addRule(RelativeLayout.BELOW, name.getId());
        Llaypar.addRule(RelativeLayout.BELOW, element.getId());
        symbol.setLayoutParams(Llaypar);

        RelativeLayout centerLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams centerLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        centerLayout.setLayoutParams(centerLayoutParams);
        // Adding the TextView to the RelativeLayout as a child
        centerLayout.addView(name);
        relativeLayout.addView(centerLayout);
        relativeLayout.addView(element);
        relativeLayout.addView(symbol);
        
        

        // Setting the RelativeLayout as our content view
        setContentView(relativeLayout, rellaypar);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_sign_info, menu);
		return true;
	}

}