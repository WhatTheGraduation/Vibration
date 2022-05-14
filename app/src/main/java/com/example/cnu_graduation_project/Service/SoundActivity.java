package com.example.cnu_graduation_project.Service;

import static com.example.cnu_graduation_project.TaskTag.ACTIVITY_TAG;
import static com.example.cnu_graduation_project.TaskTag.SOUND_TAG;
import static com.example.cnu_graduation_project.TaskTag.WINDOW_ON;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.cnu_graduation_project.DrivingRecognitionActivity;
import com.example.cnu_graduation_project.R;

import java.util.Timer;
import java.util.TimerTask;

public class SoundActivity extends DrivingRecognitionActivity {

    static String TAG = "SoundService";




    public void startSound(){
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), uri);
        AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ALARM).build();


        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(!SOUND_TAG&&WINDOW_ON&&ACTIVITY_TAG) {
                    SOUND_TAG=true;
                    ringtone.setAudioAttributes(audioAttributes);
                    ringtone.play();
                    Log.d(TAG, "vibration");
                }
                else if(!WINDOW_ON){
                    SOUND_TAG=false;
                    ringtone.stop();
                    Log.d(TAG, "stop timer");
                    timer.cancel();
                }
            }
        };

        timer.schedule(task,0,1000);
    }


}