package com.lstr.weather.app.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by LSTR on 10/30/16.
 */
public class BaseFragment extends Fragment {
    AppCompatActivity activity;
    View v_root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (AppCompatActivity) getActivity();
    }

    public AppCompatActivity getAppActivity(){
        return activity;
    }

    protected void injectView(View view)
    {
        ButterKnife.bind(this,view);
    }
    protected void setViewRoot(View view) {
        v_root = view;
    }

    protected void setToolbar(Toolbar toolbar, String title){
        toolbar.setTitle(title);
        activity.setSupportActionBar(toolbar);
    }

    public void showMessage(String message) {
        if(v_root == null){
            Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
        }else{
            Snackbar snackbar = Snackbar.make(v_root, message, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }
}