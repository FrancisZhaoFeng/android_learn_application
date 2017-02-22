package com.meizu.save.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.google.gson.Gson;
import com.meizu.save.R;
import com.meizu.save.bean.User;
import com.meizu.save.service.JsonService;
import com.meizu.save.util.SharePreferenceUtil;
import com.orhanobut.logger.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.btn_startservice)
    Button btnJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * 实体类对象转json字符串
     */
    @OnClick(R.id.btn_tojson)
    public void toJson() {
        User user = new User("francis", 18, "123@meizu.com");
        String data = new Gson().toJson(user);
        Logger.i("data字符串内容：" + data);
    }

    /**
     * json字符串转实体类对象
     */
    @OnClick(R.id.btn_fromjson)
    public void fromJson() {
        String data = "{\"age\":18,\"email\":\"123@meizu.com\",\"name\":\"francis\",\"baseObjId\":0}";
        User user = new Gson().fromJson(data, User.class);
        Logger.i("user对象内容：" + user.toString());
    }

    /**
     * activity传对象到service
     */
    @OnClick(R.id.btn_startservice)
    public void startService() {
        Logger.i("启动service");
        User user = new User("francis", 18, "123@meizu.com");
        Intent intent = new Intent(this, JsonService.class);
        intent.putExtra("user", new Gson().toJson(user));
        this.startService(intent);
    }

    /**
     * 通过sharepreference存储数据
     */
    @OnClick(R.id.btn_savesp)
    public void saveSp() {
        User user = new User("francis", 18, "123@meizu.com");
        SharePreferenceUtil.saveObjectSharedPreferences(User.class.toString(), user);
    }

    /**
     * 通过sharepreference获取数据
     */
    @OnClick(R.id.btn_getsp)
    public void getSp() {
        String data = SharePreferenceUtil.getObjectSharedPreferences(User.class.toString());
        Logger.i("从sharepreference中获取的data字符串内容:" + data);
        User user = new Gson().fromJson(data, User.class);
        Logger.i("转为user对象的内容:" + user.toString());
    }
}
