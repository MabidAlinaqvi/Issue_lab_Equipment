package com.example.android.ee_lab_project.Controller;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.android.ee_lab_project.R;

import java.util.HashMap;
import java.util.Map;

import static com.example.android.ee_lab_project.Controller.logIn_main_page_activity.server_ip;

public class Where_to_go_activity extends AppCompatActivity{
    private String server_url="http://"+server_ip+"/register.php";
    Student_logged_In S_loggedIn=new Student_logged_In();
    Teacher_loggedIn T_loggedIn=new Teacher_loggedIn();
    FragmentTransaction transaction;
    FragmentManager manager=getFragmentManager();
    private String TAG="lab123_main";
    public static String getuser;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      Log.i(TAG, "onCreate: ");
        setContentView(R.layout.where_to_go_activity);
        bundle=getIntent().getExtras();
        getuser=bundle.getString("info");
        if(getuser.contains("@")) {

            transaction=manager.beginTransaction();
            transaction.replace(R.id.frame,T_loggedIn);
            transaction.commit();
        }

        else
        {
            transaction = manager.beginTransaction();
            transaction.replace(R.id.frame, S_loggedIn);
            transaction.commit();
           // System.out.print("naqvi");

        }
        if(FirebaseServer.refreshedToken!=null) {
            createToken();
        }

    }

    private void createToken() {
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
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();
                params.put("use",getuser);
                params.put("tok", FirebaseServer.refreshedToken);
                return params;
            }
        };
        Make_Request_Queue.getInstance(this).addtorequestque(stringRequest);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);  //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //switch (item.getItemId()) {
        //    case R.id.logout:
        if(item.getItemId()==R.id.logout) {
            Intent intent = new Intent(this, logIn_main_page_activity.class);
            this.startActivity(intent);
            Toast.makeText(this, "Successfully logOut..", Toast.LENGTH_LONG).show();
            return true;
        }else{
                //return super.onOptionsItemSelected(item);
            return false;
        }
    }

 /*   @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }
        @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }*/



}
