package com.hly.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BroadStaticActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broad_static_activity_layout);

        findViewById(R.id.st_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("hly");
                intent.setPackage(getPackageName());
                intent.putExtra("type", "胡小牧:发送了静态广播");
                sendBroadcast(intent);
            }
        });

    }
}
