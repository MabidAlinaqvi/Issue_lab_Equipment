package com.example.android.ee_lab_project.Controller;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.android.ee_lab_project.R;
import com.example.android.ee_lab_project.Model.issue_data_provider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.android.ee_lab_project.Controller.logIn_main_page_activity.server_ip;

public class issue_component_new extends AppCompatActivity {
    private ListView list;
    private String server_url="http://"+server_ip+"/requestComp.php";
    issue_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_component_new);
        list=findViewById(R.id.list);
        adapter=new issue_adapter(this,R.layout.issue_comp_row);
        receiveData();
        list.setAdapter(adapter);
    }
    private void receiveData() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST,server_url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            // Log.d("response", response + "");
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                issue_data_provider dataProvider = new issue_data_provider(jsonObject.getString("user"), jsonObject.getString("component"), jsonObject.getString("status"));
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
        Make_Request_Queue.getInstance(issue_component_new.this).addtorequestque(jsonArrayRequest);
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
