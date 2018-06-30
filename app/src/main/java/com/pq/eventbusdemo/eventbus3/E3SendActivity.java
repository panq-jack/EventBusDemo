package com.pq.eventbusdemo.eventbus3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pq.eventbusdemo.R;
import com.pq.eventbusdemo.model.Event;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by pan on 2018/6/30.
 */

public class E3SendActivity extends AppCompatActivity {

    private static final String tag = "ppp_E3SendActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
    }


    public void postEvent(View view){
        EventBus.getDefault().post(new Event("msg from E3SendActivity  in UI thread! thread= "+Thread.currentThread().getName()));
    }

    public void postRunnableEvent(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefault().post(new Event("msg from E3SendActivity  in worker thread! thread= "
                        +Thread.currentThread().getName()));
            }
        }).start();
    }


}
