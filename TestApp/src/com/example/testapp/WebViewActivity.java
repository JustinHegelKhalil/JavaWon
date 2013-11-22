package com.example.testapp;

import android.app.Activity;
import android.content.Intent;
// import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class WebViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		//setupActionBar();
		
    	WebView webview = (WebView) findViewById(R.id.webview);
    	
    	// simple intent, for loading webview data
    	Intent intent = getIntent();
    	String signString = intent.getStringExtra(MainActivity.PUBLIC_KEY);

    	
    	webview.loadUrl("http://www.astrology.com/horoscopes/" + signString + "/daily-horoscope/today");
		// Show the Up button in the action bar.
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	
	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
