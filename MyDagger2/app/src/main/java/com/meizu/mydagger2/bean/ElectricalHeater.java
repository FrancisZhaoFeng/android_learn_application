package com.meizu.mydagger2.bean;

import android.util.Log;

import com.meizu.mydagger2.common.Contants;

/**
 * ElectricalHeater
 * Created by mantou on 15/10/29.
 */
public class ElectricalHeater implements Heater {
    @Override
    public void heat() {
        Log.e(Contants.TAG,"ElectricalHeater.heat.: " + toString());
    }
}
