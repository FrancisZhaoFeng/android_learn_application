package com.meizu.autotest.Music;

import android.app.Instrumentation;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import org.junit.After;
import org.junit.Test;

import constant.NewConstants;
import constant.NewConstants.MusicFlyme5;
import tools.UserApi;

/**
 * Created by zhaoguofeng on 2016/2/2.
 */
public class MusicTest extends MusicBase {
    String TAG = "MusicTest";

    Instrumentation mInstrumentation;
    UiDevice mUiDevice;
    UserApi userApi;
    protected Boolean m_bResult, m_bResA, m_bResB, m_bResC, m_bResD, m_bResE, m_bResTemp;
    int INDEX = 0;
    long WAITTIME = 2 * 1000;
    int LONGCLICKTIME = 2000;
    static String m_strTestName = "tests" + String.valueOf(System.currentTimeMillis()).substring(String.valueOf(System.currentTimeMillis()).length() - 3, String.valueOf(System.currentTimeMillis()).length());


    @Test
    public void check() {
        //=====================//
        //=====================//
//        copySource(true);
        mUiDevice.wait(Until.findObject(By.text("蓝牙")), 60 * 1000).click();
//        ready();
        //==========//
//        playInterface();
//        addToMusicMenu();
    }

    public void playInterface() {
        recover();

        // 播放 暂停
        intoOnlineMusic(NewConstants.MusicFlyme5.TEXT_PEIHANGBANG, 5);
        waitForTouchId(MusicFlyme5.ID_TITLE, INDEX, 10 * 1000, 0);
        waitForPlay(60 * 1000);
        adbshell("input keyevent KEYCODE_MEDIA_PAUSE");
        waitForTouchId(MusicFlyme5.ID_MINI_CONTENT, INDEX, 5 * 1000, 0);
        adbshell("input keyevent KEYCODE_MEDIA_PLAY");
        m_bResA = waitForPlay(60 * 1000);
        adbshell("input keyevent KEYCODE_MEDIA_PAUSE");
        m_bResA = m_bResA && !isPlaying();

        // 上一曲 下一曲
        String mName = getItemVal(MusicFlyme5.ID_TITLE, INDEX, true, "text").get(0);
        waitForTouchId(MusicFlyme5.ID_IMAGE_NEXT, INDEX, 5 * 1000, 0);
        waitForPlay(30 * 1000);
        adbshell("input keyevent KEYCODE_MEDIA_PAUSE");// 暂停
        m_bResB = !mName.equals(getItemVal(MusicFlyme5.ID_TITLE, INDEX, true, "text").get(0));
        waitForTouchId(MusicFlyme5.ID_IMAGE_PREV, INDEX, 5 * 1000, 0);
        waitForPlay(30 * 1000);
        adbshell("input keyevent KEYCODE_MEDIA_PAUSE");
        m_bResB = m_bResB && mName.equals(getItemVal(MusicFlyme5.ID_TITLE, INDEX, true, "text").get(0));

        // 快进 快退
        String strTimeS = getItemVal(MusicFlyme5.ID_TIME_CURRENT, INDEX, true, "text").get(0);
        int Yy = speed(false);
        dragTo(mathX(265), Yy, mathX(800), Yy, 500);
        waitForIdVisible(MusicFlyme5.ID_TIME_CURRENT, INDEX, 10 * 1000);
        String strTimeE = getItemVal(MusicFlyme5.ID_TIME_CURRENT, INDEX, true, "text").get(0);
        int INum1 = strTimeS.compareTo(strTimeE);
        dragTo(mathX(800), Yy, mathX(300), Yy, 500);
        waitForIdVisible(MusicFlyme5.ID_TIME_CURRENT, INDEX, 10 * 1000);
        strTimeS = getItemVal(MusicFlyme5.ID_TIME_CURRENT, INDEX, true, "text").get(0);
        int INum2 = strTimeS.compareTo(strTimeE);
        m_bResC = INum1 < 0 && INum2 < 0;

        // 收藏 取消收藏
        mName = getItemVal(MusicFlyme5.ID_MUSIC_ARTIST_ALBUM, INDEX, true, "text").get(0);
        if (!waitForTouchId(MusicFlyme5.ID_COLLECTING_VIEW, INDEX, 2 * 1000, 0)) {
            touch(mathX(540), mathY(1840), true, 0);
        }
        sleep(1000);// 截图需等待一段时间才能看出效果
        intoApp(true);
        waitForTouchText(MusicFlyme5.TEXT_WODEZUIAI, INDEX, 5 * 1000, 0);
        sleep(1000);
        m_bResD = getItemVal("com.meizu.media.music:id/comment", INDEX, true, "text").get(0).equals(mName);
        waitForTouchId(MusicFlyme5.ID_MINI_CONTENT, INDEX, 5 * 1000, 0);
        if (!waitForTouchId(MusicFlyme5.ID_COLLECTING_VIEW, INDEX, 2 * 1000, 0)) {
            touch(mathX(540), mathY(1840), true, 0);
        }
        intoApp(true);
        waitForTouchText(MusicFlyme5.TEXT_WODEZUIAI, INDEX, 5 * 1000, 0);
        m_bResD = m_bResD && !waitForIdVisible(MusicFlyme5.ID_ICON, INDEX, 1000);

        m_bResult = m_bResA && m_bResB && m_bResC && m_bResD;
    }

    public void addToMusicMenu() {
        // TODO Auto-generated method stub

        deleteMusicMenu();
        String select[] = {MusicFlyme5.TEXT_GEQU, MusicFlyme5.TEXT_YIREN, MusicFlyme5.TEXT_ZHUANJI};
        String addselect[] = {MusicFlyme5.TEXT_SONG1, "singer2", "special3"};
        String addsong[] = {MusicFlyme5.TEXT_SONG1, MusicFlyme5.TEXT_SONG2, MusicFlyme5.TEXT_SONG3};
        playMusic(MusicFlyme5.TEXT_SONG1, 0, false, false);
        for (int j = 0; j < select.length; j++) {
            waitForTouchText(select[j], INDEX, 5 * 1000, 0);
            sleep(2 * 1000);
            waitForTouchText(addselect[j], INDEX, 5 * 1000, 1000);
            waitForTouchId(MusicFlyme5.ID_ACTION_ADD_TO_PLAYLIST, INDEX, 5 * 1000, 0);
            newMusicMenuFac(m_strTestName + j, 0);
        }
        intoApp(true);
        m_bResult = true;
        for (int j = 0; j < select.length; j++) {
            dragTo(mathX(500), mathY(1300), mathX(500), mathY(100), 0); // 向上滑动
            sleep(1000);
            waitForTouchText(m_strTestName + j, INDEX, 5 * 1000, 0);
            m_bResult = m_bResult && searchTextIndex(addsong[j], INDEX, true);
            press("BACK");
        }
    }

    @After
    public void after() {
        return;
    }
}
