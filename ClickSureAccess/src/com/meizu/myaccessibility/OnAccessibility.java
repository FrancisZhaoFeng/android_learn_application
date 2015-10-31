package com.meizu.myaccessibility;

import java.util.List;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class OnAccessibility extends AccessibilityService {

	private int redNumber = 0;

	// com.tencent.mm:id/wm ��ȡ���
	// com.tencent.mm:id/aww ����
	// com.tencent.mm:id/f5 (���˻�ȡ���������棬������һ����ͷ��ť)
	// com.tencent.mm:id/awr (����ѱ���ȡ��������һ�����水ť)

	@Override
	public void onAccessibilityEvent(AccessibilityEvent event) {
		// TODO Auto-generated method stub
		int eventType = event.getEventType();
		// eventType == AccessibilityEvent.TYPE_VIEW_CLICKED ||eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
		if (eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED || eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
			AccessibilityNodeInfo nodeInfo = event.getSource(); // �õ����Ǳ�����ĵ������
			if (nodeInfo != null) {
				processOnAyEvent();
			}
		}
	}

	private void processOnAyEvent() {
		AccessibilityNodeInfo nodeInfo = getRootInActiveWindow(); // �õ��������ڣ����Ա����õ������ӽڵ�
		Log.e("getRootInActiveWindow()", "" + nodeInfo);
		String[] keywords = { "��֪����", "ȷ��", "����", "��ͬ��", "android:id/button1" };//
		if (nodeInfo != null) {
			for (String keyword : keywords) {
				List<AccessibilityNodeInfo> setNode;
				if (keyword.contains("id"))
					setNode = nodeInfo.findAccessibilityNodeInfosByViewId(keyword);
				else
					setNode = nodeInfo.findAccessibilityNodeInfosByText(keyword);
				Log.e("setNode", "size:" + setNode.size() + "===" + setNode);
				if (!setNode.isEmpty()) {
					for (AccessibilityNodeInfo cellNode : setNode) {
						Log.e("cellNode.canOpenPopup()", "" + cellNode.canOpenPopup());
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
