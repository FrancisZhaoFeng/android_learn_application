package com.meizu.layout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.meizu.layout.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAnon;
    private Button btnActi;
    private Button btnBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        btnAnon = (Button) this.findViewById(R.id.btn_anon);
        btnActi = (Button) this.findViewById(R.id.btn_acti);
        btnBind = (Button) this.findViewById(R.id.btn_bind);
        //Activity本身作为事件监听器
        btnActi.setOnClickListener(this);
        /**
         * 匿名内部类作为事件监听器类
         * 大部分时候，事件处理器都没有什么利用价值（可利用代码通常都被抽象成了业务逻辑方法），
         * 因此大部分事件监听器只是临时使用一次，所以使用匿名内部类形式的事件监听器更合适，
         * 实际上，这种形式是目前是最广泛的事件监听器形式。
         * 对于使用匿名内部类作为监听器的形式来说，唯一的缺点就是匿名内部类的语法有点不易掌握，如果读者java基础扎实，匿名内部类的语法掌握较好，通常建议使用匿名内部类作为监听器。
         */
        btnAnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,KnifeActivity.class);
                Toast.makeText(MainActivity.this, "匿名内部类作为事件监听器类", Toast.LENGTH_LONG).show();
            }
        });
    }


    /**
     * Activity本身作为事件监听器
     * 这种形式非常简洁。但这种做法有两个缺点：
     * （1）这种形式可能造成程序结构混乱。Activity的主要职责应该是完成界面初始化；但此时还需包含事件处理器方法，从而引起混乱。
     * （2）如果activity界面类需要实现监听器接口，让人感觉比较怪异。
     * 上面的程序让Activity类实现了OnClickListener事件监听接口，从而可以在该Activity类中直接定义事件处理器方法：onClick(view v)，当为某个组件添加该事件监听器对象时，直接使用this作为事件监听器对象即可。
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        int id = view.getId();
//        Toast.makeText(this, "id:" + id + "，btn_acti:" + R.id.btn_acti, Toast.LENGTH_LONG).show();
        switch (id) {
            case R.id.btn_acti:
                Toast.makeText(MainActivity.this, "Activity本身作为事件监听器", Toast.LENGTH_LONG).show();
                break;

        }
    }

    /**
     * 直接绑定到标签
     * Android还有一种更简单的绑定事件监听器的的方式，直接在界面布局文件中为指定标签绑定事件处理方法。
     * 对于很多Android标签而言，它们都支持如onClick、onLongClick等属性为
     * Button按钮绑定一个事件处理方法：onBindTag，这意味着需要在该界面布局对应的Activity中定义一个void onBindTag(View source)方法，该方法将会负责处理该按钮上的单击事件。
     */
    public void onBindTag(View source) {
        Toast.makeText(MainActivity.this, "直接绑定到标签", Toast.LENGTH_LONG).show();
    }
}