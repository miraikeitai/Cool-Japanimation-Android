package com.example.cj_app;

import android.graphics.Bitmap;

public class AnimeData {
	private Bitmap imageData_;
    private String textData_;
 
    public void setImagaData(Bitmap image) {
        imageData_ = image;
    }
 
    public Bitmap getImageData() {
        return imageData_;
    }
}
