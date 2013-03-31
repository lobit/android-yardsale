package com.yardsale.login;

import com.yardsale.map.R;
import com.yardsale.map.R.layout;
import com.yardsale.map.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import com.parse.ParseObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		 username = (EditText) findViewById(R.id.username);
		 password = (EditText) findViewById(R.id.password);
		 register = (Button) findViewById(R.id.register);
		 title = (TextView) findViewById(R.id.title);
		 title = (TextView) findViewById(R.id.title);
		 setFonts(title);
		 
		
		 register.setOnClickListener(new OnClickListener() {
				
			    public void onClick(View v) {
			        // TODO Auto-generated method stub
			     String name = username.getText().toString();
			     String pass = password.getText().toString();
			     loginForm = validateLogin(name,pass);
			  
			  if(loginForm==true){
			     ParseObject testObject = new ParseObject("Users");
			   	 testObject.put("foo",name);
			   	 testObject.put("pw", pass);
				 testObject.saveInBackground();
			  }//end if
			  else
				 Toast.makeText(Register.this,"Cannot have blank fields." , Toast.LENGTH_SHORT).show();

  		    }
		  });	
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_register, menu);
		return true;
	}
	
public boolean validateLogin(String username, String password){
		
		if(username.matches("") || password.matches("")){
			
			return false;
			
		}//end check
		
		return true;
	}
	

public void setFonts(TextView font){
	/** 
	 * Set the Fonts for all the TextViews
	 */
	Typeface face=Typeface.createFromAsset(getAssets(), "fonts/billabong.ttf"); 
	font.setTypeface(face);
}
	/**Member Variables**/
	//Perhaps we should make an abstract Login Class and inherit ?
	private EditText username;
	private EditText password;
	private TextView title;
	private Button register;
	
	private boolean loginForm;
}