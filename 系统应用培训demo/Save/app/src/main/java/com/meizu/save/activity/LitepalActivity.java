package com.meizu.save.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.meizu.save.R;
import com.meizu.save.bean.User;
import com.orhanobut.logger.Logger;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LitepalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litepal);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.id_init)
    public void initDate() {
        for (int i = 0; i < 10; i++) {
            User user = new User("meizu_" + i, 15 + i, "abc@meizu.com");
            user.save();
        }
        Logger.i("已初始化10条数据");
        Toast.makeText(this, "已初始化10条数据", Toast.LENGTH_SHORT).show();
    }

    /**
     * 增，插入一条数据到数据库
     */
    @OnClick(R.id.id_add)
    public void addData() {
        User user = new User("meizu", 21, "abc@meizu.com");
        user.save();
        Logger.i("插入一条数据");
        Toast.makeText(this, "插入一条数据", Toast.LENGTH_SHORT).show();
    }

    /**
     * 删，从数据库中删除一条数据
     */
    @OnClick(R.id.id_delete)
    public void deleteData() {
        DataSupport.delete(User.class, 1);
//        DataSupport.deleteAll(User.class, "age > ?" , "20");
        Logger.i("删除一条数据");
        Toast.makeText(this, "删除一条数据", Toast.LENGTH_SHORT).show();
    }

    /**
     * 改，修改数据库中一条数据的记录
     */
    @OnClick(R.id.id_update)
    public void updateData() {
        User user = DataSupport.find(User.class, 1);
        user.setAge(29);
        user.save();
        Toast.makeText(this, "修改age为29", Toast.LENGTH_LONG).show();
    }

    /**
     * 查，查询数据库内容
     */
    @OnClick(R.id.id_select)
    public void selectData() {
        List<User> users = DataSupport.findAll(User.class); //List<User> userLikes = DataSupport.where("name like ?", "%meizu%").find(User.class);
        Logger.i("size：" + users.size() + "，内容：" + users.toString());
        Toast.makeText(this, "查询共有：" + users.size() + "条数据", Toast.LENGTH_LONG).show();
//        User user = DataSupport.find(User.class, 1);
//        Logger.i("user：" + user.toString());
    }
}
