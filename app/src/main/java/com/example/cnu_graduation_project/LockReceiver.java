package com.example.cnu_graduation_project;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class LockReceiver extends BroadcastReceiver {
    String TAG="LockReceiver";
    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Log.d(TAG, "Screen Off");
            Intent i = new Intent(context, LockActivity.class);

            /**
             * 화면 종료 인식시 리시버 호출
             */
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            Log.d(TAG,"Start?");
        }
    }

}
