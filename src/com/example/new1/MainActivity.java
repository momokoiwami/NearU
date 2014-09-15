package com.example.new1;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.support.v7.app.ActionBarActivity;
import android.graphics.drawable.Drawable;
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
	private MyLocationOverlay _overlay;
	
	
	
	
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

        final MapView mapView = new MapView(this, mAppId);
        MapController c = mapView.getMapController();
        c.setCenter(new GeoPoint(35665721, 139731006)); //初期表示の地図を指定
        c.setZoom(1);                                 //初期表示の縮尺を指定

       MyLocationOverlay mylocationoverlay = new MyLocationOverlay(this, mapView);
       GeoPoint mylocation = mylocationoverlay.getMyLocation();
       mylocation.getLatitudeE6();
//       double lat = mylocation.getLatitude();
//       double lon = mylocation.getLongitude();
//       Log.v("lat", lat + "");
//       Log.v("lon", lon + "");
//       
        GeoPoint mid = new GeoPoint(35718758, 139732175);
        PinOverlay pinOverlay = new PinOverlay(PinOverlay.PIN_VIOLET);
        mapView.getOverlays().add(pinOverlay);
        pinOverlay.addPoint(mid,null);
        
        //MyLocationOverlayインスタンス作成
        _overlay = new MyLocationOverlay(getApplicationContext(), mapView);
     
        //現在位置取得開始
        _overlay.enableMyLocation();
     
        //位置が更新されると、地図の位置も変わるよう設定
        _overlay.runOnFirstFix(new Runnable(){
            public void run() {
                if (mapView.getMapController() != null) {
                    //現在位置を取得
                    GeoPoint p = _overlay.getMyLocation();
                    //地図移動
                    mapView.getMapController().animateTo(p);
                }
            }
     
        });
     
        //MapViewにMyLocationOverlayを追加。
        mapView.getOverlays().add(_overlay);
        
        //Mapの色・デザインを変更。
        List<String> style=new ArrayList<String>();
        mapView.setMapType(mapView.MapTypeStyle,"base:midnight",style);
        
        
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
