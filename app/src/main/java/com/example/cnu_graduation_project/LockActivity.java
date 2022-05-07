package com.example.cnu_graduation_project;

import static com.example.cnu_graduation_project.DrivingRecognitionActivity.ACTIVITY_TAG;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

/**
 * 잠금화면 페이지
 */
public class LockActivity extends Activity {
    static String TAG ="LockActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"Start "+ TAG);
        /**
         * ACTIBITY_TAG ==> activity recognition 에서 인식을 하면 true 로 변경
         * 현재는 true로 고정
         *
         *
         */
        if(ACTIVITY_TAG){
            setContentView(R.layout.lock);
            /**
             * 잠금화면보다 높은 순위의 액티비티로 설정하고
             * 잠금화면을 지우는 태그
             */
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                    | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
