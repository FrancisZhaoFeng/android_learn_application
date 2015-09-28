package com.meizu.myaccessibility;

import java.util.List;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class OnAccessibility extends AccessibilityService {

	@Override
	public void onAccessibilityEvent(AccessibilityEvent event) {
		// TODO Auto-generated method stub
		Log.e("�����б仯", "����=======>�б仯");
		int evenType = event.getEventType();
		if (evenType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED || evenType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
			AccessibilityNodeInfo nodeInfo = event.getSource();
			if (nodeInfo != null)
				processOnAyEvent();
		}
	}

	private void processOnAyEvent() {
		AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
		String[] keywords = { "ȷ��", "����","ȡ��","�˳�","��ͬ��","�ܾ�","����","����","Flyme����","android:id/button1" };
		if (nodeInfo != null) {
			for (String keyword : keywords) {
				List<AccessibilityNodeInfo> setNode;
				if (keyword.contains("id"))
					setNode = nodeInfo.findAccessibilityNodeInfosByViewId(keyword);
				else
					setNode = nodeInfo.findAccessibilityNodeInfosByText(keyword);
				if (!setNode.isEmpty()) {
					Log.e("setNode.size", "" + setNode.size());
					for (int i = 0; i < setNode.size(); i++) {
						AccessibilityNodeInfo cellNode = setNode.get(i);
						if (cellNode.isVisibleToUser())
							if (cellNode.isClickable()) {
								cellNode.performAction(AccessibilityNodeInfo.ACTION_CLICK);
							} else {
								cellNode.getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
							}
					}
					return;
				}
			}
		}
	}

	@Override
	public void onInterrupt() {
		// TODO Auto-generated method stub

	}
}
