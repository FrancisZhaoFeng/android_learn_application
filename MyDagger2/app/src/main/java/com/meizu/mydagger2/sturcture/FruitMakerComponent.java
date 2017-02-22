package com.meizu.mydagger2.sturcture;

import com.meizu.mydagger2.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhaoguofeng on 2016/5/17.
 */
@Singleton
@Component(modules = {FruitMakerModule.class})
public interface FruitMakerComponent {
    FruitMaker getFruitMaker();
    void inject(MainActivity app);
}
