//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.meizu.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

import com.meizu.common.Constant;

import java.util.Iterator;
import java.util.List;

public class ConnectWifiUtil {
    private static final String TAG = ConnectWifiUtil.class.getSimpleName();
    private WifiManager mWifiManager;
    private Context mContext;

    public ConnectWifiUtil(Context context) {
        this.mContext = context;
        this.mWifiManager = (WifiManager) this.mContext.getSystemService(Context.WIFI_SERVICE);
    }

    private WifiConfiguration isExsits(String SSID) {
        List existingConfigs = this.mWifiManager.getConfiguredNetworks();

        try {
            Iterator var4 = existingConfigs.iterator();

            while (var4.hasNext()) {
                WifiConfiguration existingConfig = (WifiConfiguration) var4.next();
                if (existingConfig.SSID.equals("\"" + SSID + "\"")) {
                    return existingConfig;
                }
            }
        } catch (Exception var5) {
            ;
        }

        return null;
    }

    private WifiConfiguration createWifiInfo(String SSID, String emailAds, String pwd, ConnectWifiUtil.WifiCipherType type) {
        WifiConfiguration config = new WifiConfiguration();
        config.allowedAuthAlgorithms.clear();
        config.allowedGroupCiphers.clear();
        config.allowedKeyManagement.clear();
        config.allowedPairwiseCiphers.clear();
        config.allowedProtocols.clear();
        config.SSID = "\"" + SSID + "\"";
        if (type == ConnectWifiUtil.WifiCipherType.WIFICIPHER_NOPASS) {
            config.wepKeys[0] = "\"\"";
            config.allowedKeyManagement.set(0);
            config.wepTxKeyIndex = 0;
        } else if (type == ConnectWifiUtil.WifiCipherType.WIFICIPHER_WEP) {
            if (!TextUtils.isEmpty(pwd)) {
                if (isHexWepKey(pwd)) {
                    config.wepKeys[0] = pwd;
                } else {
                    config.wepKeys[0] = "\"" + pwd + "\"";
                }
            }

            config.allowedAuthAlgorithms.set(0);
            config.allowedAuthAlgorithms.set(1);
            config.allowedKeyManagement.set(0);
            config.wepTxKeyIndex = 0;
        } else if (type == ConnectWifiUtil.WifiCipherType.WIFICIPHER_WPA) {
            config.preSharedKey = "\"" + pwd + "\"";
            config.hiddenSSID = true;
            config.allowedAuthAlgorithms.set(0);
            config.allowedGroupCiphers.set(2);
            config.allowedKeyManagement.set(1);
            config.allowedPairwiseCiphers.set(1);
            config.allowedGroupCiphers.set(3);
            config.allowedPairwiseCiphers.set(2);
            config.status = 2;
        } else if (type == ConnectWifiUtil.WifiCipherType.WIFICIPHER_WPA_EAP) {
            config.allowedKeyManagement.set(2);
            config.allowedKeyManagement.set(3);
            config.enterpriseConfig = new WifiEnterpriseConfig();
            config.enterpriseConfig.setEapMethod(0);
            config.enterpriseConfig.setPhase2Method(3);
            config.enterpriseConfig.setIdentity(emailAds);
            config.enterpriseConfig.setPassword(pwd);
        }

        return config;
    }

    private static boolean isHexWepKey(String wepKey) {
        int len = wepKey.length();
        return len != 10 && len != 26 && len != 58 ? false : isHex(wepKey);
    }

    private static boolean isHex(String key) {
        for (int i = key.length() - 1; i >= 0; --i) {
            char c = key.charAt(i);
            if ((c < 48 || c > 57) && (c < 65 || c > 70) && (c < 97 || c > 102)) {
                return false;
            }
        }

        return true;
    }

    public void connectWifi(String ssid, String email_address, String password, ConnectWifiUtil.WifiCipherType type) {
        Thread thread = new Thread(new ConnectWifiUtil.ConnectRunnable(ssid, email_address, password, type));
        thread.start();
        if (!this.mWifiManager.isWifiEnabled()) {
            SystemClock.sleep(500L);
        }

    }

