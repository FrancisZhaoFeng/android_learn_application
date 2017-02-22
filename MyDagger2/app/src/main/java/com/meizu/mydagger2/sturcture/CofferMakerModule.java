package com.meizu.mydagger2.sturcture;

import com.meizu.mydagger2.bean.Attrite;
import com.meizu.mydagger2.bean.ElectricalHeater;
import com.meizu.mydagger2.bean.FireHeater;
import com.meizu.mydagger2.bean.Heater;
import com.meizu.mydagger2.bean.Pump;
import com.meizu.mydagger2.bean.StrongAttrite;
import com.meizu.mydagger2.bean.ThermosiphonPump;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * CofferMakerModule
 * Created by mantou on 15/10/29.
 */
@Module //1 注明本类属于Module
public class CofferMakerModule {

    @Singleton//2 使用@Singleton来缓存“榨果汁机器”，这样在下一次需要“榨果汁机器”时会直接使用上一次的缓存
    @Provides//3 注明该方法是用来提供依赖对象的特殊方法
    Attrite provideAttrite() {
        return new StrongAttrite();
    }

    @Named("typeA")
    @Singleton
    @Provides
    Heater provideElectricalHeater() {
        return new ElectricalHeater();
    }

    @Named("typeB")
    @Singleton
    @Provides
    Heater provideFireHeater() {
        return new FireHeater();
    }

    @Singleton
    @Provides
    Pump providePump() {
        return new ThermosiphonPump();
    }
}
