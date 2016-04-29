package com.meizu.apptest.utils;


import com.meizu.apptest.beans.ApkTestInfoBean;
import com.meizu.apptest.beans.PhoneTestInfoBean;
import com.meizu.apptest.common.Constant;

import org.litepal.crud.DataSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoguofeng on 2016/3/17.
 */
public class DBUtil {

    public static List<ApkTestInfoBean> checkDBByStatus(String keyword, String status) {
        List<ApkTestInfoBean> apkTestInfoBeanList = DataSupport.where(keyword, status).find(ApkTestInfoBean.class);
        return apkTestInfoBeanList;
    }

    public static PhoneTestInfoBean checkDBGenTestInfo() {
        PhoneTestInfoBean phoneTestInfoBean = new PhoneTestInfoBean();
        Map<String, List<ApkTestInfoBean>> map = new HashMap<>();
        for (String status : Constant.status) {
            map.put(status, DataSupport.where("status like ?", status).find(ApkTestInfoBean.class));
        }
        phoneTestInfoBean.setAllListMap(map);
        phoneTestInfoBean.setTotalNum(DataSupport.count(ApkTestInfoBean.class));
        return phoneTestInfoBean;
    }

    public static void saveStatus(ApkTestInfoBean apkTestInfoBean) {
        //更新表数据
        ApkTestInfoBean apkTestInfoBeanTemp = new ApkTestInfoBean();
        apkTestInfoBeanTemp.setStatus(apkTestInfoBean.getStatus());
        apkTestInfoBeanTemp.updateAll("sn = ?", "" + apkTestInfoBean.getSn());
    }
}
