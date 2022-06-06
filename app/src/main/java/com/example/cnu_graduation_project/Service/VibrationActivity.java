package com.example.cnu_graduation_project.Service;

import static com.example.cnu_graduation_project.TaskTag.ACTIVITY_TAG;
import static com.example.cnu_graduation_project.TaskTag.WINDOW_ON;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;

import com.example.cnu_graduation_project.DrivingRecognitionActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 진동 / 소리 구현부분
 */
public class VibrationActivity extends DrivingRecognitionActivity {

    String TAG="VibrationActivity";
    Vibrator vibrator;
    /**
     * 타이머 테스크로 진동을 준다.
     */
    public Timer timer = new Timer();
    public TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Log.d(TAG, WINDOW_ON+"");
            if(WINDOW_ON&&ACTIVITY_TAG) {
                vibrator.vibrate(new long[]{100,1000},1);
                Log.d(TAG, "vibration");
            }
            else if(!WINDOW_ON){
                Log.d(TAG, "stop timer");
                timer.cancel();
                timer.purge();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"Create");
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void start(){
        timer.schedule(task,0,1000);
    }

    public void stopVibration(){
        timer.cancel();
    }

}
