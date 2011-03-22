package com.androidpeople.xml.parsing;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class XMLParsingExample extends Activity {

	/** Create Object For SiteList Class */
	SitesList sitesList = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/** Create a new layout to display the view */
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(1);

		/** Create a new textview array to display the results */
		TextView name;
		TextView website;
		TextView category[];
		
		Button button=new Button(this);
		button.setText("See Video");

		try {
			
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			URL sourceUrl = new URL(
					"http://71.43.59.189:10026/AHJ/version1/getFlashScreen.php");

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			MyXMLHandler myXMLHandler = new MyXMLHandler();
			xr.setContentHandler(myXMLHandler);
			xr.parse(new InputSource(sourceUrl.openStream()));
			
			
		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);
		}

		
		
		/** Get result from MyXMLHandler SitlesList Object */
		sitesList = MyXMLHandler.sitesList;

		System.out.println("***PRJ IMAGE:"+sitesList.getImageUrl());
		System.out.println("***PRJ DESCRIPTION:"+sitesList.getDescription());
		System.out.println("***PRJ CATEGORY:"+sitesList.getCategory());
		
		/** Assign textview array lenght by arraylist size */
		name = new TextView(this);
		name.setText(sitesList.getImageUrl().toString());
		website = new TextView(this);
		website.setText(sitesList.getDescription().toString());
		category = new TextView[sitesList.getCategory().size()];
		
		layout.addView(name);
		layout.addView(website);

		/** Set the result text in textview and add it to layout */
		for (int i = 0; i < sitesList.getCategory().size(); i++) {
			
			category[i] = new TextView(this);
			category[i].setText("Website Category = "+sitesList.getCategory().get(i));

			layout.addView(category[i]);
		}

		
		button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				playVideo();
			}
		});
		/** Set the layout view to display */
		layout.addView(button);
		setContentView(layout);

	}
	void playVideo(){
		Toast.makeText(this, "BUTTON CLICK", Toast.LENGTH_LONG).show();
		try{
		Intent intent;  // Reusable Intent for each tab
	    // Create an Intent to launch an tabview
	    intent = new Intent().setClass(this, MediaPlayerDemo_Video.class);
	    startActivity(intent);
		}
		catch(Exception e){
			
			System.out.println("intent error :"+e.getMessage());
		}
	}
}