package com.lccnet.android.travelinformation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class LoginActivity extends Activity {
	private final int TIME_OUT=2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
				LoginActivity.this.overridePendingTransition(R.anim.login_in, R.anim.login_out);
				LoginActivity.this.finish();
			}
		}, TIME_OUT);


	}
}
