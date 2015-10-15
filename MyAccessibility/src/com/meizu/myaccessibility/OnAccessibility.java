package com.meizu.myaccessibility;

import java.util.List;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class OnAccessibility extends AccessibilityService {

	private int redNumber = 0;

	// com.tencent.mm:id/wm 领取红包
	// com.tencent.mm:id/aww 拆红包
	// com.tencent.mm:id/f5 (个人获取红包详情界面，返回上一级箭头按钮)
	// com.tencent.mm:id/awr (红包已被领取，返回上一级交叉按钮)

	@Override
	public void onAccessibilityEvent(AccessibilityEvent event) {
		// TODO Auto-generated method stub
		int eventType = event.getEventType();
		// eventType == AccessibilityEvent.TYPE_VIEW_CLICKED ||eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
		if (eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED || eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
			AccessibilityNodeInfo nodeInfo = event.getSource(); // 得到的是被点击的单体对象
			if (nodeInfo != null) {
				processOnAyEvent();
			}
		}
	}

	private void processOnAyEvent() {
		AccessibilityNodeInfo nodeInfo = getRootInActiveWindow(); // 得到整个窗口，可以遍历得到所有子节点
		Log.e("getRootInActiveWindow()", "" + nodeInfo);
		String[] keywords = { "我知道了", "确定", "允许", "不同意", "android:id/button1" };//
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

	private boolean getRedPackage(String keyword) {
		AccessibilityNodeInfo nodeInfo = getRootInActiveWindow(); // 得到整个窗口，可以遍历得到所有子节点
		Log.e("keyword", "当前点击：" + keyword);
		if (nodeInfo != null) {
			Log.e("nodeInfo != null", "nodeInfo不为空");
			List<AccessibilityNodeInfo> setNode = null;
			int num = 0;
			while ((setNode == null || setNode.size() == 0) && num < 1000) {
				num++;
				if (keyword.contains("id"))
					setNode = nodeInfo.findAccessibilityNodeInfosByViewId(keyword);
				else
					setNode = nodeInfo.findAccessibilityNodeInfosByText(keyword);
			}
			Log.e("setNode", "setNode大小：" + setNode.size());
			if (keyword.equals("领取红包") && redNumber != setNode.size()) {
				Log.e("redNumber原值为：", "" + redNumber);
				redNumber = setNode.size();
				Log.e("redNumber != setNode.size()", "" + (redNumber != setNode.size()) + "===redNumber size:" + redNumber + "===setNode.size:" + setNode.size());
			} else if (keyword.equals("领取红包")) {
				Log.e("领取红包返回值：", "false");
				return false;
			}
			if (!setNode.isEmpty()) {
				Log.e("!setNode.isEmpty()", "setNode不为空");
				AccessibilityNodeInfo cellNode = setNode.get(setNode.size() - 1);
				if (cellNode.isVisibleToUser())
					if (cellNode.isClickable()) {
						cellNode.performAction(AccessibilityNodeInfo.ACTION_CLICK);
					} else {
						cellNode.getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
					}
			}
		}
		return true;
	}

	@Override
	public void onInterrupt() {
		// TODO Auto-generated method stub

	}
}
