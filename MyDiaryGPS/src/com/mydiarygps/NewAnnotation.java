package com.mydiarygps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NewAnnotation extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	public static TextView lat;
	public static TextView lng;
	public static TextView alt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO Put your code here
		setContentView(R.layout.new_annotations);
		
		lat = (TextView)findViewById(R.id.new_annotation_lat);
		lng = (TextView)findViewById(R.id.new_annotation_long);
		alt = (TextView)findViewById(R.id.new_annotation_altitude);
		
		final Button btn_back = (Button)findViewById(R.id.new_annotation_back);
		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}
}
