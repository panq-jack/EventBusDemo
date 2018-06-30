package com.pq.eventbusdemo.eventbus2;

import android.os.Bundle;
import android.util.Log;

import com.pq.eventbusdemo.model.Event;

/**
 * Created by pan on 2018/6/30.
 */

public class E2MainActivity extends E2ParentActivity {

    private static final String tag = "ppp_E2MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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


}
