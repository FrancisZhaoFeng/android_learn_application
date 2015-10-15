package com.meizu.luckymoney;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/**
 * 监听解锁等事件，启动服务
 * @author Young
 *
 */
public class Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		context.startService(new Intent(context, HookService.class));
	}

}
