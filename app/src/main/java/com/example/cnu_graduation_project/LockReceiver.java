package com.example.cnu_graduation_project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LockReceiver extends BroadcastReceiver {
    String TAG="LockReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Log.d(TAG, "Screen Off");
            Intent i = new Intent(context, LockActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            Log.d(TAG,"Start?");
        }
    }
}
