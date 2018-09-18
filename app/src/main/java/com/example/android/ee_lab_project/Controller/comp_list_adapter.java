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
import com.example.android.ee_lab_project.Model.comp_listdataProvider;

import java.util.ArrayList;

/**
 * Created by NO I.D on 11/9/2017.
 */

public class comp_list_adapter extends ArrayAdapter {
        ArrayList list=new ArrayList();

    public comp_list_adapter(@NonNull Context context, int resource) {
            super(context, resource);
        }
        public static class DataHandler
        {
            TextView comp;
            TextView typ;
            TextView stat;
            TextView quan;
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
            row=inflater.inflate(R.layout.comp_listrow_layout,parent,false);
            handler=new DataHandler();
            handler.comp=row.findViewById(R.id.comp_nam);
            handler.typ=row.findViewById(R.id.type);
            handler.stat=row.findViewById(R.id.stat);
            handler.quan=row.findViewById(R.id.quant);
            row.setTag(handler);

        }
        else{
            handler=(DataHandler)row.getTag();
        }
        comp_listdataProvider dataProvider;
        dataProvider=(comp_listdataProvider)this.getItem(position);
        handler.comp.setText(dataProvider.getCom_name());
        handler.typ.setText(dataProvider.getCom_type());
        handler.stat.setText(dataProvider.getCom_stat());
        handler.quan.setText(dataProvider.getCom_quant());
        return row;
    }
}
