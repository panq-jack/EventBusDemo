package com.pq.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pq.eventbusdemo.eventbus2.E2MainActivity;
import com.pq.eventbusdemo.eventbus3.E3MainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toEventbus2(View view){
        jump(E2MainActivity.class);
    }

    public void toEventbus3(View view){
        jump(E3MainActivity.class);
    }


    private void jump(Class klass){
        Intent intent = new Intent(MainActivity.this,klass);
        startActivity(intent);
    }
}
