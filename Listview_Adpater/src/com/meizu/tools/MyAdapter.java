package com.meizu.tools;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.meizu.Listview_Adpater.R;

public class MyAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private final static String Tag = "MyAdapter";
	private ArrayList<HashMap<String, Object>> listItem;

	public MyAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.mInflater = LayoutInflater.from(context);
		this.listItem = getListData();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listItem.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
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
		Log.d(Tag, "getView:" + position + "==" + convertView);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.activity_baseadapter, null);
			holder = new ViewHolder();
			// 得到各个控件的对象
			holder.title = (TextView) convertView.findViewById(R.id.tv_base_title);
			holder.detail = (TextView) convertView.findViewById(R.id.tv_base_detail);
			holder.btn = (Button) convertView.findViewById(R.id.btn_base_click);
			convertView.setTag(holder);// 绑定ViewHolder对象
		} else {
			holder = (ViewHolder) convertView.getTag();// 取出已保存的ViewHolder对象
		}
		// 设置TextView显示内容，即我们存放在动态数据总的数据
		holder.title.setText(listItem.get(position).get("itemTitle").toString());
		holder.detail.setText(listItem.get(position).get("itemDetail").toString());
		holder.btn.setOnClickListener(new OnClickListener() {// 为button添加点击事件

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Log.d(Tag, "你点击了按钮" + position);// 打印button的点击信息
					}
				});
		return convertView;
	}

	public final class ViewHolder {
		public TextView title;
		public TextView detail;
		public Button btn;
	}

	private ArrayList<HashMap<String, Object>> getListData() {
		Log.d(Tag, "getListData()");
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 10000; i++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("itemImage", R.drawable.ic_launcher);
			hashMap.put("itemTitle", "第" + i + "行");
			hashMap.put("itemDetail", "第" + i + "详细内容");
			listItem.add(hashMap);
		}
		return listItem;
	}
}