    protected boolean openWifi(boolean open) {
        boolean bRet = true;
        if (this.mWifiManager.isWifiEnabled() != open) {
            bRet = this.mWifiManager.setWifiEnabled(open);
        }

        return bRet;
    }

    public void connectOnlyOneWifi(String ssid, String email, String emailPwd, ConnectWifiUtil.WifiCipherType type) {
        synchronized (ConnectWifiUtil.class) {
            Log.i(Constant.TAG, "connectOnlyOneWifi开始");
            if (this.checkWifi()) {
                return;
            }
            this.removeAP();
            this.connectWifi(ssid, email, emailPwd, type);
            long startTimeMillis = System.currentTimeMillis();

            while (System.currentTimeMillis() - startTimeMillis < 15 * 1000 && !this.checkWifi()) {
                SystemClock.sleep(500);
            }
            Log.i(Constant.TAG, "connectOnlyOneWifi结束");
        }
    }

    protected boolean checkWifi() {
        ConnectivityManager connManager = (ConnectivityManager) this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(1);
        return mWifi.isConnected();
    }

    protected void removeAP() {
        this.mWifiManager.startScan();
        List mWifiConfiguration = this.mWifiManager.getConfiguredNetworks();
        if (mWifiConfiguration == null) return;
        try {
            for (int e = 0; e < mWifiConfiguration.size(); ++e) {
                this.mWifiManager.removeNetwork(((WifiConfiguration) mWifiConfiguration.get(e)).networkId);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    protected String getWifiState() {
        WifiManager wifi_service = (WifiManager) this.mContext.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifi_service.getConnectionInfo();
        String type = "";
        int n = wifiInfo.getRssi();
        if (n <= 0 && n >= -50) {
            type = "良好";
        } else if (n < -50 && n > -70) {
            type = "偏差";
        } else if (n <= -70) {
            type = "很差";
        }

        return "当前网络连接情况" + type;
    }

    class ConnectRunnable implements Runnable {
        private String ssid;
        private String email_address;
        private String password;
        private ConnectWifiUtil.WifiCipherType type;

        public ConnectRunnable(String ssid, String email_address, String password, ConnectWifiUtil.WifiCipherType type) {
            this.ssid = ssid;
            this.password = password;
            this.type = type;
            this.email_address = email_address;
        }

        public void run() {
            ConnectWifiUtil.this.openWifi(true);

            while (ConnectWifiUtil.this.mWifiManager.getWifiState() == 2) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException var6) {
                    ;
                }
            }

            WifiConfiguration wifiConfig = ConnectWifiUtil.this.createWifiInfo(this.ssid, this.email_address, this.password, this.type);
            if (wifiConfig == null) {
                Log.d(ConnectWifiUtil.TAG, "wifiConfig is null!");
            } else {
                WifiConfiguration tempConfig = ConnectWifiUtil.this.isExsits(this.ssid);
                if (tempConfig != null) {
                    ConnectWifiUtil.this.mWifiManager.removeNetwork(tempConfig.networkId);
                }

                int netID = ConnectWifiUtil.this.mWifiManager.addNetwork(wifiConfig);
                boolean enabled = ConnectWifiUtil.this.mWifiManager.enableNetwork(netID, true);
                Log.d(ConnectWifiUtil.TAG, "enableNetwork status enable=" + enabled);
                boolean connected = ConnectWifiUtil.this.mWifiManager.reconnect();
                Log.d(ConnectWifiUtil.TAG, "enableNetwork connected=" + connected);
            }
        }
    }

    public static enum WifiCipherType {
        WIFICIPHER_WEP,
        WIFICIPHER_WPA,
        WIFICIPHER_WPA2,
        WIFICIPHER_NOPASS,
        WIFICIPHER_INVALID,
        WIFICIPHER_WPA_EAP;

        private WifiCipherType() {
        }
    }
}
