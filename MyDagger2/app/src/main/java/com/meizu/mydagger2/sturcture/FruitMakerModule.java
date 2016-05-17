package com.meizu.mydagger2.sturcture;

import com.meizu.mydagger2.bean.Apple;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhaoguofeng on 2016/5/17.
 */
@Module  //1 注明本类属于Module
public class FruitMakerModule {
    @Singleton
    @Provides
    Apple providesApple(){
        return new Apple("red",32);
    }
}



