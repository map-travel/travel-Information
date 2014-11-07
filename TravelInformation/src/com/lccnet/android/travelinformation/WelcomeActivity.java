package com.lccnet.android.travelinformation;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class WelcomeActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDarwTitle;
	private CharSequence mTitle;
	private Bundle saved;
	private ArrayAdapter<String> menu_adapter;
	private String [] menucontent;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		saved = savedInstanceState;
		InitView();
		menucontent = getResources().getStringArray(R.array.menu_content);
		menu_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menucontent);
		mDrawerList.setAdapter(menu_adapter);
		mDrawerList.setOnItemClickListener(menuLisClickListener);
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

		mDrawerToggle =new ActionBarDrawerToggle(this, mDrawerLayout, 
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
	 
	 public OnItemClickListener menuLisClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			Toast.makeText(WelcomeActivity.this, menucontent[position], 800).show();
			switch(position){
			//使用者名稱-暫時無功能，應可與設置合併
			case 0:
				
				
				
				
				break;
			//預定行程-有興趣的活動
			case 1:
				
				
				
				break;
			//設置-設定個人資訊	
			case 2:
				break;
			//主頁-所有活動消息
			case 3:
				break;
			//活動日-不確定功能似乎與主頁重疊
			case 4:
				break;
			//最新活動-不確定功能似乎與主頁重疊
			case 5:
				break;
			//關於我們
			case 6:
				break;
			}
		}

		
	};



}
