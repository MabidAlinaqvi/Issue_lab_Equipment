package com.example.android.ee_lab_project.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.android.ee_lab_project.R;
import com.example.android.ee_lab_project.Model.S_accountdataProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Student_account_new extends AppCompatActivity {
    ListView listview;
    Context context;
    String server_url="http://"+ logIn_main_page_activity.server_ip+"/s_account.php";
    s_account_adapter adapter;
    Map<String, String> parametersMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_account_new);
        listview=findViewById(R.id.list_view);
        adapter=new s_account_adapter(this,R.layout.s_accountrow_layout);
        try {
            sendReq();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        listview.setAdapter(adapter);

    }
    private void sendReq() throws JSONException {
        parametersMap.put("namess", Where_to_go_activity.getuser);
        CustomRequest jsonArrayRequest = new CustomRequest(Request.Method.POST,server_url,
                new JSONObject(parametersMap),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            //Log.d("response", String.valueOf(response));
                            for(int i=0;i<response.length();i++){
                                //Log.d("result", response.getString(i));
                                JSONObject jsonObject=response.getJSONObject(i);
                                //Log.d("result", jsonObject.getString("user"));
                                //Log.d("tok", jsonObject.getString("comp"));
                                S_accountdataProvider dataProvider=new S_accountdataProvider(jsonObject.getString("com_name"),jsonObject.getString("du_date"),jsonObject.getString("is_date"));
                                adapter.add(dataProvider);
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        Make_Request_Queue.getInstance(Student_account_new.this).addtorequestque(jsonArrayRequest);
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
}
