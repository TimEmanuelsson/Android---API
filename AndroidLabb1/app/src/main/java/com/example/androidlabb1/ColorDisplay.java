package com.example.androidlabb1;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ColorDisplay extends ActionBarActivity {
	
	private EditText red;
	private EditText green;
	private EditText blue;
	private LinearLayout BackgroundColor;
	private TextView wrongInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_display);
		
		red = (EditText) findViewById(R.id.red);
		green = (EditText) findViewById(R.id.green);
		blue = (EditText) findViewById(R.id.blue);
		BackgroundColor = (LinearLayout) findViewById(R.id.BackgroundColor);
		wrongInput = (TextView) findViewById(R.id.wrongInput);
		
	}
	
	public void displayColor(View v) {
		int redColor;
		int greenColor;
		int blueColor;
		
		try {
			redColor = Integer.parseInt(red.getText().toString());
			greenColor = Integer.parseInt(green.getText().toString());
			blueColor = Integer.parseInt(blue.getText().toString());
			
			if(redColor > 255 || redColor < 0 || greenColor > 255 || greenColor < 0 || blueColor > 255 || blueColor < 0) {
				wrongInput.setText("Fält måste vara mellan 0-255!");
			} else {
				wrongInput.setText("");
				String hex = String.format("#%02x%02x%02x", redColor, greenColor, blueColor);
				BackgroundColor.setBackgroundColor(Color.parseColor(hex));
			}
		}catch (Exception e){
			wrongInput.setText("Fält få inte vara tomma och mellan 0-255!");
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.color_display, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
