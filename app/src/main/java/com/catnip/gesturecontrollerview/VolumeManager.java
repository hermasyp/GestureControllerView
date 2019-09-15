package com.catnip.gesturecontrollerview;

import android.content.Context;
import android.media.AudioManager;

/**
 * Written with love by Muhammad Hermas Yuda Pamungkas
 * Github : https://github.com/hermasyp
 **/
public class VolumeManager {
    private Context appContext;
    private AudioManager manager;

    public VolumeManager(Context appContext) {
        this.appContext = appContext.getApplicationContext();
        this.manager = (AudioManager)appContext.getSystemService(Context.AUDIO_SERVICE);
    }

    public void raiseVolume(){
        manager.adjustStreamVolume(
                AudioManager.STREAM_MUSIC,
                AudioManager.ADJUST_RAISE,
                AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_SHOW_UI);
    }
    public void decreaseVolume(){
        manager.adjustStreamVolume(
                AudioManager.STREAM_MUSIC,
                AudioManager.ADJUST_LOWER,
                AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_SHOW_UI);
    }

}
