package com.JHKhalil.testapp.zodiacData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStreamReader;

import android.os.Environment;
import android.util.Log;



public class GoGet {
	
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
}