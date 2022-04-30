package com.example.cnu_graduation_project;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.ActivityTransitionResult;
import com.google.android.gms.location.DetectedActivity;

public class DrivingRecognition extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ActivityTransitionResult.hasResult(intent)) {
            ActivityTransitionResult result = ActivityTransitionResult.extractResult(intent);
            for (ActivityTransitionEvent event : result.getTransitionEvents()) {
                // chronological sequence of events....
                switch (event.getActivityType()){
                    case DetectedActivity
                            .IN_VEHICLE:
                        Log.d("test","탈것");
                        break;

                    case DetectedActivity
                            .STILL:
                        Log.d("test","still");
                        break;
                    case DetectedActivity
                            .WALKING:
                        Log.d("test","걷기");
                        break;
                }
            }
        }

    }
}
