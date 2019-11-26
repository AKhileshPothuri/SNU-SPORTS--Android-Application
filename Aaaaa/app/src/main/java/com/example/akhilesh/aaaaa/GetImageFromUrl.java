package com.example.akhilesh.aaaaa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.InputStream;
import android.os.Bundle;
import android.widget.ImageView;

public class GetImageFromUrl {
    ImageView img;
    Bitmap bitmap;



    protected ImageView url_to_image(String url) {
        String urldisplay = url;
        bitmap = null;
        try {
            InputStream srt = new java.net.URL(urldisplay).openStream();
            bitmap = BitmapFactory.decodeStream(srt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        img.setImageBitmap(bitmap);
        return img;
    }
}
