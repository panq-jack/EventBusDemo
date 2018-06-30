package com.pq.eventbusdemo.eventbus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pq.eventbusdemo.R;
import com.pq.eventbusdemo.model.Event;

import de.greenrobot.event.EventBus;

/**
 * Created by pan on 2018/6/30.
 */

public class E2ParentActivity extends AppCompatActivity {

    private static final String tag = "ppp_E2ParentActivity";

    protected TextView textView;

    protected StringBuilder stringBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        EventBus.getDefault().register(this);

        textView = (TextView) findViewById(R.id.text);
    }

    public void jumpNext(View view){
        Intent intent = new Intent(this,E2SendActivity.class);
        startActivity(intent);
    }

    public void onEvent(Event event){
        String str = tag + "\t"+"onEvent\t"+event.name+"\t currentThread= "+Thread.currentThread().getName();
        Log.d(tag,str);
        stringBuilder.append("\n").append(str);
        textView.setText(stringBuilder.toString());
    }

    public void onEventMainThread(Event event){
        String str = tag + "\t"+"onEventMainThread\t"+event.name+"\t currentThread= "+Thread.currentThread().getName();
        Log.d(tag,str);
        stringBuilder.append("\n").append(str);
        textView.setText(stringBuilder.toString());
    }

    public void onEventBackgroundThread(Event event){
        String str = tag + "\t"+"onEventBackgroundThread\t"+event.name+"\t currentThread= "+Thread.currentThread().getName();
        Log.d(tag,str);
        stringBuilder.append("\n").append(str);
        textView.setText(stringBuilder.toString());
    }

    public void onEventAsync(Event event){
        String str = tag + "\t"+"onEventAsync\t"+event.name+"\t currentThread= "+Thread.currentThread().getName();
        Log.d(tag,str);
        stringBuilder.append("\n").append(str);
        textView.setText(stringBuilder.toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        stringBuilder.setLength(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
