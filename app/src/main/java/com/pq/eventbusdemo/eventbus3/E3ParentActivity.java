package com.pq.eventbusdemo.eventbus3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pq.eventbusdemo.R;
import com.pq.eventbusdemo.model.Event;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * Created by pan on 2018/6/30.
 */

public class E3ParentActivity extends AppCompatActivity {

    private static final String tag = "ppp_E3ParentActivity";

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
        Intent intent = new Intent(this,E3SendActivity.class);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void testOnEvent(Event event){
        String str = tag + "\t"+"onEvent\t"+event.name+"\t currentThread= "+Thread.currentThread().getName();
        Log.d(tag,str);
        stringBuilder.append("\n").append(str);
        textView.setText(stringBuilder.toString());
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void testOnEventMainThread(Event event){
        String str = tag + "\t"+"onEventMainThread\t"+event.name+"\t currentThread= "+Thread.currentThread().getName();
        Log.d(tag,str);
        stringBuilder.append("\n").append(str);
        textView.setText(stringBuilder.toString());
    }


    @Subscribe(threadMode = ThreadMode.BACKGROUND, sticky = true)
    public void testOnEventBackgroundThread(Event event){
        String str = tag + "\t"+"onEventBackgroundThread\t"+event.name+"\t currentThread= "+Thread.currentThread().getName();
        Log.d(tag,str);
        stringBuilder.append("\n").append(str);
        textView.setText(stringBuilder.toString());
    }


    @Subscribe(threadMode = ThreadMode.ASYNC, sticky = true)
    public void testOnEventAsync(Event event){
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
