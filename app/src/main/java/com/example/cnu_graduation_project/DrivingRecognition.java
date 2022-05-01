package com.example.cnu_graduation_project;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.ActivityTransitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DrivingRecognition extends BroadcastReceiver{

    private static final String TAG = "RECEIVE";
    private void printToScreen(@NonNull String message) {
        Log.d(TAG, message);
    }
    private static String toActivityString(int activity) {
        switch (activity) {
            case DetectedActivity.STILL:
                return "STILL";
            case DetectedActivity.WALKING:
                return "WALKING";
            default:
                return "UNKNOWN";
        }
    }
    private static String toTransitionType(int transitionType) {
        switch (transitionType) {
            case ActivityTransition.ACTIVITY_TRANSITION_ENTER:
                return "ENTER";
            case ActivityTransition.ACTIVITY_TRANSITION_EXIT:
                return "EXIT";
            default:
                return "UNKNOWN";
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive(): " + intent);


        // TODO: Extract activity transition information from listener.
        if (ActivityTransitionResult.hasResult(intent)) {

            ActivityTransitionResult result = ActivityTransitionResult.extractResult(intent);

            for (ActivityTransitionEvent event : result.getTransitionEvents()) {

                String info = "Transition: " + toActivityString(event.getActivityType()) +
                        " (" + toTransitionType(event.getTransitionType()) + ")" + "   " +
                        new SimpleDateFormat("HH:mm:ss", Locale.US).format(new Date());
                Toast.makeText(context.getApplicationContext(), "뭔가 일어남",Toast.LENGTH_LONG).show();
                printToScreen(info);
            }
        }

    }
}
