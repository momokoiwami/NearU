package com.example.new1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import jp.co.yahoo.android.maps.*;

   
public class MainActivity extends MapActivity {

    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

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
