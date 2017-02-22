package com.meizu.layout.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;

import com.meizu.layout.R;
import com.meizu.layout.beans.PckInfo;
import com.meizu.layout.tools.MyAdapter;
import com.meizu.layout.tools.PackageMgr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PackageLvActivity extends AppCompatActivity {
    private List<PckInfo> allPckInfos = new ArrayList<>();
    private List<String> listPackage = new ArrayList<>();//保存包名
    private EditText edt_Num;
    private CheckBox chb_checkAll;
    private ListView listView;
    private PackageMgr packgeMan;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_lv);
        initData();
        setMainListView();
        chb_checkAll.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                HashMap<Integer, Boolean> isSelected = MyAdapter.getIsSelected();
                for (int i = 0; i < allPckInfos.size(); i++) {
                    isSelected.put(i, isChecked);
                }
                myAdapter.setIsSelected(isSelected);
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * 初始化控件
     */
    private void initData() {
        edt_Num = (EditText) this.findViewById(R.id.edt_num);
        chb_checkAll = (CheckBox) this.findViewById(R.id.chb_main);
        listView = (ListView) this.findViewById(R.id.lv_main_package);
        packgeMan = new PackageMgr(this);
        packgeMan.getPackageName(allPckInfos);//   获取手机上的安装应用信息
    }

    /**
     * 初始化的时候显示手机上的所有的应用信息
     */
    private void setMainListView() {
        myAdapter = new MyAdapter(this, allPckInfos, false);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyAdapter.ViewHolder holder = (MyAdapter.ViewHolder) view.getTag();
                holder.ckb_choose.toggle();
                MyAdapter.getIsSelected().put(position, holder.ckb_choose.isChecked());
            }
        });
    }
}
