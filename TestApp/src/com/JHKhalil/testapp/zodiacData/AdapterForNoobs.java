package com.JHKhalil.testapp.zodiacData;

import android.content.Context;
// import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

// import android.widget.ImageView;
// import android.widget.TextView;
 
// import com.example.testapp.R;
 
public class AdapterForNoobs extends BaseAdapter {
	private Context context;
	private final String[] mobileValues;
 
	public AdapterForNoobs(Context context, String[] mobileValues) {
		this.context = context;
		this.mobileValues = mobileValues;
	}
 
	public View getView(int position, View convertView, ViewGroup parent) {

		// LayoutInflater inflater = (LayoutInflater) context
			// .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View addView = new View(context);
		 /*
		if (convertView == null) {
 
			addView = new View(context);
			addView = inflater.inflate(R.layout.linear_for_grid, null);
 
			// set value into textview
			TextView textView = (TextView) addView
					.findViewById(R.id.grid_item_label);
			textView.setText(mobileValues[position]);
 
			// set image based on selected text
			ImageView imageView = (ImageView) addView
					.findViewById(R.id.grid_item_image);
 
			String mobile = mobileValues[position];
 
			if (mobile.equals("Windows")) {
				imageView.setImageResource(R.drawable.windows_logo);
			} else if (mobile.equals("iOS")) {
				imageView.setImageResource(R.drawable.ios_logo);
			} else if (mobile.equals("Blackberry")) {
				imageView.setImageResource(R.drawable.blackberry_logo);
			} else {
				imageView.setImageResource(R.drawable.android_logo);
			}
 
		} else {
			gridView = (View) convertView;
		}
 */
		return addView;
		
	}
	
	@Override
	public int getCount() {
		return mobileValues.length;
	}
 
	@Override
	public Object getItem(int position) {
		return null;
	}
 
	@Override
	public long getItemId(int position) {
		return 0;
	}
 
}