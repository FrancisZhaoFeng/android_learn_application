package com.meizu.luckymoney;

import java.util.List;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

@SuppressLint("NewApi")
public class HookService extends AccessibilityService {

	/**
	 * 当通知栏改变或界面改变时会触发该方法 下面内容可以借助 Dump View Hierarchy For UI Automator 去分析微信UI结构 com.tencent.mm.ui.LauncherUI 聊天界面
	 * com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI 拆红包界面 com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI 红包领取详情界面
	 */
	@Override
	public void onAccessibilityEvent(AccessibilityEvent event) {
		final int eventType = event.getEventType();
		if (eventType == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED) {
			List<CharSequence> texts = event.getText();
			for (CharSequence t : texts) {
				if (t.toString().contains("[微信红包]")) {// 获取通知栏字符，若包含 [微信红包]
					wakeUpAndUnlock(); // 判断黑屏后自动亮屏
					handleNotificationChange(event);// 通知栏时间
					break;
				}
			}
		} else if (eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
			Log.e("event.getEventType()", "STATE-32");
			openHongBao(event);
		}
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	private void openHongBao(AccessibilityEvent event) {
		if ("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI".equals(event.getClassName())) {
			// 点击拆红包
			checkKey1();
		} else if ("com.tencent.mm.ui.LauncherUI".equals(event.getClassName())) {
			// 微信界面点击领取红包
			checkKey2();
		} else if ("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI".equals(event.getClassName())) {
			// 拆完红包后看详细的纪录界面
			// noting
			// Intent intent = new Intent(HookService.this, MainActivity.class);
			// intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			// startActivity(intent);
		}
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	private boolean checkKey2() {
		AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
		if (nodeInfo == null) {
			return false;
		}
		List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("领取红包"); // 找到聊天界面中包含 领取红包
		if (list.isEmpty()) {
			list = nodeInfo.findAccessibilityNodeInfosByText("[微信红包]");
			for (AccessibilityNodeInfo n : list) {
				n.performAction(AccessibilityNodeInfo.ACTION_CLICK);
				break;
			}
		} else {
			// 最新的红包领起
			for (int i = list.size() - 1; i >= 0; i--) {
				AccessibilityNodeInfo parent = list.get(i).getParent();
				try {
					parent.performAction(AccessibilityNodeInfo.ACTION_CLICK);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	private boolean checkKey1() {
		AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
		if (nodeInfo == null) {
			return false;
		}
		List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("拆红包"); // 获取包含 拆红包
		for (AccessibilityNodeInfo n : list) {
			n.performAction(AccessibilityNodeInfo.ACTION_CLICK);
		}
		return true;
	}

	public void handleNotificationChange(AccessibilityEvent event) {
		try {
			Notification notification = (Notification) event.getParcelableData();
			PendingIntent pendingIntent = notification.contentIntent;
			pendingIntent.send(); // 点击通知栏消息
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onInterrupt() {
		// TODO Auto-generated method stub

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, START_STICKY, startId);
	}

	public void wakeUpAndUnlock() {// Context context
		Log.e("DIANJI", "dianlianglianliangliangliang");
		// 声明键盘管理器,获取系统服务
		KeyguardManager km = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
		KeyguardManager.KeyguardLock kl = km.newKeyguardLock("unLock");
		// 解锁
		kl.disableKeyguard();
		// 获取电源管理器对象
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		// 获取PowerManager.WakeLock对象,后面的参数|表示同时传入两个值,最后的是LogCat里用的Tag
		PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK, "bright");
		// 点亮屏幕
		wl.acquire();
		// 释放
		wl.release();
	}
}