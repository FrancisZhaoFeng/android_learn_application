package com.meizu.mydagger2.bean;

import android.util.Log;

import com.meizu.mydagger2.common.Contants;

/**
 * ThermosiphonPump
 * Created by mantou on 15/10/29.
 */
public class ThermosiphonPump implements Pump {

    @Override
    public void exec() {
        Log.e(Contants.TAG,"ThermosiphonPump.exec: " + toString());
    }
}
