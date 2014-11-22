package com.example.cj_app;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class NavigationMap extends FragmentActivity{
	// 初期座標(スカイツリー)
	private static final LatLng START_POS = new LatLng(35.681382, 139.766084);
	// 地図
	private GoogleMap map;
	// カメラ
	private CameraUpdate camera;
	// マーカーを設置する設定
	private MarkerOptions markers1;
	private MarkerOptions markers2;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_navigation_map);
		findView();
		setup();
		// 送られてきたIntentから起動パラメータを取り出す
	    // 送られたIntentを取得
	    Intent intent = getIntent();
	    // IntentからBundleを取り出す
	    Bundle bundle = intent.getExtras();
	    if (bundle != null) {
	      // Bundleからデータを取り出す
	      String place = bundle.getString("place");
	      onGetLocation(place);
	    }

	}

	private void setup() {
	    // カメラの基本的な設定をセット
	    final CameraPosition pos = new CameraPosition(START_POS,15, 0, 0);
	    // カメラにセット
	    camera = CameraUpdateFactory.newCameraPosition(pos);
	    // カメラの位置に移動
	    map.moveCamera(camera);
	    // マーカーの準備
	    markers1 = new MarkerOptions();
	    // マーカーの座標を決定
	    markers1.position(START_POS);
	    // マーカーを追加
	    map.addMarker(markers1);
	}

	private void findView() {
	    // FragmentManagerのロード
	    final FragmentManager manager = getSupportFragmentManager();
	    // MapFragmentのロード
	    final SupportMapFragment frag = (SupportMapFragment) manager
	            .findFragmentById(R.id.map);
	    // Map内容のロード
	    map = frag.getMap();
	}

	private void onGetLocation(String place){
		Geocoder gcoder = new Geocoder(this, Locale.getDefault());
		List<Address> lstAddr;
		try {
			// 位置情報の取得
			lstAddr = gcoder.getFromLocationName(place, 1);
			if (lstAddr != null && lstAddr.size() > 0) {
				// 緯度/経度取得
				Address addr = lstAddr.get(0);
				int latitude = (int)(addr.getLatitude() * 1E6);
				int longitude = (int)(addr.getLongitude() * 1E6);
				LatLng PLACE_POS = new LatLng(latitude, longitude);
				markers2 = new MarkerOptions();
			    // マーカーの座標を決定
			    markers2.position(PLACE_POS);
			    // マーカーを追加
			    map.addMarker(markers2);
			}
		}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}


}


