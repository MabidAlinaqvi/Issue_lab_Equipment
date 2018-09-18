package com.example.android.ee_lab_project.Controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.ee_lab_project.R;
import com.example.android.ee_lab_project.Model.S_accountdataProvider;

import java.util.ArrayList;

/**
 * Created by NO I.D on 11/9/2017.
 */

public class s_account_adapter extends ArrayAdapter {
ArrayList list=new ArrayList();

    public s_account_adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    public static class DataHandler
    {
        TextView comp;
        TextView issue;
        TextView due;
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
        if(row==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.s_accountrow_layout,parent,false);
            handler=new DataHandler();
            handler.comp=row.findViewById(R.id.comp_nam);
            handler.issue=row.findViewById(R.id.issu_dat);
            handler.due=row.findViewById(R.id.du_dat);
            row.setTag(handler);

        }
        else{
            handler=(DataHandler)row.getTag();
        }
        S_accountdataProvider dataProvider;
        dataProvider=(S_accountdataProvider)this.getItem(position);
        handler.comp.setText(dataProvider.getComp_name());
        handler.issue.setText(dataProvider.getIssue_date());
        handler.due.setText(dataProvider.getDue_date());
        return row;
    }
}
