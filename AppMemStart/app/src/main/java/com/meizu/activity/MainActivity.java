package com.meizu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.meizu.appmemstart.R;
import com.meizu.common.Contants;
import com.meizu.dao.DBManager;
import com.meizu.domain.AppMemMapInfo;
import com.meizu.domain.PckInfo;
import com.meizu.domain.UserHabitInfo;
import com.meizu.reporte.HtmlOut;
import com.meizu.service.AppStartService;
import com.meizu.tools.MyAdapter;
import com.meizu.tools.PackageMgr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private String TAG = "MainActivity";
    private List<PckInfo> allPckInfos = new ArrayList<>();
    private List<String> listPackage = new ArrayList<>();
    private EditText edt_Num;
    private Toolbar toolbar;
    private CheckBox chb_checkAll;
    FloatingActionButton fab;
    private ListView listView;
    private PackageMgr packgeMan;
    private MyAdapter myAdapter;
    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                List<PckInfo> mainPckInfos = getMainListView();
                if (edt_Num.getText() != null && !edt_Num.getText().toString().equals(""))
                    Contants.USERHABITINFO.setAppNum(Integer.valueOf(edt_Num.getText().toString()));
                Contants.USERHABITINFO.setAppData(listPackage);
                dbManager.insertUserHabitInfo(Contants.USERHABITINFO);
                Intent intent = new Intent(MainActivity.this, AppStartService.class);
                intent.putParcelableArrayListExtra("mainPckInfos", (ArrayList<? extends Parcelable>) mainPckInfos);
                startService(intent);
//                stopService(intent);
            }
        });
        setMainListView();
        DrawerLay();

        chb_checkAll.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                HashMap<Integer, Boolean> isSelected = MyAdapter.getIsSelected();
                for (int i = 0; i < allPckInfos.size(); i++) {
                    isSelected.put(i, isChecked);
                }
                myAdapter.setIsSelected(isSelected);
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onStart() {
        dbManager = DBManager.getInstance(MainActivity.this);
        super.onStart();
        if ((Contants.USERHABITINFO = dbManager.selectUserHabitInfo()) == null) {
            List<String> memData = new ArrayList<>();
            for (int i = 0; i < 3; i++)
                memData.add(Contants.dumpElement[i]);
            Contants.USERHABITINFO = new UserHabitInfo(5, 5, 10, memData, null);
            dbManager.insertUserHabitInfo(Contants.USERHABITINFO);
        }
        edt_Num.setHint("" + Contants.USERHABITINFO.getAppNum());
        Log.i(TAG, "onStart: " + Contants.USERHABITINFO.toString());

        if (Contants.USERHABITINFO.getAppData() != null) {
            HashMap<Integer, Boolean> isSelected = MyAdapter.getIsSelected();
            for (int i = 0; i < Contants.USERHABITINFO.getAppData().size(); i++) {
                for (int j = 0; j < allPckInfos.size(); j++) {
                    if (Contants.USERHABITINFO.getAppData().get(i).equals(allPckInfos.get(j).getPackageName())) {
                        isSelected.put(j, true);
                        break;
                    }
                }
            }
            myAdapter.setIsSelected(isSelected);
            myAdapter.notifyDataSetChanged();
        }
    }

    private void initData() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edt_Num = (EditText) this.findViewById(R.id.edt_num);
        chb_checkAll = (CheckBox) this.findViewById(R.id.chb_main);
        listView = (ListView) this.findViewById(R.id.lv_main_package);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        packgeMan = new PackageMgr(MainActivity.this);
        packgeMan.getPackageName(allPckInfos);
        //自动开启accibility服务
        Settings.Secure.putString(getContentResolver(), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES,
                "com.meizu.appmemstart/com.meizu.tools.OnAccessibility");
        Settings.Secure.putInt(getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED, 1);
    }

    private void setMainListView() {
        myAdapter = new MyAdapter(MainActivity.this, allPckInfos, false);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyAdapter.ViewHolder holder = (MyAdapter.ViewHolder) view.getTag();
                holder.ckb_choose.toggle();
                MyAdapter.getIsSelected().put(position, holder.ckb_choose.isChecked());
            }
        });
    }

    private List<PckInfo> getMainListView() {
        List<PckInfo> mainPckInfos = new ArrayList<>();
        HashMap<Integer, Boolean> isSelected = MyAdapter.getIsSelected();
        mainPckInfos.clear();
        for (int i = 0; i < isSelected.size(); i++) {
            if (isSelected.get(i) == true) {
                mainPckInfos.add(allPckInfos.get(i));
                listPackage.add(allPckInfos.get(i).getPackageName());
            }
        }
        Toast.makeText(this, "一共测试应用：" + mainPckInfos.size() + "个", Toast.LENGTH_SHORT).show();
        return mainPckInfos;
    }

    private void DrawerLay() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
//        dbManager.close("MainActivity");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_delete) {
            if (dbManager.setDeleteSql(Contants.TABLE_NAME_APP, true)) {
                Toast.makeText(this, "数据库数据被清除 成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "数据库数据被清除 失败", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_slideshow) {
            List<AppMemMapInfo> appMemMapInfos = new ArrayList<>();
            dbManager.selectAppMemInfo("*", appMemMapInfos);
            if (appMemMapInfos.size() == 0) {
                Toast.makeText(this, "数据库没有数据 ", Toast.LENGTH_SHORT).show();
            } else {
                HtmlOut htmlOut = new HtmlOut();
                htmlOut.creathtml(appMemMapInfos, Contants.HTML_PATH + Contants.HTML_NAME_ALL, Contants.USERHABITINFO.getMemData());
                htmlOut.openBrower(Contants.HTML_PATH + Contants.HTML_NAME_ALL, MainActivity.this);
                Toast.makeText(this, "生成成功，路径：" + Contants.HTML_PATH, Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(MainActivity.this, PackageActivity.class);
            startActivity(intent);
        }
// else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        } else if (id == R.id.nav_gallery) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
