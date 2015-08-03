package com.meizu.androidframent_tab;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author zhaoguofeng
 * 
 */
public class MainActivity extends Activity implements OnClickListener {

	/**
	 * ����չʾ��Fragment
	 */
	private MessageFragment messageFragment;
	private ContactsFragment contactsFragment;
	private NewsFragment newsFragment;
	private SettingFragment settingFragment;
	/**
	 * ���ֽ���
	 */
	private View messageLayout;
	private View contactsLayout;
	private View newsLayout;
	private View settingLayout;
	/**
	 * ��Tab��������ʾ��ͼ�꣬������ɫ��ͨ��setImageResoure(R.id.)����
	 */
	private ImageView messageImage;
	private ImageView contactsImage;
	private ImageView newsImage;
	private ImageView settingImage;
	/**
	 * ��Tab��������ʾ�����֣�������ɫ��ͨ��setTextColor(Color.WHITE)����
	 */
	private TextView messageText;
	private TextView contactsText;
	private TextView newsText;
	private TextView settingText;
	/**
	 * ������Ƭ����
	 */
	private FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // ����app�ޱ���Ч��
		setContentView(R.layout.activity_main);
		initView();
		fragmentManager = getFragmentManager(); // ��ȡ��Ƭ����
		setTabSelection(0);
	}

	/**
	 * �����ȡ��ÿ����Ҫ�õ��Ŀؼ���ʵ���������������úñ�Ҫ�ĵ���¼�
	 */
	private void initView() {
		messageLayout = this.findViewById(R.id.id_tab_message);
		contactsLayout = this.findViewById(R.id.id_tab_contacts);
		newsLayout = this.findViewById(R.id.id_tab_news);
		settingLayout = this.findViewById(R.id.id_tab_setting);
		messageImage = (ImageView) this.findViewById(R.id.id_message_image);
		contactsImage = (ImageView) this.findViewById(R.id.id_contacts_image);
		newsImage = (ImageView) this.findViewById(R.id.id_news_image);
		settingImage = (ImageView) this.findViewById(R.id.id_setting_image);
		messageText = (TextView) this.findViewById(R.id.id_message_text);
		contactsText = (TextView) this.findViewById(R.id.id_contacts_text);
		newsText = (TextView) this.findViewById(R.id.id_news_text);
		settingText = (TextView) this.findViewById(R.id.id_setting_text);
		messageLayout.setOnClickListener(this);
		contactsLayout.setOnClickListener(this);
		newsLayout.setOnClickListener(this);
		settingLayout.setOnClickListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_tab_message:
			setTabSelection(0);
			break;
		case R.id.id_tab_contacts:
			setTabSelection(1);
			break;

		case R.id.id_tab_news:
			setTabSelection(2);
			break;
		case R.id.id_tab_setting:
			setTabSelection(3);
			break;

		default:
			break;
		}
	}

	/**
	 * @param index
	 *            ����indexֵ��������ʾ��ҳ��
	 */
	private void setTabSelection(int index) {
		clearSelection(); // ÿ��ѡ��֮ǰ����ϴε�ѡ��״̬
		FragmentTransaction transaction = fragmentManager.beginTransaction();  //����һ��Fragment����
		hideFragments(transaction);  //�������е�Fragment���Է����Fragment��ʾ�ڽ�����
		switch (index) {
		case 0:
			messageImage.setImageResource(R.drawable.message_selected);
			messageText.setTextColor(Color.WHITE);
			if (messageFragment == null) {
				messageFragment = new MessageFragment();  //�����ǰFragmentΪ�գ��򴴽�һ������ӵ�������
				transaction.add(R.id.id_display_content, messageFragment);
			} else {
				transaction.show(messageFragment);  //�����ǰFragment��Ϊ�գ���ֱ�ӽ�����ʾ����
			}
			break;
		case 1:
			contactsImage.setImageResource(R.drawable.contacts_selected);
			contactsText.setTextColor(Color.WHITE);
			if (contactsFragment == null) {
				contactsFragment = new ContactsFragment();
				transaction.add(R.id.id_display_content, contactsFragment);
			} else {
				transaction.show(contactsFragment);
			}
			break;
		case 2:
			newsImage.setImageResource(R.drawable.news_selected);
			newsText.setTextColor(Color.WHITE);
			if (newsFragment == null) {
				newsFragment = new NewsFragment();
				transaction.add(R.id.id_display_content, newsFragment);
			} else {
				transaction.show(newsFragment);
			}
			break;
		case 3:
			settingImage.setImageResource(R.drawable.setting_selected);
			settingText.setTextColor(Color.WHITE);
			if (settingFragment == null) {
				settingFragment = new SettingFragment();
				transaction.add(R.id.id_display_content, settingFragment);
			} else {
				transaction.show(settingFragment);
			}
			break;
		}
		transaction.commit();
	}

	/**
	 * ��������е�ѡ��״̬��
	 */
	private void clearSelection() {
		messageImage.setImageResource(R.drawable.message_unselected);
		messageText.setTextColor(Color.parseColor("#82858b"));
		contactsImage.setImageResource(R.drawable.contacts_unselected);
		contactsText.setTextColor(Color.parseColor("#82858b"));
		newsImage.setImageResource(R.drawable.news_unselected);
		newsText.setTextColor(Color.parseColor("#82858b"));
		settingImage.setImageResource(R.drawable.setting_unselected);
		settingText.setTextColor(Color.parseColor("#82858b"));
	}

	/**
	 * �����е�Fragment����Ϊ����״̬��
	 * 
	 * @param transaction
	 *            ���ڶ�Fragmentִ�в���������
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (messageFragment != null) {
			transaction.hide(messageFragment);
		}
		if (contactsFragment != null) {
			transaction.hide(contactsFragment);
		}
		if (newsFragment != null) {
			transaction.hide(newsFragment);
		}
		if (settingFragment != null) {
			transaction.hide(settingFragment);
		}
	}
}
