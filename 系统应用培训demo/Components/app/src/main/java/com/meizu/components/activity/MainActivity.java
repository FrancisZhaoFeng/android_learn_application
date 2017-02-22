package com.meizu.components.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.meizu.components.R;
import com.meizu.components.tools.Logger;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    /**
     * 注册你要用到的变量，比如说service，receive，这些变量是无论你的Activity是在前台还是在后台都能够被响应到，然后调用onCreate用来初始化的函数初始化布局信息。
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//初始化ButterKnife
        Logger.i("onCreate");
        Log.i("components", "onCreate");

    }

    /**
     * 注册一些变量，这些变量必须在Android Activity类在前台的时候才能够被响应。
     */
    @Override
    protected void onStart() {
        super.onStart();
        Logger.i("onStart");
    }

    /**
     * 调用一些刷新UI的函数，当Activity调用到这里时就要刷新一下UI各控件的状态。
     */
    @Override
    protected void onResume() {
        super.onResume();
        Logger.i("onResume");
    }

    /**
     * 一般是做一些变量的设置，因为这个时候Activity马上就要切到后台处理，可能有些变量就要被释放掉或者状态要做些相应的调整。
     */
    @Override
    protected void onPause() {
        super.onPause();
        Logger.i("onPause");
    }

    /**
     * 反注册在onStart函数中注册的变量。
     */
    @Override
    protected void onStop() {
        super.onStop();
        Logger.i("onStop");
    }

    /**
     * 反注册在onCreate函数中注册的变量。
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.i("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.i("onRestart");
    }

    @OnClick(R.id.id_btn_otheractivity)
    public void otherActivity() {
        Intent intent = new Intent(this, OtherActivity.class);
        this.startActivity(intent);
    }
}
