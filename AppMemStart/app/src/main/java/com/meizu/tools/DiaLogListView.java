package com.meizu.tools;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.meizu.domain.PckInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoguofeng on 2016/1/12.
 */
public class DiaLogListView {

    private void dialogListView(Context context, List<PckInfo> pckInfos) {
        List<PckInfo> mainPckInfos = new ArrayList<>();
        LinearLayout linearLayoutMain = new LinearLayout(context);//自定义一个布局文件
        linearLayoutMain.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ListView lv = new ListView(context);//this为获取当前的上下文
        MyAdapter myAdapterDL = new MyAdapter(context, pckInfos, true);
        lv.setAdapter(myAdapterDL);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyAdapter.ViewHolder holder = (MyAdapter.ViewHolder) view.getTag();
                holder.ckb_choose.toggle();
                MyAdapter.getIsSelected().put(position, holder.ckb_choose.isChecked());
            }
        });
        linearLayoutMain.addView(lv);//往这个布局中加入listview

        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("选择应用").setView(linearLayoutMain);//在这里把写好的这个listview的布局加载dialog中
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                HashMap<Integer, Boolean> isSelected = MyAdapter.getIsSelected();
//                mainPckInfos.clear();
//                for (int i = 0; i < isSelected.size(); i++) {
//                    if (isSelected.get(i) == true) {
//                        mainPckInfos.add(allPckInfos.get(i));
//                    }
//                }
//                myAdapter = new MyAdapter(context, mainPckInfos, false);
//                listView.setAdapter(myAdapter);
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
