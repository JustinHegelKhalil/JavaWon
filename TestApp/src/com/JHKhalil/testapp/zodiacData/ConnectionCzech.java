package com.JHKhalil.testapp.zodiacData;
/*
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.net.NetworkInfo;
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.net.ConnectivityManager;


// import org.json.JSONTokener;


public class ConnectionCzech {
	
	public static final boolean CheckInternetConnection(Context context) {
		
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()) {
			
			return true;
		} else {
			return false;
		}
	}
	public static final boolean CheckConnect(Context context) {
		
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()) {
			
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkNetConnection(Context context) {
		
		String signName = "Aries";
		String finishedString = "";
		String url = "http://pipes.yahoo.com/pipes/pipe.run?_id=_omfgXdL3BGGadhGdrq02Q&_render=json&sign=" + signName;
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url); 
		httpGet.setHeader("Content-type", "application/json");
		HttpResponse response;
		try {
			response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("failure : error code : "
				   + response.getStatusLine().getStatusCode());
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream herein;
				herein = entity.getContent();
				String result = getStringFromStream(herein);
				int sp = result.indexOf("description");
				String begin = result.substring(sp + 15);
				sp = begin.indexOf("description");
				begin = begin.substring(sp + 17);
				int ep = begin.indexOf("n<");
				String fin = begin.substring(0, ep -1);
				System.out.println(fin);
				finishedString = fin;
					
				}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // catch (JSONException e) {
			
		if (finishedString.length() > 0){
			return true;
		} else return false;
		
    }
	
	private static String getStringFromStream(InputStream streamer){
		BufferedReader Breeder = new BufferedReader(new InputStreamReader(streamer));
		StringBuilder stringBuilderThing = new StringBuilder();
		String line = null;
		try {
			while ((line = Breeder.readLine()) != null) {
				stringBuilderThing.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				streamer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return stringBuilderThing.toString();
	}

	public static final String getHoroscope(Context context, String signName){
		String finishedString = "";
		String url = "http://pipes.yahoo.com/pipes/pipe.run?_id=_omfgXdL3BGGadhGdrq02Q&_render=json&sign=" + signName;
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url); 
		httpGet.setHeader("Content-type", "application/json");
		HttpResponse response;
		try {
			response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("failure : error code : "
				   + response.getStatusLine().getStatusCode());
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream herein;
				herein = entity.getContent();
				String result = getStringFromStream(herein);
				int sp = result.indexOf("description");
				String begin = result.substring(sp + 15);
				sp = begin.indexOf("description");
				begin = begin.substring(sp + 17);
				int ep = begin.indexOf("n<");
				String fin = begin.substring(0, ep -1);
				System.out.println(fin);
				finishedString = fin;
					
				}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // catch (JSONException e) {
			
					
		return finishedString;	 
		}
		
	
		
	
}