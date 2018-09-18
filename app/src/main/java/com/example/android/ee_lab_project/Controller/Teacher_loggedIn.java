package com.example.android.ee_lab_project.Controller;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.ee_lab_project.R;

public class Teacher_loggedIn extends Fragment {
    Button account;
    Button ret_comp;
    Button issue_comp;
    Button lists_comp;
    View view;
    public T_account t_list_of_component=new T_account();
    public t_list_component t_list_component=new t_list_component();
    public Retrun_Component retrun_component=new Retrun_Component();
    FragmentTransaction transaction;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_teacher_logged_in,container,false);
        account=view.findViewById(R.id.account);
        ret_comp=view.findViewById(R.id.comp_return);
        issue_comp=view.findViewById(R.id.comp_issue);
        lists_comp=view.findViewById(R.id.comp_list);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, t_list_of_component);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        lists_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,t_list_component);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        issue_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),issue_component_new.class);
                startActivity(intent);
            }
        });
        ret_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,retrun_component);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        return view;
    }
}
