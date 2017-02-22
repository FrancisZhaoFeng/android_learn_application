package com.meizu.components.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.meizu.components.R;
import com.meizu.components.common.Constant;
import com.meizu.components.tools.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhaoguofeng on 2016/12/21.
 */
public class BroadcastActivity extends AppCompatActivity {
    @Bind(R.id.id_btn_dynamicbc)
    Button btnDynamicBc;
    @Bind(R.id.id_btn_staticbc)
    Button btnStaticbc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        ButterKnife.bind(this);//初始化ButterKnife
        registerReceiver(broadcastReceiver, new IntentFilter(Constant.DYNAMIC_BC));
        registerReceiver(screenOffOn, new IntentFilter(Intent.ACTION_SCREEN_ON));//不能进行静态注册
        registerReceiver(screenOffOn, new IntentFilter(Intent.ACTION_SCREEN_OFF));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    @OnClick(R.id.id_btn_dynamicbc)
    public void dynamicBc() {
        Logger.i("开始发送动态广播");
        Intent intent = new Intent();
        intent.setAction(Constant.DYNAMIC_BC);
        intent.putExtra("msg", "接收到动态广播");
        sendBroadcast(intent);
    }

    @OnClick(R.id.id_btn_staticbc)
    public void staticBc() {
        Logger.i("开始发送静态广播");
        Intent intent = new Intent();
        intent.setAction(Constant.STATIC_BC);
        intent.putExtra("msg", "接收到静态广播");
        sendBroadcast(intent);
    }

    /**
     * 自定义动态广播
     */
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // 动态注册广播
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            String msg = intent.getStringExtra("msg");
            Logger.i("DynamicBroadcast:" + msg);
            Toast.makeText(context, "DynamicBroadcast:" + msg, Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * 亮屏灭屏动态广播
     */
    BroadcastReceiver screenOffOn = new BroadcastReceiver() {

        //When Event is published, onReceive method is called
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                Logger.i("Screen ON");
            } else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                Logger.i("Screen OFF");
            }
        }
    };
}
