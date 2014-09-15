package com.example.new1;

import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import jp.co.yahoo.android.maps.*;

public class MainActivity extends MapActivity implements OnClickListener {
	
	private final String mAppId = "dj0zaiZpPUJCWkJyRzl3QUtvOCZzPWNvbnN1bWVyc2VjcmV0Jng9NDU-";

	private RatingBar mRatingBar;
	private Button mButton;

    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // 地図とレイアウトを表示
        showMapWithLayout();
        // showOnlyMap();

        // Viewを取得
        mRatingBar = (RatingBar) findViewById(R.id.ratingBar1);
        mButton = (Button) findViewById(R.id.button1);

        // クリックイベントを設定
        mButton.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
    	switch (v.getId()) {
		case R.id.button1:
			Toast.makeText(this, "ももこさん " + mRatingBar.getRating() + " スコアおめでとう", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
    }

    /**
     * 通常のレイアウトと共に地図を表示させる
     */
    private void showMapWithLayout() {
        setContentView(R.layout.activity_main);

        MapView mapView = new MapView(this, mAppId);
        MapController c = mapView.getMapController();
        c.setCenter(new GeoPoint(35665721, 139731006)); //初期表示の地図を指定
        c.setZoom(1);                                 //初期表示の縮尺を指定

        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        container.addView(mapView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
    
    /**
     * 地図だけを表示させる
     */
    private void showOnlyMap() {
        MapView mapView = new MapView(this,"dj0zaiZpPUJCWkJyRzl3QUtvOCZzPWNvbnN1bWVyc2VjcmV0Jng9NDU-");
        MapController c = mapView.getMapController();
        c.setCenter(new GeoPoint(35665721, 139731006)); //初期表示の地図を指定
        c.setZoom(1);                                 //初期表示の縮尺を指定
        setContentView(mapView);
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


	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
