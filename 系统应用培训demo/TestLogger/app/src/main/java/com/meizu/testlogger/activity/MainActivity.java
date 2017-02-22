package com.meizu.testlogger.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.meizu.testlogger.R;
import com.meizu.testlogger.tools.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.e("输出到文件");
//        registerReceiver(timerTick,new IntentFilter(Intent.ACTION_TIME_TICK));
    }

//    BroadcastReceiver timerTick=new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Logger.e("接收到时间广播");
//        }
//    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(timerTick);
    }
}
