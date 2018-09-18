package com.example.android.ee_lab_project.Controller;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


/**
 * Created by root on 12/18/17.
 */

public class FirebaseServer extends FirebaseInstanceIdService {
    public static String refreshedToken;

    @Override
    public void onTokenRefresh() {
       refreshedToken = FirebaseInstanceId.getInstance().getToken();
       // Log.d("user", getuser);
        Log.d("token receieved", refreshedToken);

    }
}
