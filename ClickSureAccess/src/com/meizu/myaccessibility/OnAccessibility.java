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
		int eventType = event.getEventType();
		if (eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED || eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
			AccessibilityNodeInfo nodeInfo = event.getSource(); // 得到的是被点击的单体对象
			if (nodeInfo != null) {
				processOnAyEvent();
			}
		}
	}

	private void processOnAyEvent() {
		AccessibilityNodeInfo nodeInfo = getRootInActiveWindow(); // 得到整个窗口，可以遍历得到所有子节点
		String[] keywords = { "确定", "android:id/button1", "允许", "不同意", "我知道了" };// ,
		if (nodeInfo != null) {
			for (String keyword : keywords) {
				List<AccessibilityNodeInfo> setNode;
				if (keyword.contains("id"))
					setNode = nodeInfo.findAccessibilityNodeInfosByViewId(keyword);
				else
					setNode = nodeInfo.findAccessibilityNodeInfosByText(keyword);
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
