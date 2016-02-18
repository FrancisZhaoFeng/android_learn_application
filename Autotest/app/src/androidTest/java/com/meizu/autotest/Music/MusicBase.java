package com.meizu.autotest.Music;

import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.util.Log;

import org.junit.Before;

import java.io.File;
import java.util.List;

import constant.NewConstants.MusicFlyme5;
import tools.UserApi;

public class MusicBase extends UserApi {
    Instrumentation mInstrumentation;
    UiDevice mUiDevice;
    static String TAG = "MusicBase";
    static String musicPkg = "com.meizu.media.music";
    static String lanchPkg = "com.meizu.flyme.launcher";
    UiObject2 uiObjectb;
    List<UiObject2> listUiObjectb;
    int INDEX = 0;
    long WAITTIME = 2 * 1000;
    int LONGCLICKTIME = 2000;

    @Before
    public void setUp() {
        mInstrumentation = InstrumentationRegistry.getInstrumentation();
        mUiDevice = UiDevice.getInstance(mInstrumentation);
        super.setUp(mInstrumentation, mUiDevice);
    }

    protected boolean waitForPlay(int times) {
        // TODO Auto-generated method stub
        boolean result = false;
        long startTimes = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTimes) <= times) {
            if (super.isPlaying()) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @param common
     */
    void copySource(boolean common) {
        adbshell("rm -rf " + MusicFlyme5.MUSIC_MD_MUSIC + "*");
        adbshell("cp -r " + MusicFlyme5.MUSIC_MD_RES + "music/* " + MusicFlyme5.MUSIC_MD_MUSIC);
        adbshell("am broadcast -a android.intent.action.MEDIA_SCANNER_SCAN_FILE -d file://" + MusicFlyme5.MUSIC_MD_MUSIC);
        if (!(new File(MusicFlyme5.MUSIC_SD_MUSIC).exists())) {
            adbshell("rm -rf " + MusicFlyme5.MUSIC_SD_MUSIC + "*");
            adbshell("am broadcast -a android.intent.action.MEDIA_SCANNER_SCAN_FILE -d file://" + MusicFlyme5.MUSIC_SD_MUSIC);
        }
        if (common) {
            adbshell("rm -rf " + MusicFlyme5.MUSIC_MD + "AutoTest/res/common3/*");
            adbshell("cp -r " + MusicFlyme5.MUSIC_MD_RES + "music/song1.mp3 " + MusicFlyme5.MUSIC_MD + "AutoTest/res/common3");
            adbshell("am broadcast -a android.intent.action.MEDIA_SCANNER_SCAN_FILE -d file://" + MusicFlyme5.MUSIC_MD + "AutoTest/res/common3");
        }
    }

    protected int speed(boolean midle) {
        List<String> xy;
        if (waitForIdVisible("com.meizu.media.music:id/progress_bar", INDEX, 2 * 1000)) {
            xy = getItemVal("com.meizu.media.music:id/progress_bar", INDEX, true, "xy");
        } else {
            return 1000;
        }
        if (midle) {
            dragTo(mathX(265), Integer.valueOf(xy.get(1)), mathX(600), Integer.valueOf(xy.get(1)), 1000); // 快进快退拖动
            waitForPlay(30 * 1000);
            dragTo(mathX(550), Integer.valueOf(xy.get(1)), mathX(1100), Integer.valueOf(xy.get(1)), 1000); // 快进快退拖动
        }
        return Integer.valueOf(xy.get(1));
    }

    void goBackDesktop() {
        for (int i = 0; i < 8; i++) {
            if (!mUiDevice.getCurrentPackageName().equals(lanchPkg))
                mUiDevice.pressBack();
            else
                break;

        }
    }


    public int getContentNumber(String content) {
        List<UiObject2> listUiObject = getIdOrTextObject(content, WAITTIME);
        if (listUiObject != null) {
            return listUiObject.size();
        } else {
            Log.e(TAG, "getContentNumber listUiObject is null");
            return 0;
        }
    }

    private void startActi(String ActivityName) {
        String splitName[];
        if (ActivityName.contains("/.")) {
            splitName = ActivityName.split("/.");
            splitName[1] = splitName[0] + "." + splitName[1];
        } else {
            splitName = ActivityName.split("/");
        }
        Intent intent = new Intent();
        ComponentName com = new ComponentName(splitName[0], splitName[1]);
        intent.setComponent(com);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mInstrumentation.getContext().startActivity(intent);
    }

    public void startMusic() {
        mUiDevice.pressHome();
        waitForTouch("音乐", INDEX, WAITTIME, false);
    }

    void intoApp(boolean account) {
        goBackDesktop();
//        startActi(NewConstants.Activity.MUSIC);
        startMusic();
        if (account) {
            waitForTouch(MusicFlyme5.TEXT_WODEYINYUE, INDEX, WAITTIME, false);
        }
    }

    void deleteMusicMenu() {
        intoApp(true);
        List<UiObject2> listUiObject = getIdOrTextObject(MusicFlyme5.ID_COVER, WAITTIME);
        if (listUiObject != null && listUiObject.size() > 1) {
            longClick(listUiObject.get(1), LONGCLICKTIME);
            waitForTouch(MusicFlyme5.TEXT_QUANXUAN, INDEX, 500, false);
            waitForTouch(MusicFlyme5.ID_ACTION_DELETE_PLAYLIST, INDEX, WAITTIME, false);
            waitForTouch("删除所选内容", INDEX, WAITTIME, false);
            waitForTouch(MusicFlyme5.ID_ANDROID_BUTTON1, INDEX, WAITTIME, false);
        }
    }


    void ready() {
        intoApp(true);
        recover();
    }

    void recover() {
        deleteMusicMenu();
        waitForTouchText("我的最爱", INDEX, WAITTIME, 0);
        if (waitForTouchId(MusicFlyme5.ID_CONTENT_CONTAINER, INDEX, 1000, 1000)) {
            waitForTouchText(MusicFlyme5.TEXT_QUANXUAN, INDEX, 500, 0);
            waitForTouchId(MusicFlyme5.ID_ACTION_DELETE_FROM_PLAYLIST, INDEX, 1000, 0);
            waitForTouchId(MusicFlyme5.ID_ANDROID_TEXT1, INDEX, 2 * 1000, 0);
        }
        sleep(1000);
        intoApp(true);
        if (new File(MusicFlyme5.MUSIC_SD_MUSIC).exists()) {
            waitForTouchId(MusicFlyme5.ID_ACTION_MORE, INDEX, 5 * 1000, 0);
            UiObject2 uiObject = getIdOrTextObject(MusicFlyme5.ID_SDCARD_SWITCH, WAITTIME, INDEX);
            if (uiObject.isChecked()) {
                uiObject.click();
            }
        }
    }

    protected void intoOnlineMusic(String strPath, int num) {
        goBackDesktop();
        intoApp(false);
        switch (strPath) {
            case MusicFlyme5.TEXT_ZHUANTI: {
                waitForTouchText(MusicFlyme5.TEXT_ZHUANTI, INDEX, 10 * 1000, 0);
                if (!searchIdByIndex(MusicFlyme5.ID_COVER, INDEX, true))
                    waitForTouchText(MusicFlyme5.TEXT_ZHUANTI, INDEX, 5 * 1000, 0);
                waitForTouchId(MusicFlyme5.ID_COVER, INDEX, 10 * 1000, 0);
                if (num > 0 && !waitForIdVisible(MusicFlyme5.ID_BUTTON_PLAYER, INDEX, 10 * 1000)) {
                    intoOnlineMusic(MusicFlyme5.TEXT_ZHUANTI, --num);
                }
                break;
            }
            case MusicFlyme5.TEXT_ZHUANJI: {
                dragTo(mathX(500), mathY(1000), mathX(500), mathY(800), 500);
                waitForTouchId(MusicFlyme5.ID_NAME, 5, 5 * 1000, 0);
                if (num > 0 && !waitForIdVisible(MusicFlyme5.ID_BUTTON_PLAYER, INDEX, 10 * 1000)) {
                    intoOnlineMusic(MusicFlyme5.TEXT_ZHUANJI, --num);
                }
                break;
            }
            case MusicFlyme5.TEXT_ZUIXINFAHANG: {
                waitForTouchText(MusicFlyme5.TEXT_ZUIXINFAHANG, INDEX, 10 * 1000, 0);
                if (!searchIdByIndex("com.meizu.media.music:id/name", INDEX, true))
                    waitForTouchText(MusicFlyme5.TEXT_ZUIXINFAHANG, INDEX, 5 * 1000, 0);
                waitForTouchId("com.meizu.media.music:id/name", INDEX, 10 * 1000, 0);
                if (num > 0 && !waitForIdVisible(MusicFlyme5.ID_BUTTON_PLAYER, INDEX, 10 * 1000)) {
                    intoOnlineMusic(MusicFlyme5.TEXT_ZUIXINFAHANG, --num);
                }
                break;
            }
            case MusicFlyme5.TEXT_PEIHANGBANG: {
                waitForTouchText(MusicFlyme5.TEXT_PEIHANGBANG, INDEX, 10 * 1000, 0);
                if (!searchIdByIndex(MusicFlyme5.ID_RANK_ICONS, INDEX, true))
                    waitForTouchText(MusicFlyme5.TEXT_PEIHANGBANG, INDEX, 5 * 1000, 0);
                waitForTouchId(MusicFlyme5.ID_RANK_ICONS, INDEX, 10 * 1000, 0);
                if (num > 0 && !waitForIdVisible(MusicFlyme5.ID_CONTENT_CONTAINER, INDEX, 10 * 1000)) {
                    intoOnlineMusic(MusicFlyme5.TEXT_PEIHANGBANG, --num);
                }
                break;
            }
            case MusicFlyme5.TEXT_DIANTAI: {
                waitForTouchText(MusicFlyme5.TEXT_DIANTAI, INDEX, 10 * 1000, 0);
                if (!searchTextIndex(MusicFlyme5.TEXT_GONGGO0NG, INDEX, true))
                    waitForTouchText(MusicFlyme5.TEXT_DIANTAI, INDEX, 5 * 1000, 0);
                if (num > 0 && !waitForText(MusicFlyme5.TEXT_GONGGO0NG, INDEX, 10 * 1000)) {
                    intoOnlineMusic(MusicFlyme5.TEXT_DIANTAI, --num);
                }
                break;
            }
            case MusicFlyme5.TEXT_GEDAN: {
                waitForTouchText(MusicFlyme5.TEXT_GEDAN, INDEX, 10 * 1000, 0);
                waitForTouchId(MusicFlyme5.ID_NAME, INDEX, 5 * 1000, 0);
                if (num > 0 && !waitForIdVisible(MusicFlyme5.ID_BUTTON_PLAYER, INDEX, 10 * 1000)) {
                    intoOnlineMusic(MusicFlyme5.TEXT_GEDAN, --num);
                }
                break;
            }
        }
    }

    protected void playMusic(String name, int sleep, boolean drap, boolean album_cover)  {
        // TODO Auto-generated method stub
        if (!waitForTouchId(MusicFlyme5.ID_CATEGORY_ALL, INDEX, 1000, 0)) {
            intoApp(true);
            waitForTouchId(MusicFlyme5.ID_CATEGORY_ALL, INDEX, 5 * 1000, 0);
        }
        sleep(1000);
        waitForTouchText(MusicFlyme5.TEXT_GEQU, INDEX, 5 * 1000, 0);
        if (drap) {
            dragTo(mathX(500), mathY(1300), mathX(500), mathY(100), 0);
        }
        waitForTouchText(name, INDEX, 5 * 1000, 0);
        sleep(sleep);// 歌曲需要播放多长时间
        adbshell("input keyevent KEYCODE_MEDIA_PAUSE");
        if (album_cover) {
            waitForTouchId(MusicFlyme5.ID_MINI_CONTENT, INDEX, 5 * 1000, 0);
            waitForIdVisible(MusicFlyme5.ID_TITLE, INDEX, 2 * 1000);
            String mName = getItemVal(MusicFlyme5.ID_TITLE, INDEX, true, "text").get(0);
            if (!mName.equals(name)) {
                waitForTouchId(MusicFlyme5.ID_SHOW_LIST_ITEM, INDEX, 5 * 1000, 0);
                waitForTouchText(name, INDEX, 5 * 1000, 0);
                adbshell("input keyevent KEYCODE_MEDIA_PAUSE");
                press("BACK");
            }
        }
    }

    protected boolean newMusicMenuFac(String strName, int addMusicNum)  {
        // TODO Auto-generated method stub
        if (searchTextIndex("添加至", INDEX, true) || searchTextIndex("我的歌单", INDEX, true)) {
            touchTextByIndex("新建歌单", INDEX, true, true, 0);
        }
        type(strName);
        press("BACK");
        if (!waitForTouchId(MusicFlyme5.ID_ANDROID_BUTTON1, INDEX, 2 * 1000, 0)) { // 点击确定
            touch(mathX(810), mathY(1220), true, 0);
        }
        if (addMusicNum != 0) {
            for (int i = 0; i < addMusicNum; i++) {
                if (i == 0)
                    waitForTouchId(MusicFlyme5.ID_CONTENT_CONTAINER, i + INDEX, 2 * 1000, 1000);
                else
                    waitForTouchId(MusicFlyme5.ID_CONTENT_CONTAINER, i + INDEX, 2 * 1000, 0);
            }
        }
        if (searchTextIndex(MusicFlyme5.TEXT_FINISH, INDEX, true)) {
            touchTextByIndex(MusicFlyme5.TEXT_FINISH, INDEX, false, true, 0);
        }
        return true;
    }

}
