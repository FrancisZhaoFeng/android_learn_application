package com.meizu.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.meizu.beans.ApkTestInfoBean;
import com.meizu.beans.UserHabitBean;
import com.meizu.common.Constant;
import com.meizu.report.HtmlOut;
import com.meizu.service.TestService;
import com.meizu.utils.ApkHandleUtil;
import com.meizu.utils.FileUtil;

import org.litepal.LitePalApplication;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtPath;
    EditText edtCount;
    RelativeLayout rlMonkey;
    RadioButton rdbYes;
    RadioButton rdbNo;
    EditText edtMonkeyTime;
    ImageButton imgbReport;
    ImageButton imgbDelete;

    UserHabitBean userHabitBean = new UserHabitBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LitePalApplication.initialize(this);//初始化litepal
        Connector.getDatabase();//操作一下数据库 令新建表、升级表得以执行
        initail();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_myes:
                rlMonkey.setVisibility(View.VISIBLE);
                userHabitBean.setIsNeedMonkey(true);
                break;
            case R.id.rb_mno:
                rlMonkey.setVisibility(View.GONE);
                userHabitBean.setIsNeedMonkey(false);
                break;
            case R.id.imgb_report:
                HtmlOut htmlOut = new HtmlOut();
                htmlOut.creathtml();
                htmlOut.openBrower(Constant.autotestPath + Constant.reportName, MainActivity.this);
                Toast.makeText(this, "生成成功，路径：" + Constant.autotestPath, Toast.LENGTH_SHORT).show();
                break;
            case R.id.imgb_delete:
                DataSupport.deleteAll(ApkTestInfoBean.class);
                Toast.makeText(this, "清除数据库内容 成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initail() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDate();
                Intent intent = new Intent(MainActivity.this, TestService.class);
                intent.putExtra("path", userHabitBean.getFilePath());
                intent.putExtra("count", userHabitBean.getCount());
                intent.putExtra("isMonkey", userHabitBean.getIsNeedMonkey());
                intent.putExtra("mTime", userHabitBean.getMonkeyRunTime());
                startService(intent);
                onBackPressed();
            }
        });
        //=========================//自己定义的控件
        edtPath = (EditText) this.findViewById(R.id.edt_path);
        edtCount = (EditText) this.findViewById(R.id.edt_count);
        rlMonkey = (RelativeLayout) this.findViewById(R.id.rl_monkey);
        rdbYes = (RadioButton) this.findViewById(R.id.rb_myes);
        rdbNo = (RadioButton) this.findViewById(R.id.rb_mno);
        edtMonkeyTime = (EditText) this.findViewById(R.id.edt_mtime);
        imgbReport = (ImageButton) this.findViewById(R.id.imgb_report);
        imgbDelete = (ImageButton) this.findViewById(R.id.imgb_delete);
        rdbYes.setOnClickListener(this);
        rdbNo.setOnClickListener(this);
        imgbReport.setOnClickListener(this);
        imgbDelete.setOnClickListener(this);
    }

    private void getDate() {
        String path = edtPath.getText().toString();
        String count = edtCount.getText().toString();
        String mTime = edtMonkeyTime.getText().toString();
        userHabitBean.setFilePath(path.equals("") ? "apptest" : path);
        userHabitBean.setCount(count.equals("") ? 5 : Integer.valueOf(count));
        userHabitBean.setMonkeyRunTime(mTime.equals("") ? 120 : Integer.valueOf(mTime));
    }
}