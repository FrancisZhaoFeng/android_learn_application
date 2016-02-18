package tools;

import android.app.Instrumentation;
import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoguofeng on 2016/2/16.
 */
public class UserApi {
    Instrumentation mInstrumentation;
    UiDevice mUiDevice;
    static String TAG = "UserApi";
    static String musicPkg = "com.meizu.media.music";
    static String lanchPkg = "com.meizu.flyme.launcher";
    int INDEX = 0;
    long WAITTIME = 2 * 1000;
    int LONGCLICKTIME = 2000;

    public void setUp(Instrumentation mInstrumentation, UiDevice mUiDevice) {
        this.mInstrumentation = mInstrumentation;
        this.mUiDevice = mUiDevice;
    }

    protected boolean isPlaying() {
        boolean isPlaying = false;
        AudioManager audiomanage = (AudioManager) mInstrumentation.getContext().getSystemService(Context.AUDIO_SERVICE);
        if (audiomanage.isMusicActive()) {
            isPlaying = true;
        }
        return isPlaying;
    }

    public void longClick(UiObject2 obj, int time) {
        long startTime = System.currentTimeMillis();
        Rect buttonRect = obj.getVisibleBounds();
        Log.e(TAG, "获取坐标时间：" + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        mUiDevice.drag(buttonRect.centerX(), buttonRect.centerY(), buttonRect.centerX(), buttonRect.centerY(), 100);
        Log.e(TAG, "longClick end时间：" + (System.currentTimeMillis() - startTime));
    }


    public List<UiObject2> getIdOrTextObjectBase(String content, long timeout) {
        List<UiObject2> listUiObject;
        long startTime = System.currentTimeMillis();
        if (content.contains(":id/")) {
            listUiObject = mUiDevice.wait(Until.findObjects(By.res(content)), timeout);
        } else {
            listUiObject = mUiDevice.wait(Until.findObjects(By.text(content)), timeout);
        }
        Log.e(TAG, "获取：" + content + ",时间：" + (System.currentTimeMillis() - startTime));
        if (listUiObject != null) {
            Log.e(TAG, content + "--lUiObject not null," + "lUiObject size:" + listUiObject.size());
        } else {
            Log.e(TAG, "lUiObject is null");
        }
        if (listUiObject != null && listUiObject.size() != 0) {
            return listUiObject;
        }
        return null;
    }

    public UiObject2 getIdOrTextObject(String content, long timeout, int index) {
        List<UiObject2> listUiObject = getIdOrTextObjectBase(content, timeout);
        if (listUiObject != null && listUiObject.size() != 0) {
            return listUiObject.get(index);
        }
        return null;
    }

    public List<UiObject2> getIdOrTextObject(String content, long timeout) {
        List<UiObject2> listUiObject = getIdOrTextObjectBase(content, timeout);
        if (listUiObject == null) {
            return null;
        }
        return listUiObject;
    }

    /**
     * @param content
     * @param index
     * @param timeout
     * @param isLongClick
     * @return
     */
    public boolean waitForTouch(String content, int index, long timeout, boolean isLongClick) {
        UiObject2 uiObject = getIdOrTextObject(content, timeout, index);
        if (uiObject != null) {
            if (isLongClick) {
                longClick(uiObject, LONGCLICKTIME);
            } else {
                uiObject.click();
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * @param content
     * @param index
     * @param timeout
     * @param longClick
     * @return
     */
    public boolean waitForTouchId(String content, int index, long timeout, long longClick) {
        boolean isLongClick = false;
        if (longClick != 0) {
            isLongClick = true;
        }
        return waitForTouch(content, index, timeout, isLongClick);
    }

    public boolean waitForTouchText(String content, int index, long timeout, long longClick) {
        boolean isLongClick = false;
        if (longClick != 0) {
            isLongClick = true;
        }
        return waitForTouch(content, index, timeout, isLongClick);
    }

    public boolean waitForIdVisible(String content, int index, int timeout) {
        UiObject2 object2 = getIdOrTextObject(content, timeout, index);
        return object2 == null ? false : true;
    }

    public boolean waitForText(String content, int index, int timeout) {
        UiObject2 object2 = getIdOrTextObject(content, timeout, index);
        return object2 == null ? false : true;
    }

    protected int mathX(int x) {
        return x;
    }

    protected int mathY(int y) {
        return y;
    }

    public boolean sleep(int time) {
        try {
            Thread.sleep(time);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean type(String str) {
        try {
            mUiDevice.executeShellCommand("input text "+str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean press(String str) {
        if (str.equalsIgnoreCase("BACK")) {
            mUiDevice.pressBack();
        } else if (str.equalsIgnoreCase("HOME")) {
            mUiDevice.pressHome();
        }
        return false;
    }

    public String adbshell(String cmd) {
        Log.e(TAG, "adbshell:" + cmd);
        String strResult = "";
        try {
            strResult = mUiDevice.executeShellCommand(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strResult;
    }

    public String hasFocused() {
        return "";
    }

    public boolean startActivity(String str) {
        return false;
    }

    public String getAllText(boolean isNeedContent) {
        return "";
    }

    public boolean searchTextIndex(String content, int index, boolean fresh) {
        UiObject2 object2 = getIdOrTextObject(content, WAITTIME, index);
        return object2 == null ? false : true;
    }

    public boolean searchContentTextIndex(String text, int index, boolean fresh) {
        return false;
    }

    public boolean searchIdByIndex(String content, int index, boolean fresh) {
        UiObject2 object2 = getIdOrTextObject(content, WAITTIME, index);
        return object2 == null ? false : true;
    }

    public boolean touchIdByIndex(String viewIdName, int index, boolean fresh, boolean even, int times) {
        return false;
    }

    public boolean touchTextByIndex(String content, int index, boolean fresh, boolean even, int times) {
        UiObject2 object2 = getIdOrTextObject(content, WAITTIME, index);
        object2.click();
        return false;
    }

    public boolean touchContentTextByIndex(String text, int index, boolean fresh, boolean even, int times) {
        return false;
    }

    public boolean touchTextByAddXY(String text, int index, boolean fresh, boolean even, int times, int addx, int addy) {
        return false;
    }

    public boolean touchContentTextByAddXY(String text, int index, boolean fresh, boolean even, int times, int addx, int addy) {
        return false;
    }

    public boolean touchIdByAddXY(String viewIdName, int index, boolean fresh, boolean even, int times, int addx, int addy) {
        return false;
    }

    public boolean getSwitchIsChecked(String text, int index, boolean fresh, String viewIdName, int times) {
        return false;
    }

    public boolean touchSwitchByText(String text, int index, boolean fresh, boolean even, String viewIdName, int wait, int times) {
        return false;
    }

    public int getSearchIdNumber(String viewIdName, boolean fresh) {
        return 1;
    }

    public boolean isTextEnabled(String text, int index, boolean fresh) {
        return false;
    }

    public boolean isIdEnabled(String viewIdName, int index, boolean fresh) {
        return false;
    }

    public boolean isContentTextEnabled(String text, int index, boolean fresh) {
        return false;
    }

    public boolean isViewIdChecked(String viewIdName, int index, boolean fresh) {
        return false;
    }

    public boolean touch(int x, int y, boolean even, int times) {
        return false;
    }

    public boolean dragTo(int x, int y, int x1, int y1, int times) {
        mUiDevice.drag(x, y, x1, y1, times);
        return false;
    }

    public List<String> getItemVal(String content, int index, boolean fresh, String val) {
        List<String> list = new ArrayList<>();
        UiObject2 object2 = getIdOrTextObject(content, WAITTIME, index);
        if (val.equals("text")) {
            list.add(object2.getText());
        } else if (val.equals("xy")) {
            list.add("" + object2.getVisibleBounds().centerX());
            list.add("" + object2.getVisibleBounds().centerY());
        }
        Log.e(TAG, "getItemVal:" + list);
        return list;
    }

}
