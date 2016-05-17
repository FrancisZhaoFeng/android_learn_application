package com.meizu.mydagger2.bean;

import android.util.Log;

import com.meizu.mydagger2.common.Contants;

/**
 * Created by zhaoguofeng on 2016/5/17.
 */
public class StrongAttrite implements Attrite{
    @Override
    public void attrite() {
        Log.e(Contants.TAG,"StrongAttrite.attrite.: " + toString());
    }
}
