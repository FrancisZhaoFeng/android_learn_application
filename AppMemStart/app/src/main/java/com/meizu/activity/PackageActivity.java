package com.meizu.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;

import com.meizu.appmemstart.R;
import com.meizu.common.Contants;
import com.meizu.dao.DBManager;

import java.util.ArrayList;
import java.util.List;

public class PackageActivity extends AppCompatActivity {
    private final static String TAG = "PackageActivity";
    private EditText edtApp;
    private EditText edtActivity;
    private EditText edtTime;
    private ListView lvElement;
    private CheckBox chkElement;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edtApp = (EditText) findViewById(R.id.edt_appnum);
        edtActivity = (EditText) findViewById(R.id.edt_activitynum);
        edtTime = (EditText) findViewById(R.id.edt_timenum);
        lvElement = (ListView) findViewById(R.id.lv_element);
        chkElement = (CheckBox) findViewById(R.id.chb_report);
        dbManager = DBManager.getInstance(PackageActivity.this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: " + (edtApp.getText().toString().equals("")));
                if (edtApp.getText() != null && !edtApp.getText().toString().equals(""))
                    Contants.USERHABITINFO.setAppNum(Integer.valueOf(edtApp.getText().toString()));
                if (edtActivity.getText() != null && !edtActivity.getText().toString().equals(""))
                    Contants.USERHABITINFO.setActivityNum(Integer.valueOf(edtActivity.getText().toString()));
                if (edtTime.getText() != null && !edtTime.getText().toString().equals(""))
                    Contants.USERHABITINFO.setTimeNum(Integer.valueOf(edtTime.getText().toString()));
                List<String> memData = new ArrayList<>();
                SparseBooleanArray bool = lvElement.getCheckedItemPositions();
                for (int i = 0; i < Contants.dumpElement.length; i++) {
                    if (bool.get(i))
                        memData.add(Contants.dumpElement[i]);
                }
                Contants.USERHABITINFO.setMemData(memData);
                dbManager.insertUserHabitInfo(Contants.USERHABITINFO);
                onBackPressed();
//                onDestroy();
            }
        });

        chkElement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for (int i = 0; i < Contants.dumpElement.length; i++) {
                    lvElement.setItemChecked(i, isChecked);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtApp.setHint("" + Contants.USERHABITINFO.getAppNum());
        edtActivity.setHint("" + Contants.USERHABITINFO.getActivityNum());
        edtTime.setHint("" + Contants.USERHABITINFO.getTimeNum());
        lvElement.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, Contants.dumpElement));

        for (int i = 0; i < Contants.USERHABITINFO.getMemData().size(); i++) {
            Log.i(TAG, "initData: getMemData," + Contants.USERHABITINFO.getMemData().get(i));
            for (int j = 0; j < Contants.dumpElement.length; j++) {
                Log.i(TAG, "initData: dumpElement," + Contants.dumpElement[j]);
                if (Contants.USERHABITINFO.getMemData().get(i).equals(Contants.dumpElement[j])) {
                    Log.e(TAG, "initData: set," + "j:" + j + "," + Contants.dumpElement[j]);
                    lvElement.setItemChecked(j, true);
                    break;
                }
            }
        }

    }

    @Override
    public void onBackPressed() {
        ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                PackageActivity.this.getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);//activity切换隐藏键盘
        dbManager.close("PackageActivity");
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
