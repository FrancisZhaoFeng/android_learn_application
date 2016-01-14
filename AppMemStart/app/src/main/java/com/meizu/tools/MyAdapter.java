package com.meizu.tools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.meizu.appmemstart.R;
import com.meizu.domain.PckInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private final static String TAG = "MyAdapter";
    private List<Map<String, Object>> listItem = new ArrayList<>();//建立一个数组存储listview上显示的数据
    private static HashMap<Integer, Boolean> isSelected;

    public MyAdapter(Context context, List<PckInfo> pckInfos,boolean isNeedChk) {
        // TODO Auto-generated constructor stub
        this.mInflater = LayoutInflater.from(context);
        isSelected = new HashMap<>();
        initDate(pckInfos);
    }

    private void initDate(List<PckInfo> pckInfos) {
        for (PckInfo pckInfo : pckInfos) {//initData为一个list类型的数据源
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("itemImage", pckInfo.getIcon());
            hashMap.put("itemTitle", pckInfo.getDesktopName());
            hashMap.put("itemDetail", pckInfo.getPackageName());
            listItem.add(hashMap);
        }
        for (int i = 0; i < listItem.size(); i++)
            getIsSelected().put(i, false);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    /*
     * 1.当启动Activity呈现第一屏ListView的时候，convertView为零。当用户向下滚动ListView时，上面的条目变为不可见，下面出现新的条目。这时候convertView不再为空，而是创建了一系列的convertView的值。当又往下滚一屏的时候，发现第11行的容器用来容纳第22行，
     * 第12行的容器用来容纳第23行。也就是说convertView相当于一个缓存，开始为0，当有条目变为不可见，它缓存了它的数据，后面再出来的条目只需要更新数据就可以了，这样大大节省了系统资料的开销。
     * 2.引入了Tag的概念。或许不是最好的办法，但是它确实能使ListView变得更流畅。代码中，当convertView为空时
     * ，用setTag()方法为每个View绑定一个存放控件的ViewHolder对象。当convertView不为空，重复利用已经创建的view的时候，使用getTag()方法获取绑定的ViewHolder对象，这样就避免了findViewById对控件的层层查询，而是快速定位到控件。
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
//        Log.d(Tag, "getView:" + position + "==" + convertView);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.activity_baseadapter, null);
            holder = new ViewHolder();
            // 得到各个控件的对象
            holder.icon = (ImageView) convertView.findViewById(R.id.img_base_pic);
            holder.title = (TextView) convertView.findViewById(R.id.id_base_title);
            holder.detail = (TextView) convertView.findViewById(R.id.id_base_detail);
            holder.ckb_choose = (CheckBox) convertView.findViewById(R.id.id_base_ckb);
//            holder.ckb_choose.setVisibility(View.INVISIBLE);
            convertView.setTag(holder);// 绑定ViewHolder对象
        } else {
            holder = (ViewHolder) convertView.getTag();// 取出已保存的ViewHolder对象
        }
        // 设置TextView显示内容，即我们存放在动态数据总的数据
        holder.icon.setImageDrawable((Drawable) listItem.get(position).get("itemImage"));
        holder.title.setText(listItem.get(position).get("itemTitle").toString());
        holder.detail.setText(listItem.get(position).get("itemDetail").toString());
        holder.ckb_choose.setChecked(getIsSelected().get(position));
        return convertView;
    }

    public final class ViewHolder {
        public ImageView icon;
        public TextView title;
        public TextView detail;
        public CheckBox ckb_choose;
    }

    public static HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {
        MyAdapter.isSelected = isSelected;
    }

}
