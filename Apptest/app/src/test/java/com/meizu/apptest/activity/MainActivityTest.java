package com.meizu.apptest.activity;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.meizu.apptest.BuildConfig;
import com.meizu.apptest.R;
import com.meizu.apptest.common.Constant;
import com.meizu.apptest.testUtils.ShadowTestRun;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static com.meizu.apptest.R.id;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zhaoguofeng on 2016/5/4.
 */
@RunWith(ShadowTestRun.class)
@Config(constants = BuildConfig.class, sdk = 21, shadows = {ShadowConnector.class})
public class MainActivityTest {
    private MainActivity mainActivity;
    private EditText edtPath;
    private EditText edtCount;
    private RelativeLayout rlMonkey;
    private RadioButton rdbYes;
    private RadioButton rdbNo;
    private EditText edtMonkeyTime;
    private ImageButton imgbReport;
    private ImageButton imgbDelete;

    @Before
    public void setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void testOnCreate() throws Exception {
        assertTrue(ShadowConnector.flag);
    }

    @Test
    public void testOnClick_myes_monkeyVisibility() throws Exception {
        rdbYes = (RadioButton) mainActivity.findViewById(id.rb_myes);
        rlMonkey = (RelativeLayout) mainActivity.findViewById(id.rl_monkey);
        rdbYes.performClick();
        assertEquals(0,rlMonkey.getVisibility());
    }

    @Test
    public void testOnClick_mno_monkeyVisibility() throws Exception {
        rdbYes = (RadioButton) mainActivity.findViewById(id.rb_mno);
        rlMonkey = (RelativeLayout) mainActivity.findViewById(id.rl_monkey);
        rdbYes.performClick();
        assertEquals(8,rlMonkey.getVisibility());
    }

    @Test
    public void testOnClick_report_creatHtml() throws Exception {
        imgbReport= (ImageButton) mainActivity.findViewById(id.imgb_report);
        imgbReport.performClick();

//        System.out.println( ShadowToast.getLatestToast().toString());
//        assertEquals( "生成成功，路径：", ShadowToast.getLatestToast().toString());
    }
}