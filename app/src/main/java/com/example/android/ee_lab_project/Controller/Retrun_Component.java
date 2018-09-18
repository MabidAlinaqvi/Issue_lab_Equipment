package com.example.android.ee_lab_project.Controller;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.android.ee_lab_project.R;
import com.example.android.ee_lab_project.Model.return_data_provider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.android.ee_lab_project.Controller.logIn_main_page_activity.server_ip;


/**
 * A simple {@link Fragment} subclass.
 */
public class Retrun_Component extends Fragment {
View view;
ListView listView;
return_comp_adapter adapter;
return_data_provider data_provider;
private String server_url="http://"+server_ip+"/return_comp.php";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_retrun__component,container,false);
        listView=view.findViewById(R.id.list);
        adapter=new return_comp_adapter(getActivity(),R.layout.return_row_layout);
        retrieveData();
        listView.setAdapter(adapter);
        return view;
    }

    public void retrieveData() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST,server_url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            Log.d("response", response + "");
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                data_provider = new return_data_provider(jsonObject.getString("user"), jsonObject.getString("component"));
                                adapter.add(data_provider);

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
        Make_Request_Queue.getInstance(getActivity()).addtorequestque(jsonArrayRequest);
    }

}
