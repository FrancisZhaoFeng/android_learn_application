package com.meizu.apptest.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.meizu.apptest.common.Constant;
import com.meizu.apptest.utils.ConnectWifiUtil;


public class ConnectivityReceiver extends BroadcastReceiver {
    public static boolean wifiStatus = false;
    private NetworkInfo.State state;
    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;
    private ConnectWifiUtil connectWifiUtil;

    @Override
    public void onReceive(Context context, Intent intent) {
        connectWifiUtil = new ConnectWifiUtil(context);
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                state = networkInfo.getState();
                if (state == NetworkInfo.State.CONNECTED) {
                    wifiStatus = true;
                    Log.i(Constant.TAG, "已连接网络");
                } else if (state == NetworkInfo.State.DISCONNECTING || state == NetworkInfo.State.DISCONNECTED) {//网络断开
                    wifiStatus = false;
                }
            } else {//运营商网络
                wifiStatus = false;
            }
        } else {
            wifiStatus = false;
        }
        if (!wifiStatus) {
            threadCon.start();
            Log.i(Constant.TAG, "wifi正在连接");
        }
    }

    Thread threadCon = new Thread(new Runnable() {
        @Override
        public void run() {
            connectWifiUtil.connectOnlyOneWifi("MZ-MEIZU-5G", "atsms", "autotest123@123", ConnectWifiUtil.WifiCipherType.WIFICIPHER_WPA_EAP);
        }
    });
}
