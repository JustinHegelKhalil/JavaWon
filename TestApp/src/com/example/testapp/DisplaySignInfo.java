package com.example.testapp;

import com.JHKhalil.testapp.zodiacData.JSON;
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
		// super basic setup stuff.
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
        midPar.addRule(RelativeLayout.CENTER_HORIZONTAL);
        midPar.addRule(RelativeLayout.CENTER_VERTICAL);
        // Setting the parameters on the text
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
        // Adding the name to the centered layout
        centerLayout.addView(name);
        // add centered layout to main layout
        relativeLayout.addView(centerLayout);
        // adding supplemental textviews to main layout
        // why does Eclipse add 'misspelling' underlines in comments?
        // that's just annoying.
        relativeLayout.addView(element);
        relativeLayout.addView(symbol);
        
        

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
