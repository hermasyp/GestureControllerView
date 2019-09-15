package com.catnip.gesturecontrollerview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Written with love by Muhammad Hermas Yuda Pamungkas
 * Github : https://github.com/hermasyp
 **/
public class OnGestureListenerImpl extends GestureDetector.SimpleOnGestureListener {
    private static String TAG = OnGestureListenerImpl.class.getSimpleName();
    private Context context;
    private GestureControllerListener listener;
    private boolean isInLeft, isInRight;
    private int screenWidth, screenHeight;


    public OnGestureListenerImpl(Context context,GestureControllerListener listener) {
        this.listener = listener;
        this.context = context;
        getScreenSize(context);
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        if (event.getX() < (screenWidth / 2)) {
            //here check touch is screen left side
            isInLeft = true;
            isInRight = false;
            if(listener != null){
                listener.onDoubleTapOnLeft();
            }

        } else if (event.getX() > (screenWidth / 2)) {
            //here check touch is screen right side
            isInLeft = false;
            isInRight = true;
            if(listener != null){
                listener.onDoubleTapOnRight();
            }
        }

        return super.onDoubleTap(event);
    }

    private void getScreenSize(Context context) {
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
    }
}
