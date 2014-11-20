package com.example.cj_app;

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
	private MarkerOptions markers;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_navigation_map);
		findView();
		setup();

	}

	private void setup() {
	    // カメラの基本的な設定をセット
	    final CameraPosition pos = new CameraPosition(START_POS,15, 0, 0);
	    // カメラにセット
	    camera = CameraUpdateFactory.newCameraPosition(pos);
	    // カメラの位置に移動
	    map.moveCamera(camera);
	    // マーカーの準備
	    markers = new MarkerOptions();
	    // マーカーの座標を決定
	    markers.position(START_POS);
	    // マーカーを追加
	    map.addMarker(markers);
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


}


