package com.example.anhtuan.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.anhtuan.myapplication.fragment.Calendar_fragment;
import com.example.anhtuan.myapplication.fragment.Todolist_fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.ln_todolist)
    LinearLayout lnTodolist;
    @BindView(R.id.ln_celendar)
    LinearLayout lnCelendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        lnTodolist.setOnClickListener(this);
        lnCelendar.setOnClickListener(this);
        replaceFragmentContent(new Todolist_fragment());
    }

    private void replaceFragmentContent(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.rl_fragment, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == lnTodolist) {
            replaceFragmentContent(new Todolist_fragment());
        }if (v == lnCelendar){
            replaceFragmentContent(new Calendar_fragment());
        }
    }
}
