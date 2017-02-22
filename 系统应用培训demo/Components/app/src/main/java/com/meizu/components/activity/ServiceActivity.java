package com.meizu.components.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.meizu.components.service.MyService;
import com.meizu.components.R;
import com.meizu.components.tools.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhaoguofeng on 2016/12/21.
 */
public class ServiceActivity extends AppCompatActivity {
    @Bind(R.id.id_btn_startservice)
    Button btnStartService;
    @Bind(R.id.id_btn_stopservice)
    Button btnStopService;
    @Bind(R.id.id_btn_bindservice)
    Button btnBindService;
    @Bind(R.id.id_btn_unbindservice)
    Button btnUnbindService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);//初始化ButterKnife
    }

    //这里需要用到ServiceConnection在Context.bindService和context.unBindService()里用到
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        //当我bindService时，让TextView显示MyService里getSystemTime()方法的返回值
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub
            MyService mMyService = ((MyService.MyBinder) service).getService();
            Logger.i("activity调用service方法：" + mMyService.getData());
            tt();
//            mTextView.setText("I am frome Service :" + mMyService.getSystemTime());
        }

        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub

        }
    };





    @OnClick(R.id.id_btn_startservice)
    public void startService() {
        Intent intent = new Intent(this, MyService.class);
        this.startService(intent);
    }

    @OnClick(R.id.id_btn_stopservice)
    public void stopService() {
        Intent intent = new Intent(this, MyService.class);
        this.stopService(intent);
    }

    @OnClick(R.id.id_btn_bindservice)
    public void bindService() {
        Intent intent = new Intent(this, MyService.class);
        this.bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
    }

    private void tt(){
        Logger.i("测试顺序");
    }

    @OnClick(R.id.id_btn_unbindservice)
    public void unbindService() {
        this.unbindService(mServiceConnection);
    }
}
