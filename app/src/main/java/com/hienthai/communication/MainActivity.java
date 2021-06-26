package com.hienthai.communication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity /*implements FragmentOne.FragmentOneListener, FragmentTwo.FragmentTwoListener*/ {

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FragmentA fragmentA = FragmentA.newInstance("Hien Thai", "300698");  Send Data to a New Fragment with a Factory Method
//        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentA).commit();

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrmOne, fragmentOne)
                .replace(R.id.containerFrmTwo, fragmentTwo)
                .commit();

    }

//    @Override
//    public void onInputFrmOneSent(CharSequence input) {
//        fragmentTwo.updateEditText(input);
//    }
//
//    @Override
//    public void onInputFrmTwoSent(CharSequence input) {
//        fragmentOne.updateEditText(input);
//    }
}