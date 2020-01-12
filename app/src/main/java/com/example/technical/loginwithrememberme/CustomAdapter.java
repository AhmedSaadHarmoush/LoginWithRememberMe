package com.example.technical.loginwithrememberme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Technical on 5/5/2016.
 */
public class CustomAdapter extends ArrayAdapter {
    private ArrayList<String> names;
    private ArrayList<String> passwords;
    private Context context;

    public CustomAdapter(Context context, ArrayList<String> names, ArrayList<String> passwords) {
        super(context, R.layout.list_item, names);
        this.context=context;
        this.names=names;
        this.passwords=passwords;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inf.inflate(R.layout.list_item,null,true);

        TextView txtUser= (TextView) row.findViewById(R.id.user);
        TextView txtPass= (TextView) row.findViewById(R.id.pass);

        txtUser.setText(names.get(position));
        txtPass.setText(passwords.get(position));

        return row;
    }
}
