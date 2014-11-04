package com.lccnet.android.travelinformation;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class WelcomeActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDarwTitle;
	private CharSequence mTitle;
	private Bundle saved;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		saved = savedInstanceState;
		InitView();
	}

	private void InitView(){
		mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
		mDrawerList=(ListView)findViewById(R.id.left_menu);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		GetActionBar();
	}

	private void GetActionBar(){
		ActionBar actionbar=getActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);
		actionbar.setHomeButtonEnabled(true);

		mDrawerToggle=new ActionBarDrawerToggle(this, mDrawerLayout, 
				R.drawable.ic_drawer,	R.string.draw_open, R.string.draw_close){

			@Override
			public void onDrawerClosed(View view){
				super.onDrawerClosed(view);
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView){
				super.onDrawerOpened(drawerView);
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        //home
	        if (mDrawerToggle.onOptionsItemSelected(item)) { //按下App圖案可跳出選單
	            return true;
	        }
			return super.onOptionsItemSelected(item);
	 }



}
