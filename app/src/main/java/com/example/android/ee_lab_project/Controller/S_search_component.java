package com.example.android.ee_lab_project.Controller;


import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.android.ee_lab_project.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//@RequiresApi(api = Build.VERSION_CODES.M)
public class S_search_component extends Fragment {
    public ArrayList<String> list1=new ArrayList<String>();
    public ArrayList<String> list2=new ArrayList<String>();
    public ArrayList<String> list3=new ArrayList<String>();
    public ArrayList<String> list4=new ArrayList<String>();
    public ArrayList<String> list5=new ArrayList<String>();
    ArrayAdapter<String> adapter1,adapter2,adapter3,adapter4,adapter5;
    private String prompt=" ";
    String selected;
    private View view;
    private Spinner type_1_spinner,type_2_spinner,type_3_spinner,type_4_spinner,type_5_spinner;
    private String tag;
    String server_url = "http://"+ logIn_main_page_activity.server_ip+"/componentName.php";
    String server_url2="http://"+ logIn_main_page_activity.server_ip+"/firebase.php";
    Context context;
    Map<String, String> parametersMap = new HashMap<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_s_search_component, container, false);
        context =getActivity();
        type_1_spinner = view.findViewById(R.id.analog_spin);
        type_2_spinner = view.findViewById(R.id.digital_spin);
        type_3_spinner = view.findViewById(R.id.sig_spin);
        type_4_spinner=view.findViewById(R.id.physics_spin);
        type_5_spinner=view.findViewById(R.id.eng_spin);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        type_1_spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                tag= (String) type_1_spinner.getTag();
                addData(tag);
                return false;
            }
        });
        type_2_spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                tag=(String)type_2_spinner.getTag();
                addData(tag);
                selectedItem();
                return false;
            }
        });
        type_3_spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                tag= (String) type_3_spinner.getTag();
                addData(tag);
                selectedItem();
                return false;
            }
        });
        type_4_spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                tag= (String) type_4_spinner.getTag();
                addData(tag);
                selectedItem();
                return false;
            }
        });
        type_5_spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                tag= (String) type_5_spinner.getTag();
                addData(tag);
                selectedItem();
                return false;
            }
        });

    }

    private void addData(final String tag) {
       // Log.d("tagsdfsdfsdfsd", tag+"");
        parametersMap.put("data",tag);
        CustomRequest jsonArray=new CustomRequest(Request.Method.POST, server_url,
                new JSONObject(parametersMap),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                       // Log.d("response", response+"");
                        if(tag.equals("analogue"))
                        {
                            try{
                                if(list1.isEmpty()!=true) //I used this if statment because it was adding list two times in adapter
                                {
                                    list1.clear();
                                }
                                list1.add(prompt);
                                for(int i=0;i<response.length();i++){
                                    JSONObject jsonObject=response.getJSONObject(i);
                                    list1.add(jsonObject.getString("comp_name"));
                                    adapter1=new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,list1);
                                    type_1_spinner.setAdapter(adapter1);
                                }
                                selectedItem();
                            }catch (JSONException e){
                                e.printStackTrace();
                            }

                        }
                        else
                            if(tag.equals("digital_electronic"))
                            {
                                try{
                                    if(list2.isEmpty()!=true) {
                                        list2.clear();
                                    }
                                    list2.add(prompt);
                                    for(int i=0;i<response.length();i++){
                                        JSONObject jsonObject=response.getJSONObject(i);
                                        list2.add(jsonObject.getString("comp_name"));
                                        adapter2=new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,list2);
                                        type_2_spinner.setAdapter(adapter2);
                                    }
                                    selectedItem();
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        else
                            if(tag.equals("digital_signal"))
                            {
                                try{
                                    if(list3.isEmpty()!=true) {
                                        list3.clear();
                                    }
                                    list3.add(prompt);
                                    for(int i=0;i<response.length();i++){
                                        JSONObject jsonObject=response.getJSONObject(i);
                                        list3.add(jsonObject.getString("comp_name"));
                                        adapter3=new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,list3);
                                        type_3_spinner.setAdapter(adapter3);
                                    }
                                    selectedItem();
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }

                            }
                        else
                            if(tag.equals("physics_robotics"))
                            {

                                try{
                                    if(list4.isEmpty()!=true) {
                                        list4.clear();
                                    }
                                    list4.add(prompt);
                                    for(int i=0;i<response.length();i++){
                                        JSONObject jsonObject=response.getJSONObject(i);
                                        list4.add(jsonObject.getString("comp_name"));
                                        adapter4=new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,list4);
                                        type_4_spinner.setAdapter(adapter4);
                                    }
                                    selectedItem();
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        else
                            {
                                try{
                                    if(list5.isEmpty()!=true) {
                                        list5.clear();
                                    }
                                    list5.add(prompt);
                                    for(int i=0;i<response.length();i++){
                                        JSONObject jsonObject=response.getJSONObject(i);
                                        list5.add(jsonObject.getString("comp_name"));
                                        adapter5=new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,list5);
                                        type_5_spinner.setAdapter(adapter5);
                                    }
                                    selectedItem();
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
                            }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Make_Request_Queue.getInstance(getActivity()).addtorequestque(jsonArray);
    }
    int count=0;
    private void selectedItem() {
        type_1_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = type_1_spinner.getSelectedItem().toString();
                if(count>1 && !(selected.equals(" "))) {
                    showDialogue();
                    Toast.makeText(getActivity(), selected, Toast.LENGTH_LONG).show();
                    count=-1;
                }
                count++;

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        type_2_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = type_2_spinner.getSelectedItem().toString();
                if(count>1 && !(selected.equals(" "))) {
                    showDialogue();
                    Toast.makeText(getActivity(), selected, Toast.LENGTH_LONG).show();
                    count=-1;
                }
                count++;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        type_3_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = type_3_spinner.getSelectedItem().toString();
                if(count>1 && !(selected.equals(" "))) {
                    showDialogue();
                    Toast.makeText(getActivity(), selected, Toast.LENGTH_LONG).show();
                    count=-1;
                }
                count++;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        type_4_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = type_4_spinner.getSelectedItem().toString();
                if(count>1 && !(selected.equals(" "))) {
                    showDialogue();
                    Toast.makeText(getActivity(), selected, Toast.LENGTH_LONG).show();
                    count=-1;
                }
                count++;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        type_5_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = type_5_spinner.getSelectedItem().toString();
                if(count>1 && !(selected.equals(" "))) {
                    showDialogue();
                    Toast.makeText(getActivity(), selected, Toast.LENGTH_LONG).show();
                    count=-1;
                }
                count++;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void showDialogue() {
        AlertDialog.Builder alerdialogue=new AlertDialog.Builder(getActivity());
        alerdialogue
                .setTitle("To Lab_Engineer")
                .setMessage("Send Request?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendData(selected, Where_to_go_activity.getuser);

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

    private void sendData(final String selected, final String getuser) {
        StringRequest request = new StringRequest(Request.Method.POST, server_url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("out"))
                        {
                            Toast.makeText(getActivity(),"Out Of Stock",Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("selected", selected);
                params.put("user", getuser);
                params.put("receive","farooq@namal.edu.pk");
                return params;
            }

        };
        Make_Request_Queue.getInstance(getActivity()).addtorequestque(request);
    }
}
