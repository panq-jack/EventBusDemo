package com.pq.eventbusdemo.eventbus3;

import android.util.Log;

import com.pq.eventbusdemo.model.Event;

import org.greenrobot.eventbus.Subscribe;

import org.greenrobot.eventbus.ThreadMode;


/**
 * Created by pan on 2018/6/30.
 */

public class E3MainActivity extends E3ParentActivity {

    private static final String tag = "ppp_E3MainActivity";


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

}
