package com.JHKhalil.testapp.zodiacData;
//Justin Hegel Khalil- testApp- FullSail- Java-1
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.testapp.MainActivity;

public class GoGet {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

}
	
	public static String readFromFile() {

	    String ret = "";

	    try {
	    	String externalStoragePath = Environment.getExternalStorageDirectory().toString();
			File file = new File(externalStoragePath + "/userSign.txt");
	    	// FileInputStream fis = new FileInputStream("userSign.txt");
	        FileInputStream fis = new FileInputStream(file);

	        if ( fis != null ) {
	            InputStreamReader inputStreamReader = new InputStreamReader(fis);
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	            String receiveString = "";
	            StringBuilder stringBuilder = new StringBuilder();

	            while ( (receiveString = bufferedReader.readLine()) != null ) {
	                stringBuilder.append(receiveString);
	            }

	            fis.close();
	            ret = stringBuilder.toString();
	        }
	    }
	    catch (FileNotFoundException e) {
	        Log.e("login activity", "File not found: " + e.toString());
	    } catch (IOException e) {
	        Log.e("login activity", "Can not read file: " + e.toString());
	    }

	    return ret;
	}
	public static void writeFile(String textOfFile){
	String externalStoragePath = Environment.getExternalStorageDirectory().toString();
	File root = new File(Environment.getExternalStorageDirectory(), "savers");
	if (!root.exists()) {
        root.mkdirs();
    }
	File theFile = new File(externalStoragePath, "/networked.txt");
	FileOutputStream outputStream;
	try {
	    outputStream = new FileOutputStream(theFile);
	   	String data = textOfFile;
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
	public static String readFromStatusFile() {

	    String ret = "";

	    try {
	    	String externalStoragePath = Environment.getExternalStorageDirectory().toString();
			File file = new File(externalStoragePath + "/networked.txt");
	        FileInputStream fis = new FileInputStream(file);

	        if ( fis != null ) {
	            InputStreamReader inputStreamReader = new InputStreamReader(fis);
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	            String receiveString = "";
	            StringBuilder stringBuilder = new StringBuilder();

	            while ( (receiveString = bufferedReader.readLine()) != null ) {
	                stringBuilder.append(receiveString);
	            }

	            fis.close();
	            ret = stringBuilder.toString();
	        }
	    }
	    catch (FileNotFoundException e) {
	        Log.e("login activity", "File not found: " + e.toString());
	    } catch (IOException e) {
	        Log.e("login activity", "Can not read file: " + e.toString());
	    }

	    return ret;
	}
	public static String writeStringToFile(String stringToWrite, String fileName, boolean append) {
		String response = "";
		File root = new File(Environment.getExternalStorageDirectory(), "savers");
		if (!root.exists()) {
	        root.mkdirs();
	    }
		String fileNameAndPath = fileName + ".txt";
		File theFile = new File(root, fileNameAndPath);
		FileOutputStream outputStream;
	    try {
	    	outputStream = new FileOutputStream(theFile);
	    	String data = stringToWrite;
	    	if (append == true){
				
				String verify = readStringFromFile(fileName, null);
				data = verify + data;
				// System.out.println("data:" + data);
				// System.out.println("verify:" + verify);
			}
			outputStream.write(data.toString().getBytes());
			outputStream.close();
		} catch (IOException e) {
			try {
				theFile.createNewFile();
				outputStream = new FileOutputStream(theFile);
				String data = stringToWrite;
				outputStream.write(data.toString().getBytes());
				outputStream.close();
				response = "may have been a problem";
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				response = "may have been a problem";
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	    // String verify = readStringFromFile(fileName, null);
		// System.out.println(verify);
	    response = "Looking good";
		return response;
	}
	public static String readStringFromFile(String fileName, String keyWord){
		String returner = "";
		File root = new File(Environment.getExternalStorageDirectory(), "savers");
		if (!root.exists()) {
	        root.mkdirs();
	    }
		String targetFileName = fileName + ".txt";
		File theFile = new File(root, targetFileName);
		StringBuilder stringBuilder;
		try {
			FileInputStream fis = new FileInputStream(theFile);
			InputStreamReader inputStreamReader = new InputStreamReader(fis);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String receiveString = "";
			stringBuilder = new StringBuilder();
			while ( (receiveString = bufferedReader.readLine()) != null ) {
			    stringBuilder.append(receiveString);
			}
			fis.close();
			returner = stringBuilder.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returner;
	}
	public String horoscope(Context context, String signName) {
		String returnString = "";
		Thread one = new Thread();
		one.start();
		while (one.isAlive()) {
            threadMessage("test in progress...");
            try {
				one.join(2000);
				if (returnString.length() < 1) {
					String url = "http://pipes.yahoo.com/pipes/pipe.run?_id=_omfgXdL3BGGadhGdrq02Q&_render=json&sign=" + signName + "&url=http%3A%2F%2Ffeeds.astrology.com%2Fdailyoverview";
					HttpClient httpClient = new DefaultHttpClient();
					// sending data to destination for horoscope response.
					HttpGet httpGet = new HttpGet(url); 
					httpGet.setHeader("Content-type", "application/json");
					HttpResponse response;
					response = httpClient.execute(httpGet);
					if (response.getStatusLine().getStatusCode() == 200) {
						HttpEntity entity = response.getEntity();
						if (entity != null) {
							InputStream herein;
							herein = entity.getContent();
							String result = getStringFromStream(herein);
							// System.out.println(result);
							String finito = "";
							
							// int iterator = 0;
							try {
								// iterator++;
								
								
								// System.out.println(result);
								JSONObject json = new JSONObject(result);
								JSONObject jso = json.getJSONObject("value");
								JSONArray countOne = jso.getJSONArray("items");
								JSONObject itemOne = countOne.getJSONObject(0);
								String hosop = itemOne.getString("description");
								finito = hosop;
								String openP = "<p>";
								String closeP = "</p>";
								int skipHTS = finito.indexOf(openP);
								int cutAt = finito.indexOf(closeP);
								skipHTS = skipHTS + openP.length();
								finito = finito.substring(skipHTS, cutAt);
								// String js = jso.getString("title");
								// System.out.println(result);
								// System.out.println(hosop);
								 
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							/*
							// System.out.println(finito);
							// find where it starts.
							String finito = "";
							String openP = "<p>";
							String closeP = "</p>";
							int skipHTS = finito.indexOf(openP);
							int cutAt = finito.indexOf(closeP);
							skipHTS = skipHTS + openP.length();
							finito = finito.substring(skipHTS, cutAt);
							int sp = result.indexOf("description");
							// correct for length of marker
							String begin = result.substring(sp + 15);
							// System.out.println(result.substring(0, sp));
							sp = begin.indexOf("description");
							begin = begin.substring(sp + 17);
							// do it again with the substring
							int ep = begin.indexOf("p>");
							*/
							// String fin;
							// System.out.println(result);
							// fin = begin.substring(0, ep);
							
							
						
							
							// make finished string.
							// System.out.println(fin);
							// returnString = begin;
							// returnString = fin;
							returnString = finito;
						}
					}
					
				}
			} catch (ClientProtocolException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			} 
		
		
		
	
		try {
			one.join();
			if (returnString.length() < 2){
				MainActivity.getError(signName);
			}
			return returnString;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		MainActivity.setHoroscopeText(returnString);
		return returnString;
		
	}
	private static String getStringFromStream(InputStream streamer){
		BufferedReader Breeder = new BufferedReader(new InputStreamReader(streamer));
		StringBuilder stringBuilderThing = new StringBuilder();
		String line = null;
		try {
			// grabbing data from source, placing it into a string.
			while ((line = Breeder.readLine()) != null) {
				// here: appending to full string.
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
	static void threadMessage(String message) {
        String threadName =
            Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                          threadName,
                          message);
    }
}