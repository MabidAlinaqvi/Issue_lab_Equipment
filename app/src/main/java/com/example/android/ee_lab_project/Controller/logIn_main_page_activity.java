package com.example.android.ee_lab_project.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.android.ee_lab_project.R;
import java.util.HashMap;
import java.util.Map;

public class logIn_main_page_activity extends AppCompatActivity{
    EditText user_name;
    EditText password;
    Button login_button;
    TextView reset_pass;
    TextView wrong_Input;
 //   CheckBox checkBox;
    private String get_user_name;
    private String get_password;
    Intent intent;
    Bundle bundle=new Bundle();
    String data;
    private String TAG="lab123_logIn";
    //public static String users;
  //  BackgroundTask backgroundTask;
    Context context=this;
    public static String server_ip="172.18.0.41";
    String server_url1="http://"+server_ip+"/reading_sdata.php";
    String server_url2="http://"+server_ip+"/reading_tdata.php";
   // logged_in_user_data logged_in_user_data=new logged_in_user_data();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main_page_activity);
        Log.i(TAG, "onCreate: ");
        user_name=findViewById(R.id.user_name);
        password=findViewById(R.id.pass);
        login_button=findViewById(R.id.logIn_button);
  //      checkBox=findViewById(R.id.check);
       // reset_pass=findViewById(R.id.reset_pass);
        wrong_Input=findViewById(R.id.wrong_input);
        intent=new Intent(this,Where_to_go_activity.class);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_user_name=user_name.getText().toString();
                get_password=password.getText().toString();
                String selected_server;
                if(get_user_name.contains("@"))
                {
                    selected_server=server_url2;
                }
                else{
                    selected_server=server_url1;
                }
                StringRequest stringRequest=new StringRequest(Request.Method.POST, selected_server,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("null"))
                                {
                                    wrong_Input.setVisibility(View.VISIBLE);
                                }
                                else {
                                   /* if(checkBox.isChecked()==true)
                                    {

                                        //Toast.makeText(logIn_main_page_activity.this,"checked",Toast.LENGTH_SHORT);
                                        //user_name.setText(get_user_name);
                                        //password.setText(get_password);
                                    }*/

                                    bundle.putString("info",response);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                                   // Toast.makeText(logIn_main_page_activity.this, "successfully logged in", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(logIn_main_page_activity.this,"Error",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<String,String>();
                        params.put("user_name",get_user_name);
                        params.put("user_pass",get_password);
                        return params;
                    }
                };
                Make_Request_Queue.getInstance(logIn_main_page_activity.this).addtorequestque(stringRequest);
            }
        });


    }
}
