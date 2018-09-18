package com.example.android.ee_lab_project.Controller;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.android.ee_lab_project.R;
import com.example.android.ee_lab_project.Model.comp_listdataProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class t_list_component extends Fragment {
    ListView listview;
    Context context;
    String server_url="http://"+ logIn_main_page_activity.server_ip+"/comp_list.php";
    comp_list_adapter adapter;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_t_list_component,container,false);
        listview=view.findViewById(R.id.list_view);
        adapter=new comp_list_adapter(getActivity(),R.layout.comp_listrow_layout);
        init();
        try {
            sendReq();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        listview.setAdapter(adapter);
        return view;
    }
    private void init() {
        context = getActivity();

    }
    private void sendReq() throws JSONException {

        CustomRequest jsonArrayRequest = new CustomRequest(Request.Method.POST,server_url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            for(int i=0;i<response.length();i++){
                                JSONObject jsonObject=response.getJSONObject(i);
                                comp_listdataProvider dataProvider=new comp_listdataProvider(jsonObject.getString("com_name"),jsonObject.getString("com_type"),jsonObject.getString("com_stat"),jsonObject.getString("com_quant"));
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
        Make_Request_Queue.getInstance(getActivity()).addtorequestque(jsonArrayRequest);
    }
}
