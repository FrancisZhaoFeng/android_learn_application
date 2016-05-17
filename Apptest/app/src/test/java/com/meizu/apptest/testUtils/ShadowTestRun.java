package com.meizu.apptest.testUtils;

import android.app.DownloadManager;

import org.junit.runners.model.InitializationError;
import org.litepal.tablemanager.Connector;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.internal.bytecode.InstrumentationConfiguration;

/**
 * Created by zhaoguofeng on 2016/5/4.
 */
public class ShadowTestRun extends RobolectricGradleTestRunner {
    public ShadowTestRun(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public InstrumentationConfiguration createClassLoaderConfig() {
        InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();
        /**
         * 添加要进行Shadow的对象
         */
        builder.addInstrumentedClass(Connector.class.getName());
        return builder.build();
    }
}
