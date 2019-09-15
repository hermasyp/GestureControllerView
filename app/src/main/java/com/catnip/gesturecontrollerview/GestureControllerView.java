package com.catnip.gesturecontrollerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Written with love by Muhammad Hermas Yuda Pamungkas
 * Github : https://github.com/hermasyp
 **/
public class GestureControllerView extends View implements GestureControllerListener {
    private GestureControllerListener listener;
    private VolumeManager volumeManager;
    private GestureDetector gestureDetector;

    public GestureControllerView(Context context) {
        super(context);
        init(context);
    }

    public GestureControllerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GestureControllerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        volumeManager = new VolumeManager(context);
        gestureDetector = new GestureDetector(context,new OnGestureListenerImpl(context,this));
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }
    public void setGestureListener(GestureControllerListener listener){
        this.listener = listener;
    }

    @Override
    public void onDoubleTapOnRight() {
        if(listener != null){
            listener.onDoubleTapOnRight();
        }
    }

    @Override
    public void onDoubleTapOnLeft() {
        if(listener != null){
            listener.onDoubleTapOnLeft();
        }
    }
}
