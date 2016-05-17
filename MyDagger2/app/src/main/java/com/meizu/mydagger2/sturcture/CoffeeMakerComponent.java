package com.meizu.mydagger2.sturcture;

import com.meizu.mydagger2.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * CoffeeMakerComponent
 * Created by mantou on 15/10/29.
 */
@Singleton //1 单例模式
@Component(modules = CofferMakerModule.class) //2 中@Component使用modules指向使用的Module的集合
public interface CoffeeMakerComponent {//3 接口，自动生成实现
    CoffeeMaker getCoffeeMaker();//4 获取 CoffeeMaker

    void inject(MainActivity app);//5 注入方方法
}
