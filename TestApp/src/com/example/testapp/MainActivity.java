package com.example.testapp;


import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;




public class MainActivity extends Activity {
	public final static String USER_INPUT = "com.example.myfirstapp.INPUT";

	// quiz related variables not yet utilized - for future enhancement
	public int questionNumber;
	public boolean quizActive = false;
	
	LinearLayout linear;
	
	LinearLayout horizontal;
	// time index 20:10 411re 1ltps
	
	// random number generator test for eventual quiz
	public int randy(int max, int min){
		Random randy = new Random();
		int randomNum = randy.nextInt(max - 0);
		return randomNum;	
	}
	
	
	
	TextView text;
	EditText userText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     // setup layout details
    	linear = new LinearLayout(this);
    	linear.setOrientation(LinearLayout.VERTICAL);
    	
    	setContentView(linear);
    	
        // setContentView(R.layout.activity_main);
        
    }
    // number checker, for future birthdate entry interface
    public boolean isInteger(String str) {
    	  try {
    	    Integer.parseInt(str);
    	    
    	    TextView response = new TextView(this);
    	    response.setText("that's a number");
    	    linear.addView(response);
    	    return true;
    	  } catch(NumberFormatException e) {
    		  TextView response = new TextView(this);
      	    response.setText("that's not a number");
      	    linear.addView(response);
    	    return false;
    	  }
    	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	
    	// setup text for prompt
    	text = new TextView(this);
    	text.setText(R.string.promptText);
    	text.setTextSize(20);
    	
    	
    	// center prompt
    	text.setGravity(Gravity.CENTER);
    	
    	
    	
    	userText = new EditText(this);
    	
    	linear.addView(text);
    	
    	// make buttons for zodiac signs
    	
    	Button jan = new Button(this);
    	Button feb = new Button(this);
    	Button mar = new Button(this);
    	Button apr = new Button(this);
    	Button may = new Button(this);
    	Button jun = new Button(this);
    	Button jul = new Button(this);
    	Button aug = new Button(this);
    	Button sep = new Button(this);
    	Button oct = new Button(this);
    	Button nov = new Button(this);
    	Button dec = new Button(this);
    	
    	// to do: use JSON object to assign text to buttons.
    	// Objective-C would make that easier.
    	// to-research: Java alternative to pointers.
    	
    	// set up buttons.
    	jan.setText(R.string.Capricorn);
    	linear.addView(jan);
    	jan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Capricorn");
			}
		});
    	feb.setText(R.string.Aquarius);
    	linear.addView(feb);
    	feb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Aquarius");
			}
		});
    	mar.setText(R.string.Pisces);
    	linear.addView(mar);
    	mar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Pisces");
				
			}
		});
    	apr.setText(R.string.Aries);
    	linear.addView(apr);
    	apr.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Aries");
			}
		});
    	may.setText(R.string.Taurus);
    	linear.addView(may);
    	may.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Taurus");
			}
		});
    	jun.setText(R.string.Gemini);
    	linear.addView(jun);
    	jun.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Gemini");
			}
		});
    	jul.setText(R.string.Cancer);
    	linear.addView(jul);
    	jul.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Cancer");
			}
		});
    	aug.setText(R.string.Leo);
    	linear.addView(aug);
    	aug.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Leo");
			}
		});
    	sep.setText(R.string.Virgo);
    	linear.addView(sep);
    	sep.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Virgo");
			}
		});
    	oct.setText(R.string.Libra);
    	linear.addView(oct);
    	oct.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Libra");
			}
		});
    	nov.setText(R.string.Scorpio);
    	linear.addView(nov);
    	nov.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Scorpio");
			}
		});
    	dec.setText(R.string.Sagittarius);
    	linear.addView(dec);
    	dec.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadDataFor("Sagittarius");
			}
		});
    	
    	
    	
    	// set the view
    	setContentView(linear);
    	
    	
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    String title = "test application";
    
    // quiz stuff that is not yet implemented
    public void beginQuestionnaire(){
    	quizActive = true;
    	questionNumber = 1;
    	text.setText("Question " + questionNumber);
    	System.out.println(randy(10, 0));
    }
    public void nextQuestion() {
    	if (questionNumber < 10) {
    		questionNumber++;
    		text.setText("Question " + questionNumber);
    		System.out.println(randy(10, 0));
    	} else {
    		questionNumber = 1;
    		text.setText("quiz complete");
    		quizActive = false;
    		displayScore();
    		System.out.println(randy(10, 0));
    	}
    	
    }
    public void changeDisplay() {
    	
    }
    public void displayScore() {
    	
    }
    public void loadDataFor(String sign){
    	// nested layouts in DisplaySignInfo.java activity
    	Intent intent = new Intent(this, DisplaySignInfo.class);
    	intent.putExtra(USER_INPUT, sign);
    	startActivity(intent);

    }
}
