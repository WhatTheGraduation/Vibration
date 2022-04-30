package com.example.cnu_graduation_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionClient;
import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 사용자에게 보여지는 첫 페이지 / 실행 관리 페이지
 *
 */

public class Client extends AppCompatActivity {

    //시작시 보여주는 text
    TextView drivingModeView;
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client);

        drivingModeView = findViewById(R.id.driving_mode);
        /**
         * API 받아오는 시작부분
         */
        if (activityRecognitionPermissionApproved(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q)) {
            drivingModeView.setText("API를 받아올 수 없습니다.");
        } else {
            drivingModeView.setText("운전 중이 아닙니다.");
        }
    }
    /**
     * @author 재용
     * api 사용 권환 획득을 위한 함수
     * api를 받아오지 못하면 permission 요청
     * @param runningQOrLater
     *
     * @return
     * 성공시 ture 실패시 false
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    private boolean activityRecognitionPermissionApproved(boolean runningQOrLater){
    // TODO: Review permission check for 29+.
        if (runningQOrLater) {

            return PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACTIVITY_RECOGNITION
            );
        } else {
            return true;
        }
    }

}