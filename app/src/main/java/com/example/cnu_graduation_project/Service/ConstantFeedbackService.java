package com.example.cnu_graduation_project.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Vibrator;

import androidx.annotation.Nullable;

import com.example.cnu_graduation_project.DrivingRecognitionActivity;
import com.example.cnu_graduation_project.Lock.LockReceiver;

public class ConstantFeedbackService extends Service {
    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

    public void Vibration(){
        vibrator.vibrate(500);
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 스크린이 꺼짐을 감지하는 리시버 등록
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent, flags, startId);
        return START_REDELIVER_INTENT;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
