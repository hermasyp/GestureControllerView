package com.catnip.gesturecontrollerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements GestureControllerListener {
    private static String TAG = MainActivity.class.getSimpleName();
    private GestureControllerView gcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gcv = findViewById(R.id.gestureListener);
        gcv.setGestureListener(this);
    }

    @Override
    public void onDoubleTapOnRight() {
        Log.d(TAG, "onDoubleTap: In Right");
    }

    @Override
    public void onDoubleTapOnLeft() {
        Log.d(TAG, "onDoubleTap: In Left");
    }
}
