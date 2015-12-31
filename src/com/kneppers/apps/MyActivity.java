package com.kneppers.apps;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// this is MyActivity
public class MyActivity extends Activity {
	
	EditText name; 
	EditText surname; 
	TextView fullname;
	
	Button Cookie, Jar, Return; 
	TextView Underwear; 
	String delta = "Hello Marsians";
	
	@Override //This is the first method that activates
	protected void onCreate(Bundle CallThisWhatYouWant) {
		super.onCreate(CallThisWhatYouWant);
		setContentView(R.layout.activity_my);

		name = (EditText) findViewById(R.id.editText1); 
		surname = (EditText) findViewById(R.id.editText2);
		fullname = (TextView) findViewById(R.id.textView3);
	}

	// saving the login information via your savedInfo method. You created this method yourself.
	public void saveInfo(View view) {
		SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString("username", name.getText().toString());
		editor.putString("password", surname.getText().toString());
		editor.apply();

		Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
		
		//Toast toast = Toast.makeText(this, "Saved!", Toast.LENGTH_LONG);
		//TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
		//v.setTextColor(Color.RED);
		//toast.getView().setBackgroundColor(Color.BLUE);
		//toast.show();
		
	}

	// Print out the saved data
	public void displayData(View view) {
		SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
		String name = sharedPref.getString("username", "");
		String pw = sharedPref.getString("password", "");
		fullname.setText(name + " " + pw);
	
//the variable underwear here, points to the textView YOU CAN CHOSE ANY TEXTVIEW and it will change color	
Underwear = (TextView) findViewById(R.id.textView1);
Underwear.setTextColor(Color.BLUE);

Underwear = (TextView) findViewById(R.id.editText2);
Underwear.setTextColor(Color.YELLOW);

//creating the cookie button
Cookie = (Button) findViewById(R.id.button3);
Cookie.setOnClickListener(new Button.OnClickListener() {
	public void onClick(View v) {

		Underwear = (TextView) findViewById(R.id.textView4);
		Underwear.setText("I like chocolate cookies.");
		Underwear.setTextColor(Color.RED);
	}
}

);
//creating the Jar button
Jar = (Button) findViewById(R.id.button4);
Jar.setOnClickListener(new Button.OnClickListener() {
	public void onClick(View v) {

		Underwear = (TextView) findViewById(R.id.textView4);
		Underwear.setText("I like crunchy ones.");
		Underwear.setTextColor(Color.GREEN);
	}
}

);
//creating the return button
Return = (Button) findViewById(R.id.button5);
Return.setOnClickListener(new Button.OnClickListener() {
	
	public void onClick(View v) {

		Underwear = (TextView) findViewById(R.id.textView4);
		Underwear.setText(delta);
		Underwear.setTextColor(Color.BLUE);
	}
}

		);// check out this!! setOnLongClicklistener.Play with true and false.
		Cookie.setOnLongClickListener(new OnLongClickListener() {
			public boolean onLongClick(View v) {
				TextView DaddyCool = (TextView) findViewById(R.id.textView4);
				DaddyCool.setText("Eat your heart out Hoss!!");
				return false;
			}
		});
	}
}
