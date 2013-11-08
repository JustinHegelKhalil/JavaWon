package com.example.testapp;

// import info.Information; // custom package
import java.util.Random;
// import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import android.widget.TextView;



public class MainActivity extends Activity {
	public final static String USER_INPUT = "com.example.myfirstapp.INPUT";

	public int questionNumber;
	public boolean quizActive = false;
	
	LinearLayout linear;
	LinearLayout horizontal;
	// time index 20:10 411re 1ltps
	
	
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
        
    	
        setContentView(R.layout.activity_main);
    }
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
    	// Object JSONObject jObject = new JSONObject();
    	
    	linear = new LinearLayout(this);
    	linear.setOrientation(LinearLayout.VERTICAL);
    	text = new TextView(this);
    	// text.setText("Please enter your birthday: mmddyyyy");
    	text.setText("Please select your zodiac sign:");
    	LinearLayout.LayoutParams promptParams = new LinearLayout.LayoutParams(
    			LinearLayout.LayoutParams.WRAP_CONTENT,
    			LinearLayout.LayoutParams.WRAP_CONTENT);
    	// promptParams.gravity.
    	
    	
    	Button enter = new Button(this);
    	enter.setText("enter");
    	
    	// test area
    	// Button testButton = new Button(this);
    	// String[] randomAspects = {"confident", "creative", "independent", "warm", "considerate", "decicive", "laid back", "high-minded", "emotional", "logical", "unpredictable", "reliable", "trustworthy", "unrestrained", "affectionate", "honest", "noble", "friendly", "professional", "consistent", "resolute", "witty", "childish", "fun", "intelligent", "wise"};
    	// testButton.setText(importedAspects[7]);
    	// linear.addView(testButton);
    	// test area over
    	userText = new EditText(this);
    	
    	linear.addView(text);
    	text.setLayoutParams(promptParams);
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
    	// linear.addView(userText);
    	// linear.addView(enter);
    	
    	
    	enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isInteger(userText.getText().toString());
				if (quizActive == false) {
					beginQuestionnaire();
				} else if (quizActive == true) {
					nextQuestion();
				}
				
				
			}
		});
    	setContentView(linear);
    	
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    String title = "test application";
    
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
    	Intent intent = new Intent(this, DisplaySignInfo.class);
    	intent.putExtra(USER_INPUT, sign);
    	startActivity(intent);

    }
}
