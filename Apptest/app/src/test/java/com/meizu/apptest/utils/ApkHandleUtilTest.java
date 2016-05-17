package com.meizu.apptest.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.meizu.apptest.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.res.RoutingResourceLoader;
import org.robolectric.shadows.ShadowContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by zhaoguofeng on 2016/5/4.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ApkHandleUtilTest {
    @Mock
    ApkHandleUtil mockApkHandleUtil;
    @Mock
    PackageManager mockPackageManager;
    @Mock
    PackageInfo mockPackageInfo;
    @Mock
    List<PackageInfo> mockPackageInfos;
    @Mock
    Context mockContext;

    @Before
    public void setUp() {
        //这个是必须的。
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInstallApk() throws Exception {

    }

    @Test
    public void testTestApk() throws Exception {

    }

    @Test
    public void testUninstallApk() throws Exception {

    }

    @Test
    public void testHasOpen() throws Exception {

    }

    @Test
    public void testSleep() throws Exception {

    }

    @Test
    public void testKilledMonkeyTest() throws Exception {

    }

    @Test
    public void testInstallApk1() throws Exception {
        List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("tmp");
        System.out.println(mockList.get(0));
//        when(mockList.size()).thenReturn(5);
    }

    @Test
    public void testIsInstalledApk_containPackageName_returnTrue() throws Exception {
        when(mockContext.getPackageManager()).thenReturn(mockPackageManager);
        when(mockPackageManager.getInstalledPackages(0)).thenReturn(mockPackageInfos);
        when(mockPackageInfos.size()).thenReturn(1);
        when(mockPackageInfos.get(anyInt())).thenReturn(mockPackageInfo);
        mockPackageInfo.packageName = "com.meizu.test";

        verify(mockPackageInfos).get(anyInt());

        assertFalse(mockApkHandleUtil.isInstalledApk(mockContext, "com.meizu.test"));
//
//        when(mockContext.getPackageManager()).thenReturn(mockPackageManager);
//        when(mockPackageManager.getInstalledPackages(0)).thenReturn(mockPackageInfos);
//        when(mockPackageInfos.size()).thenReturn(1);
//        when(mockPackageInfos.get(anyInt())).thenReturn(mockPackageInfo);
//        mockPackageInfo.packageName = "com.meizu.test";
//
//        verify(mockPackageInfos).get(anyInt());
//
//        assertFalse(mockApkHandleUtil.isInstalledApk(mockContext, "com.meizu.test"));
    }

    @Test
    public void testIsInstalledApk_notContainPackageName_returnFalse() throws Exception {
        when(mockContext.getPackageManager()).thenReturn(mockPackageManager);
        when(mockPackageManager.getInstalledPackages(0)).thenReturn(mockPackageInfos);
        when(mockPackageInfos.size()).thenReturn(1);

        when(mockPackageInfos.get(anyInt())).thenReturn(mockPackageInfo);
        mockPackageInfo.packageName = "meizu.testd";

        assertFalse(mockApkHandleUtil.isInstalledApk(mockContext, "com.meizu.test"));
    }
}