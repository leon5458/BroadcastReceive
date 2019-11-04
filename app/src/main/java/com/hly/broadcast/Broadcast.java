package com.hly.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class Broadcast extends BroadcastReceiver {
    private static final String tag = "-------------hxm";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null && info.isAvailable()) {
                String name = info.getTypeName();
                Log.e(tag, "当前网络名称：" + name);
                //doSomething()
            } else {
                Toast.makeText(context, "当前网络不可用", Toast.LENGTH_SHORT).show();
                Log.e(tag, "没有可用网络");
                //doSomething()
            }
        }
    }
}
