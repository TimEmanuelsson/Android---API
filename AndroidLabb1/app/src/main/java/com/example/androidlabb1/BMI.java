package com.example.androidlabb1;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends ActionBarActivity {
	
	private EditText weight;
	private EditText length;
	private TextView result;
	private double BMIResult;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bmi);
		
		weight = (EditText) findViewById(R.id.weight);
		length = (EditText) findViewById(R.id.length);
		result = (TextView) findViewById(R.id.result);
		result.setText("");
		
		
	}
	
	public void reset(View v) {
		result.setText("");
	}
	
	public void compute(View v) {
		
		 if(weight.getText().toString().trim().length() < 0 && length.getText().toString().trim().length() < 0) {
			 result.setText("Fälten få inte vara tomma!");
		 } else {
			 float BMIlength;
			 float BMIweight;
			 BMIlength = Float.parseFloat(length.getText().toString());
			 BMIweight = Float.parseFloat(weight.getText().toString()); 
			 
			 BMIResult = (BMIweight  / (BMIlength * BMIlength) *10000);
		     
			 result.setText(String.format( "BMI: %.2f", BMIResult )  + "");
		 }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bmi, menu);
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
