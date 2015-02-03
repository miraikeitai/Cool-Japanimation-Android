package com.example.cj_app;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimeSearchAdapter extends ArrayAdapter<AnimeData>{
	 private LayoutInflater layoutInflater_;
	 
	 public AnimeSearchAdapter(Context context, int textViewResourceId, List<AnimeData> objects) {
	 super(context, textViewResourceId, objects);
	 layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 }
	 
	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
	 // 特定の行(position)のデータを得る
	 AnimeData item = (AnimeData)getItem(position);
	 
	 // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
	 if (null == convertView) {
	 convertView = layoutInflater_.inflate(R.layout.custom_layout, null);
	 }
	 
	 // CustomDataのデータをViewの各Widgetにセットする
	 ImageView imageView;
	 imageView = (ImageView)convertView.findViewById(R.id.image);
	 imageView.setImageBitmap(item.getImageData());
	 	  
	 return convertView;
	 }
}
