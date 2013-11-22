package com.JHKhalil.testapp.zodiacData;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

import com.example.testapp.MainActivity;
// import android.widget.Toast;

public class signSelectedSpinner implements OnItemSelectedListener {
	
	Context parentContext;
	String sign;
	String horoscopeText;
	String savedSign;
	int newPosition;
	
	public void setSomeData(String theName, Spinner parent){
		for(int i=0; i < parent.getCount(); i++) {
			  if(savedSign.equals(parent.getItemAtPosition(i).toString())){
			    parent.setSelection(i);
			    break;
			  }
			}
	}
	public void getContextFromMain(Context context){
		parentContext = context;
	}
	public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
		
		
		MainActivity ma = new MainActivity();
		parentContext = ma.relayContext();
		int currentItem = parent.getSelectedItemPosition();
		if (currentItem != pos){
			
		}
		currentItem = pos;
		sign = parent.getItemAtPosition(pos).toString();
		if (sign != null){
	    	ma.setText(horoscopeText, null, null);
	    	ma.setLoadedSign(sign);
			
		}
		
    	} 
	@Override
	  public void onNothingSelected(AdapterView<?> arg0) {
		
	  }

}
