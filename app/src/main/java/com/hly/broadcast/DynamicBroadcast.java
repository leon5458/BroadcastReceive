package com.hly.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DynamicBroadcast extends AppCompatActivity {
    DyReceive dyReceive;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_broadcast_layout);

        //实例化IntentFilter对象
        IntentFilter filter = new IntentFilter();
        filter.addAction("huxiaomu");
        dyReceive = new DyReceive();
        //注册广播接收
        registerReceiver(dyReceive, filter);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("huxiaomu");
                intent.putExtra("type", "胡小牧:发送了动态广播");
                sendBroadcast(intent);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(dyReceive);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dyReceive);
    }
}
