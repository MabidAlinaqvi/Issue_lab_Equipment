package com.example.android.ee_lab_project.Controller;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.android.ee_lab_project.R;
import com.example.android.ee_lab_project.Model.issue_data_provider;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.example.android.ee_lab_project.Controller.logIn_main_page_activity.server_ip;

public class issue_adapter extends ArrayAdapter{
public ArrayList list=new ArrayList();
String duedate;
    String stat;
    String user_data;
    String msg_data;
    String server_url="http://"+server_ip+"/issueComp.php";
    String server_url2="http://"+server_ip+"/firebase.php";
    String server_url3="http://"+server_ip+"/reject.php";
    private int pos;
//https://stackoverflow.com/questions/10977422/how-to-create-simple-calendar-on-android
Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            update();
        }

    };


    private void update() {
        String myFormat = "yy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.UK);
        duedate=sdf.format(myCalendar.getTime());
        issueComponent();
        rejectedOrAccept(user_data,msg_data,"accepted");

    }



    //calender
    public issue_adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public static class DataHandler
    {
        TextView user;
        TextView msg;
        Button btn;
        TextView stat;
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
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        pos=position;
        View row;
        row=convertView;
        DataHandler handler;
        final issue_data_provider dataProvider;
        dataProvider=(issue_data_provider) this.getItem(position);
        //final Action item=this.getItem(position);
        if(row==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.issue_comp_row,parent,false);
            handler=new DataHandler();
            handler.user=row.findViewById(R.id.id);
            handler.msg=row.findViewById(R.id.mess);
            handler.stat=row.findViewById(R.id.state);
            handler.btn=row.findViewById(R.id.issu);
            row.setTag(handler);
           handler.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stat=dataProvider.getStatus();
                    user_data=dataProvider.getUser();
                    msg_data=dataProvider.getMessage();
                    if(Where_to_go_activity.getuser.equals("amir.khurrum@namal.edu.pk") && stat.equals("non") || stat.equals("consume"))
                    {
                        //list.remove(dataProvider);
                        //issue_adapter.this.notifyDataSetChanged();
                       expOrreject();

                    }
                    else
                        {
                            admindialogue();
                    }

                }
            });

        }
        else{
            handler=(DataHandler)row.getTag();
        }
        handler.user.setText(dataProvider.getUser());
        handler.msg.setText(dataProvider.getMessage());
        handler.stat.setText(dataProvider.getStatus());
        return row;
    }

    private void expOrreject() {
        AlertDialog.Builder alerdialogue=new AlertDialog.Builder(getContext());
        alerdialogue
                .setTitle("Action")
               // .setMessage("")
                .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        new DatePickerDialog(getContext(), date,
                                myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                                myCalendar.get(Calendar.DAY_OF_MONTH)).show();

                    }
                })
                .setNegativeButton("reject", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        rejectedOrAccept(user_data,msg_data,"rejected");
                       // list.remove(dataProvider);
                       // notifyDataSetChanged();

                    }
                })
                .setIcon(R.drawable.action)
                .show();

    }

    private void rejectedOrAccept(final String user_data, final String msg_data, final String rejected) {
        StringRequest rejoracpt = new StringRequest(Request.Method.POST, server_url3,
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
                params.put("selected", msg_data);
                params.put("user", user_data);
                params.put("reply", rejected);
                return params;
            }
        };
        Make_Request_Queue.getInstance(getContext()).addtorequestque(rejoracpt);
    }

    private void admindialogue() {
        AlertDialog.Builder alerdialogue=new AlertDialog.Builder(getContext());
        alerdialogue
                .setTitle("admin only")
                .setMessage("send request")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendtoAdmin(user_data,msg_data);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setIcon(R.drawable.request)
                .show();

    }

    private void sendtoAdmin(final String user_data, final String msg_data) {
        StringRequest request = new StringRequest(Request.Method.POST, server_url2,
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
                params.put("selected", msg_data);
                params.put("user", user_data);
                params.put("receive","amir.khurrum@namal.edu.pk");
                return params;
            }

        };
        Make_Request_Queue.getInstance(getContext()).addtorequestque(request);
        //implement it latter
    }
    private void issueComponent() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("done"))
                        {
                            //list.remove(pos);
                            //notifyDataSetChanged();
                            Toast.makeText(getContext(),"successfulley issued component",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(getContext(),"error",Toast.LENGTH_SHORT).show();
                        }

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
                params.put("user_id",user_data);
                params.put("comp_name",msg_data);
                params.put("due_date",duedate);
                params.put("status",stat);
                return params;
            }

        };
        Make_Request_Queue.getInstance(getContext()).addtorequestque(stringRequest);

    }

}
