package com.meizu.mydagger2.sturcture;

import android.util.Log;

import com.meizu.mydagger2.bean.Attrite;
import com.meizu.mydagger2.bean.Heater;
import com.meizu.mydagger2.bean.Pump;
import com.meizu.mydagger2.common.Contants;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;


/**
 * CoffeeMaker
 * Created by mantou on 15/10/29.
 */
@Singleton
public class CoffeeMaker {
    Attrite mAttrite;
    Heater mHeater;
    Pump mPump;

    @Inject  //注入，在CoffeeMakerModule 中找注入对象
    public CoffeeMaker(Attrite attrite,@Named("typeB") Heater heater, Pump pump) {
        mAttrite = attrite;
        mHeater = heater;
        mPump = pump;
    }

    public void make() {
        Log.e(Contants.TAG,"CoffeeMaker.make, " + toString());
        mAttrite.attrite();
        mHeater.heat();
        mPump.exec();
    }
}
