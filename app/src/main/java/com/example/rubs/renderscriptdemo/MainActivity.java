package com.example.rubs.renderscriptdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView outputImage = (ImageView)findViewById(R.id.outputImage);
        Bitmap outputBitmap = Bluer.blur(this, BitmapFactory.decodeResource(getResources(),R.drawable.picture));
        outputImage.setImageBitmap(outputBitmap);
    }
}
