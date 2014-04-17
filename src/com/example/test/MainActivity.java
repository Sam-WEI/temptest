package com.example.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.animation.AnimatorSet.Builder;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			return rootView;
		}
		
		@Override
		public void onResume() {
			super.onResume();
			TextView tv = (TextView) getView().findViewById(R.id.textview) ;
			
			String summary = "原天津本地<em>奥迪</em>车友会“天津奥运会”正式归入AUDIS-CLUBCHINA，并命名S-CLUB天津分会...符合以下准入资格的车主可以申请加入<em>奥迪</em>S-CLUB天津分会：华人以及留华外籍人士，年龄...";
			Pattern pattern = Pattern.compile("<em>(.*?)</em>");
			Matcher matcher = pattern.matcher(summary);
			
			ColorStateList mColorStateList = ColorStateList.valueOf(Color.parseColor("#cc0000"));
			SpannableStringBuilder builder = new SpannableStringBuilder(summary);;
			while(matcher.find()){
				TextAppearanceSpan tas = new TextAppearanceSpan(null, 0, 0, mColorStateList, null);
				builder.setSpan(tas, matcher.start(), matcher.end(), 0);
			}
			
			Pattern pattern1 = Pattern.compile("<em>(.*?)</em>");
			Matcher matcher1 = pattern.matcher(builder);
			while(matcher1.find()){
				matcher1.replaceAll("");
			}
			
			tv.setText(builder);
		}
	}

}
