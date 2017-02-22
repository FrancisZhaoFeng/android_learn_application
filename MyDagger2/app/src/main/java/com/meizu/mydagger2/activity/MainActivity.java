package com.meizu.mydagger2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.meizu.mydagger2.R;
import com.meizu.mydagger2.common.Contants;
import com.meizu.mydagger2.sturcture.CoffeeMakerComponent;
import com.meizu.mydagger2.sturcture.DaggerCoffeeMakerComponent;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(Contants.TAG, "----------------------------------");
        CoffeeMakerComponent component = DaggerCoffeeMakerComponent.create();//1 根据自动生成的 Dagger 创造一个 Component
        component.getCoffeeMaker().make();//2 根据 CoffeeMakerComponent 获取CoffeeMaker（声明的对象已被注入），并调用make函数
    }
}
/*
        Log.e(Contants.TAG,"----------------------------------");
        CoffeeMakerComponent component = DaggerCoffeeMakerComponent.create();
        component.getCoffeeMaker().make();

        FruitMakerComponent fruitMakerComponent = DaggerFruitMakerComponent.create();
        fruitMakerComponent.getFruitMaker().eatApple();
 */
