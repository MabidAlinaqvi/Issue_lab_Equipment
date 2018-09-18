package com.example.android.ee_lab_project.Controller;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.ee_lab_project.R;

public class Student_logged_In extends Fragment {
    S_search_component s_search_component=new S_search_component();
    FragmentTransaction transaction;
    private Button search;
    private Button stu_account;
    private String TAG="lab123_S_logged_in";
    private View view;

    public Student_logged_In() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_student_logged__in, container, false);
        search=view.findViewById(R.id.comp_search);
        stu_account=view.findViewById(R.id.s_account);
        search.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            transaction=getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame,s_search_component);
            transaction.addToBackStack(null);
            transaction.commit();

        }
    });
       stu_account.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getActivity(),Student_account_new.class);
               startActivity(intent);
           }
       });

        return view;
    }

}
