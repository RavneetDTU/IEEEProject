package com.example.ravneet.ieeedtu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ravneet.ieeedtu.R;

/**
 * Created by ravneet on 17/6/17.
 */

public class Loginfragment extends Basefragment implements View.OnClickListener {

    private Button loginbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle savedState){
        View view = inflater.inflate(R.layout.fragment_layout,root,false);

        loginbutton = (Button) view.findViewById(R.id.fragment_login_btn_login);
        loginbutton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {


        }

}
