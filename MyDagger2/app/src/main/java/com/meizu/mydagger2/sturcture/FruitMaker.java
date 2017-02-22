package com.meizu.mydagger2.sturcture;

import android.util.Log;

import com.meizu.mydagger2.bean.Apple;
import com.meizu.mydagger2.common.Contants;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by zhaoguofeng on 2016/5/17.
 */
@Singleton //单例模式
public class FruitMaker {
    Apple mApple;

    @Inject //注入
    FruitMaker(Apple apple) {
        mApple = apple;
    }

   public  void eatApple() {
        Log.e(Contants.TAG, mApple.getColor() + "==" + mApple.getSize());
    }
}
