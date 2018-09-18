package com.example.android.ee_lab_project.Controller;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.android.ee_lab_project.R;
import com.example.android.ee_lab_project.Model.return_data_provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.android.ee_lab_project.Controller.logIn_main_page_activity.server_ip;


/**
 * Created by NO I.D on 11/9/2017.
 */

public class return_comp_adapter extends ArrayAdapter {
    ArrayList list=new ArrayList();
    private int pos;
    String user_name,comp;
    String server_url="http://"+server_ip+"/return_firebase.php";
    public return_comp_adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public static class DataHandler
    {
        TextView comp;
        TextView user;
        Button btn;
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row=convertView;
        DataHandler handler;
        pos=position;
        final return_data_provider dataProvider;
        dataProvider=(return_data_provider) this.getItem(position);
        if(row==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.return_row_layout,parent,false);
            handler=new DataHandler();
            handler.comp=row.findViewById(R.id.id);
            handler.user=row.findViewById(R.id.mess);
            handler.btn=row.findViewById(R.id.issu);
            row.setTag(handler);
            handler.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    user_name=dataProvider.getUser();
                    comp=dataProvider.getMessage();
                    Confirmation();

                }
            });

        }
        else{
            handler=(DataHandler)row.getTag();
        }
        handler.comp.setText(dataProvider.getMessage());
        handler.user.setText(dataProvider.getUser());
        return row;
    }

    private void Confirmation() {
        AlertDialog.Builder alerdialogue=new AlertDialog.Builder(getContext());
        alerdialogue
                .setTitle("Are you sure?")
                .setPositiveButton("Returned", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        NotifyStudent();

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setIcon(R.drawable.alert)
                .show();
    }


    private void NotifyStudent() {
            StringRequest rejoracpt = new StringRequest(Request.Method.POST, server_url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("selected", comp);
                    params.put("user",user_name);
                    return params;
                }
            };
            Make_Request_Queue.getInstance(getContext()).addtorequestque(rejoracpt);
        }
    }

