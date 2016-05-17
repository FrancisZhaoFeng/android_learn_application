package com.meizu.apptest.activity;

import android.database.sqlite.SQLiteDatabase;

import org.litepal.tablemanager.Connector;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

/**
 * Created by zhaoguofeng on 2016/5/4.
 */
@Implements(Connector.class)
public class ShadowConnector {
    public static boolean flag = false;

    @Implementation
    public static SQLiteDatabase getDatabase() {
        flag = true;
        return null;
    }
}
