package com.meizu.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.meizu.common.Contants;
import com.meizu.domain.AppMemMapInfo;
import com.meizu.domain.UserHabitInfo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static String TAG = "DBManager";
    private DBHelper dbHelper;
    private static SQLiteDatabase db;
    /*--保存数据库语句--*/
    private String insertSql;
    private String selectSql;
    private String deleteSql;
    private List<Object> mObjs = null;
    private static DBManager dbManager = null;

//    public DBManager(Context context) {
//        // TODO Auto-generated constructor stub
//        dbHelper = new DBHelper(context);
//        db = dbHelper.getWritableDatabase();
//    }

    public static DBManager getInstance(Context context) {
        db = DBHelper.getInstance(context);
        if (dbManager == null) {
            Log.i(TAG, "getInstance: DBManager 是 null");
            dbManager = new DBManager();
        } else {
            Log.i(TAG, "getInstance: DBManager 不是 null");
        }
        return dbManager;
    }

    public void insertAppMemInfo(AppMemMapInfo appMemMapInfo) {
        db.beginTransaction();
        try {
            insertSql = "insert into appMemInfo values(null,?,?)";
            Log.i(TAG, "插入数据库信息：" + appMemMapInfo.toString());
            saveObject(insertSql, appMemMapInfo.getPackageName(), appMemMapInfo);
            db.setTransactionSuccessful();
        } finally {
            // TODO: handle exception
            db.endTransaction();
        }
    }

    public int selectAppMemInfo(String packageName, List<AppMemMapInfo> appMemMapInfos) {
        db.beginTransaction();
        try {
            selectSql = "select * from appMemInfo";
            Log.i(TAG, "查询数据库语句：" + selectSql);
            mObjs = getObject(selectSql);
            db.setTransactionSuccessful();
        } finally {
            // TODO: handle exception
            db.endTransaction();
        }
        AppMemMapInfo appMemMapInfo;
        for (int i = 0; mObjs != null && i < mObjs.size(); i++) {
            appMemMapInfo = (AppMemMapInfo) mObjs.get(i);
            if (packageName.equals("*")) {
                appMemMapInfos.add(appMemMapInfo);
            } else if (packageName.equals(appMemMapInfo.getPackageName())) {
                appMemMapInfos.add(appMemMapInfo);
            }
        }
        if (mObjs != null)
            Log.i(TAG, "数据库共包含数据条数：" + mObjs.size() + ", " + packageName + "包含数据条数：" + appMemMapInfos.size());
        return mObjs != null ? mObjs.size() : 0;
    }

    public boolean setDeleteSql(String tName, boolean isCheck) {
        db.beginTransaction();
        try {
            deleteSql = "delete from " + tName;
            Log.i(TAG, "删除数据语句：" + deleteSql);
            db.execSQL(deleteSql);
            db.setTransactionSuccessful();
        } finally {
            // TODO: handle exception
            db.endTransaction();
        }
        return isCheck && selectAppMemInfoGetSize() == 0 ? true : false;
    }

    public int selectAppMemInfoGetSize() {
        List<AppMemMapInfo> appMemMapInfos = new ArrayList<>();
        selectAppMemInfo("*", appMemMapInfos);
        for (AppMemMapInfo appMemMapInfo : appMemMapInfos) {
            Log.i(TAG, "selectAppMemInfoGetSize(),数据库内容：" + appMemMapInfo.toString());
        }
        return appMemMapInfos.size();
    }

    public void insertUserHabitInfo(UserHabitInfo userHabitInfo) {
        db.beginTransaction();
        try {
            insertSql = "insert into " + Contants.TABLE_NAME_USER + " values(null,?)";
            setDeleteSql(Contants.TABLE_NAME_USER, false);
            Log.i(TAG, "insertUserHabitInfo(),插入数据库信息：" + userHabitInfo.toString());
            saveObject(insertSql, "", userHabitInfo);
            db.setTransactionSuccessful();
        } finally {
            // TODO: handle exception
            db.endTransaction();
        }
    }

    public UserHabitInfo selectUserHabitInfo() {
        db.beginTransaction();
        try {
            selectSql = "select * from " + Contants.TABLE_NAME_USER;
            Log.i(TAG, "selectUserHabitInfo()，查询数据库语句：" + selectSql);
            mObjs = getObject(selectSql);
            db.setTransactionSuccessful();
        } finally {
            // TODO: handle exception
            db.endTransaction();
        }
        UserHabitInfo userHabitInfo = null;
        if (mObjs != null && 0 < mObjs.size()) {
            userHabitInfo = (UserHabitInfo) mObjs.get(0);
        }

        return userHabitInfo;
    }

    /**
     * @param sql
     * @param obj 实体类以对象方式存储在数据库中
     */
    public void saveObject(String sql, String packageName, Object obj) {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            byte data[] = arrayOutputStream.toByteArray();
            objectOutputStream.close();
            arrayOutputStream.close();
            Object[] objects;
            if (packageName.equals(""))
                objects = new Object[]{data};
            else
                objects = new Object[]{packageName, data};
            db.execSQL(sql, objects);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @param sql
     * @return 从数据库中获取实体类对象
     */
    public List<Object> getObject(String sql) {
        List<Object> objs = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                byte data[] = cursor.getBlob(cursor.getColumnIndex("classTableData")); // classtabledata 是实体类对象
                ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(data);
                try {
                    ObjectInputStream inputStream = new ObjectInputStream(arrayInputStream);
                    Object obj = inputStream.readObject();
                    objs.add(obj);
                    inputStream.close();
                    arrayInputStream.close();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return objs;
    }

    public void close(String call) {
        if (db != null) {
            db.close();
            Log.i(TAG, "close: " + call + "调用数据库close");
        }
    }
}
