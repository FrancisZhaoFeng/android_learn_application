package com.meizu.apptest.service;

import android.accessibilityservice.AccessibilityService;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

public class OnAccessibilityService extends AccessibilityService {


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

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void processOnAyEvent() {
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow(); // 得到整个窗口，可以遍历得到所有子节点
        String[] keywords = {"确定", "android:id/button1", "com.android.vending:id/positive_button"};//
        if (nodeInfo != null) {
            for (String keyword : keywords) {
                List<AccessibilityNodeInfo> setNode;
                if (keyword.contains("id"))
                    setNode = nodeInfo.findAccessibilityNodeInfosByViewId(keyword);
                else
                    setNode = nodeInfo.findAccessibilityNodeInfosByText(keyword);
                if (!setNode.isEmpty()) {
                    for (AccessibilityNodeInfo cellNode : setNode) {
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
