package com.footprint.avlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.footprint.avlab.teclab.jni.Mp3Endocder;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("audioencoder");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mp3Endocder endocder = new Mp3Endocder();
        endocder.encode();
    }
}
