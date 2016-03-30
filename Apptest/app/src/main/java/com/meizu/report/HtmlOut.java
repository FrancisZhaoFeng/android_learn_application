package com.meizu.report;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.meizu.beans.ApkTestInfoBean;
import com.meizu.beans.PhoneTestInfoBean;
import com.meizu.common.Constant;
import com.meizu.utils.DBUtil;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class HtmlOut {
    private String TAG = "HtmlOut";
    PhoneTestInfoBean phoneTestInfoBean;

    public boolean creathtml() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Constant.autotestPath + Constant.reportName, false)));
            phoneTestInfoBean = DBUtil.checkDBGenTestInfo();

            //头部
            List<String> baseInfos = new ArrayList<>();
            baseInfoGen(baseInfos);
            bufferedWriter.write(htmlTop());
            bufferedWriter.write("<br/>\n");
            bufferedWriter.write(baseInfoHeader());
            for (int i = 0; i < baseInfos.size(); i++) {
                String[] str = baseInfos.get(i).split("~");
                bufferedWriter.write("<tr>\n");
                bufferedWriter.write(baseInfoContent(str));
                bufferedWriter.write("</tr>\n");
            }
            bufferedWriter.write("</table>\n");
            bufferedWriter.write("<br/>\n");

            //中部
            for (int i = 0; i < phoneTestInfoBean.getAllListMap().size(); i++) {
                List<ApkTestInfoBean> apkTestInfoBeans = phoneTestInfoBean.getAllListMap().get(Constant.status[i]);
                if (apkTestInfoBeans.size() == 0) continue;
                bufferedWriter.write("<br/>\n");
                bufferedWriter.write(memoryInfoHeader(Constant.status[i]));
                for (ApkTestInfoBean apkTestInfoBean : apkTestInfoBeans) {
                    bufferedWriter.write("<tr>\n");
                    bufferedWriter.write(memoryInfoContent(apkTestInfoBean, true));
                    bufferedWriter.write("</tr>\n");
                }
                bufferedWriter.write("</table>\n");
            }


            //尾部
            bufferedWriter.write(htmlend());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private String htmlTop() {
        String strHtml;
        strHtml = "<html>\n";
        strHtml += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n";
        strHtml += "<body>\n";
        strHtml += "<head>\n";
        strHtml += "<title>MEIZU_3wApptest测试</title>\n";
        strHtml += "</head>\n";
        return strHtml;
    }

    private String baseInfoHeader() {
        String strHtml;
        strHtml = "<br/>";
        strHtml += "<h1 align='center'>3wApptest测试</h1></div>\n";
        strHtml += "<table height=\"199\" width=\"40%\" table border=\"0\" cellspacing=\"0px\" style=\"border-collapse:collapse\" align='center'>\n";
        strHtml += "<hr/>\n";
        strHtml += "<tr>\n";
        strHtml += "<td bgcolor='#F83F7D' align='center' colspan='2' style='font-weight:bold;font-size:30'>Test Info<br/></td>\n";
        strHtml += "</tr>\n";
        return strHtml;
    }

    private String baseInfoContent(String[] str) {
        String a1 = "";
        a1 += "<td bgcolor='#FAEBD7' width=\"15%\" >" + str[0] + "</td>\n";
        a1 += "<td bgcolor='#FAEBD7' width=\"15%\" >" + str[1] + "</td>\n";
        return a1;
    }

    private String memoryInfoHeader(String name) {
        String strHtml = "";
        strHtml += "<table height=\"100\"  width=\"68%\" table border=\"1\" cellspacing=\"0px\" style=\"border-collapse:collapse\"  align='center'>\n";
        strHtml += "<tr><td  colspan='" + "1" + "'   align='center' bgcolor='#F83F7D' style='font-weight:bold;font-size:30'>" + name + " APK NAME</td></tr>\n";
        return strHtml;
    }

    private String memoryInfoContent(ApkTestInfoBean apkTestInfoBean, boolean normal) {
        String bgcolor = "#FAEBD7";
        String strHtml = "";
        strHtml += "<td bgcolor='" + bgcolor + "' width=\"20%\">" + apkTestInfoBean.getFileName() + "</td>\n";
        return strHtml;
    }

    private String htmlend() {
        String strHtml;
        strHtml = "</table>\n";
        strHtml += "</body>\n";
        strHtml += "</html>\n";
        return strHtml;
    }

    private void baseInfoGen(List<String> baseInfos) {
        baseInfos.add("Model：~" + phoneTestInfoBean.getModel());
        baseInfos.add("Date：~" + phoneTestInfoBean.getDate());
        baseInfos.add("TotalNum： ~" + phoneTestInfoBean.getTotalNum());
        for (String status : Constant.status) {
            baseInfos.add(status + "： ~" + phoneTestInfoBean.getAllListMap().get(status).size());
        }
    }

    public void openBrower(String htmlPath, Context context) {
        Intent browseIntent = new Intent();
        browseIntent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse("file://" + htmlPath);
        browseIntent.setData(content_url);
        browseIntent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        browseIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(browseIntent);
    }
}
