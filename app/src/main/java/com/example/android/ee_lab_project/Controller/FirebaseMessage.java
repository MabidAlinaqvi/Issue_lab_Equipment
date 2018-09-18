package com.example.android.ee_lab_project.Controller;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.android.ee_lab_project.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;

import static com.example.android.ee_lab_project.Controller.logIn_main_page_activity.server_ip;

/**
 * Created by root on 12/18/17.
 */

public class FirebaseMessage extends FirebaseMessagingService {
    //https://stackoverflow.com/questions/13902115/how-to-create-a-notification-with-notificationcompat-builder
    private String server_url="http://"+server_ip+"/requested.php";
    String TAG = "data received";
    Bundle bundle=new Bundle();
    String user_name="";
    String comp_name="";
    String reply="";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {



        if (remoteMessage.getData()!=null) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            user_name = remoteMessage.getData().get("sender");
            comp_name = remoteMessage.getData().get("message");
            reply=remoteMessage.getData().get("rejec");
            if(reply.equals("rejected") || reply.equals("returned"))
            {

                Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.drawable.noti)
                                .setContentTitle(reply)
                                .setContentText(comp_name)
                                .setAutoCancel(true)
                                .setSound(defaultSoundUri);
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, mBuilder.build());
            }
            else
                if (reply.equals("accepted"))
            {
                Intent resultIntent = new Intent(this, Student_account_new.class);
                PendingIntent resultPendingIntent =
                        PendingIntent.getActivity(
                                this,
                                0,
                                resultIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );
                Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.drawable.noti)
                                .setContentTitle(reply)
                                .setContentText(comp_name)
                                .setAutoCancel(true)
                                .setSound(defaultSoundUri)
                                .setContentIntent(resultPendingIntent);
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, mBuilder.build());

                sendRequest();

            }
            else
                {
                    Intent result = new Intent(this, issue_component_new.class);
                    PendingIntent resultPending =
                            PendingIntent.getActivity(
                                    this,
                                    0,
                                    result,
                                    PendingIntent.FLAG_UPDATE_CURRENT
                            );
                    Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    NotificationCompat.Builder mBuilder =
                            new NotificationCompat.Builder(this)
                                    .setSmallIcon(R.drawable.noti)
                                    .setContentTitle(user_name)
                                    .setContentText(comp_name)
                                    .setAutoCancel(true)
                                    .setSound(defaultSoundUri)
                                    .setContentIntent(resultPending);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(0, mBuilder.build());
                    if(reply.equals("issue")) {
                        sendRequest();
                    }
                }

        }





}

    private void sendRequest() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            public Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> params = new HashMap<String, String>();
                params.put("userid",user_name);
                params.put("msgis",comp_name);
                //params.put("statis",comp_status);
                return params;
            }

        };
        Make_Request_Queue.getInstance(getApplicationContext()).addtorequestque(stringRequest);
    }

}
