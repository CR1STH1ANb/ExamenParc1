package com.example.examenparc1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.examenparc1.Model.Imagen;
import com.mindorks.placeholderview.PlaceHolderView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlaceHolderView mGalleryView = (PlaceHolderView)findViewById(R.id.galleryView);
        mGalleryView
                .addView(new Imagen(this.getApplicationContext(), mGalleryView, "https://restcountries.eu/rest/v2/alpha/ecu"));

    }
}