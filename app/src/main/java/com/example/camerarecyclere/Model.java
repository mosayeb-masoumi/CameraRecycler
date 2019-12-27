package com.example.camerarecyclere;

import android.graphics.Bitmap;

public class Model {
    Bitmap bitmap;

    public Model(Bitmap bitmap) {
        this.bitmap = bitmap;
    }


    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
