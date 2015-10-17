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
	 * 1.������Activity���ֵ�һ��ListView��ʱ��convertViewΪ�㡣���û����¹���ListViewʱ���������Ŀ��Ϊ���ɼ�����������µ���Ŀ����ʱ��convertView����Ϊ�գ����Ǵ�����һϵ�е�convertView��ֵ���������¹�һ����ʱ�򣬷��ֵ�11�е������������ɵ�22�У�
	 * ��12�е������������ɵ�23�С�Ҳ����˵convertView�൱��һ�����棬��ʼΪ0��������Ŀ��Ϊ���ɼ������������������ݣ������ٳ�������Ŀֻ��Ҫ�������ݾͿ����ˣ���������ʡ��ϵͳ���ϵĿ�����
	 * 2.������Tag�ĸ����������õİ취��������ȷʵ��ʹListView��ø������������У���convertViewΪ��ʱ
	 * ����setTag()����Ϊÿ��View��һ����ſؼ���ViewHolder���󡣵�convertView��Ϊ�գ��ظ������Ѿ�������view��ʱ��ʹ��getTag()������ȡ�󶨵�ViewHolder���������ͱ�����findViewById�Կؼ��Ĳ���ѯ�����ǿ��ٶ�λ���ؼ���
	 */
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		Log.d(Tag, "getView:" + position + "==" + convertView);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.activity_baseadapter, null);
			holder = new ViewHolder();
			// �õ������ؼ��Ķ���
			holder.title = (TextView) convertView.findViewById(R.id.tv_base_title);
			holder.detail = (TextView) convertView.findViewById(R.id.tv_base_detail);
			holder.btn = (Button) convertView.findViewById(R.id.btn_base_click);
			convertView.setTag(holder);// ��ViewHolder����
		} else {
			holder = (ViewHolder) convertView.getTag();// ȡ���ѱ����ViewHolder����
		}
		// ����TextView��ʾ���ݣ������Ǵ���ڶ�̬�����ܵ�����
		holder.title.setText(listItem.get(position).get("itemTitle").toString());
		holder.detail.setText(listItem.get(position).get("itemDetail").toString());
		holder.btn.setOnClickListener(new OnClickListener() {// Ϊbutton��ӵ���¼�

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Log.d(Tag, "�����˰�ť" + position);// ��ӡbutton�ĵ����Ϣ
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
			hashMap.put("itemTitle", "��" + i + "��");
			hashMap.put("itemDetail", "��" + i + "��ϸ����");
			listItem.add(hashMap);
		}
		return listItem;
	}
}
