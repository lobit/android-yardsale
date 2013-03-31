package com.yardsale.login;

import com.yardsale.map.R;
import com.yardsale.map.R.layout;
import com.yardsale.map.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.PushService;
import com.parse.ParseException;
import com.parse.SignUpCallback;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		 Parse.initialize(this, "dMxkpeLG7xmr7W2FAq9mbfEa9ZBaH53SNJHv1C90", "9bqgPsYLxBorhHqefMUL5MNPgKeQ9dXaMwJMhFBA"); 
		
		 login = (Button)findViewById(R.id.login);
		 username = (EditText) findViewById(R.id.username);
		 password = (EditText) findViewById(R.id.password);
		 register = (Button) findViewById(R.id.register);
		 title = (TextView) findViewById(R.id.title);
		 setFonts(title);
		 
		 login.setOnClickListener(new OnClickListener() {
		
			    public void onClick(View v) {
			        // TODO Auto-generated method stub
			     String name = username.getText().toString();
			     String pass = password.getText().toString();
			     loginForm = validateLogin(name,pass);
			  
			    System.out.println(pass);
			     
			    ParseUser.logInInBackground(name, pass, new LogInCallback() {
			    	  public void done(ParseUser user, ParseException e) {
			    	    if (user != null) {
			    	      // Hooray! The user is logged in.
							 Toast.makeText(Login.this,"Success Login" , Toast.LENGTH_SHORT).show();

			    	    } else {
			    	      // Signup failed. Look at the ParseException to see what happened.
							 Toast.makeText(Login.this,"Login Error." , Toast.LENGTH_SHORT).show();

			    	    }
			    	  }
			    	});
			     
			     
			     
			    }     
		  });		
	
	
	
		 register.setOnClickListener(new OnClickListener() {
				
			    public void onClick(View v) {

			    	Intent myIntent = new Intent(v.getContext(), Register.class);
	                startActivityForResult(myIntent, 0);
			    	    	
  		    }
		  });		
	
	}
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}
	
	
	
	public void setFonts(TextView font){
		/** 
		 * Set the Fonts for all the TextViews
		 */
    	Typeface face=Typeface.createFromAsset(getAssets(), "fonts/billabong.ttf"); 
    	font.setTypeface(face);
	}
	
	
	public boolean validateLogin(String username, String password){
		
		if(username.matches("") || password.matches("")){
			
			return false;
			
		}//end check
		
		return true;
	}
	
	/** Member Variables **/
	private Button login;
	private EditText username;
	private EditText password;
	private TextView title;
	private Button register;
	

	private boolean loginForm;
}
