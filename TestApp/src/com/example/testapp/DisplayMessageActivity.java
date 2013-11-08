package com.example.testapp;
import android.app.Activity;
// import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Intent intent = getIntent();
		// String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    // boolean stringExists = false;
	    
	    
	    
	}

	
	public String concatThis(String inputString) {
		String responseString = (" you input: " + inputString);
		return responseString;
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
