package com.hienthai.communication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentA fragmentA = FragmentA.newInstance("Hien Thai", "300698");
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentA).commit();
    }
}