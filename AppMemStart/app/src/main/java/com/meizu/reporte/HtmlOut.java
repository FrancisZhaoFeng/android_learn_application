package com.meizu.reporte;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import com.meizu.common.Contants;
import com.meizu.domain.AppMemMapInfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlOut {
    private String TAG = "HtmlOut";
    private List<String> showColumn;
    List<Integer> showAvg = new ArrayList<>();

    public void creathtml(List<AppMemMapInfo> appMemMapInfos, String htmlName, List<String> showColums) {
        try {
            mkDirs(Contants.HTML_PATH);
            this.showColumn = showColums;

            Collections.sort(appMemMapInfos); //根据包名进行排序
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlName, false)));

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
            String packName = "";
            int numPackName = 0;
//            AppMemMapInfo tempAppMemMapInfos = appMemMapInfos.get(0);
            Map<String, Integer> tempAvgMap = new HashMap<>();
            for (int i = 0; i < appMemMapInfos.size(); i++) {
                AppMemMapInfo appMemMapInfo = appMemMapInfos.get(i);
                if (!packName.equals(appMemMapInfo.getPackageName())) {//当前包名 与 上一个 包名不一样时，写 平均数 和 下一个包的头部
                    if (!packName.equals("")) {
                        bufferedWriter.write("<tr>\n");
                        bufferedWriter.write(memoryInfoContent(new AppMemMapInfo(packName, tempAvgMap), false, numPackName));
                        bufferedWriter.write("</tr>\n");
                        bufferedWriter.write("</table>\n");
                        tempAvgMap = new HashMap<>();
                        numPackName = 0;
                    }
                    bufferedWriter.write("<br/>\n");
                    bufferedWriter.write(memoryInfoHeader(appMemMapInfo.getPackageName()));
                    packName = appMemMapInfo.getPackageName();
                }
                numPackName++;
                for (int j = 0; j < showColums.size(); j++) {
                    if (!appMemMapInfo.getMapData().containsKey(showColums.get(j)))
                        continue;
                    int tempInt = 0;
                    if (tempAvgMap.containsKey(showColums.get(j)))
                        tempInt = tempAvgMap.get(showColums.get(j));
                    tempAvgMap.put(showColums.get(j), tempInt + appMemMapInfo.getMapData().get(showColums.get(j)));
                    Log.i(TAG, "creathtml Num= " + numPackName + "," + showColums.get(j) + " value is : " + tempInt + " + " + appMemMapInfo.getMapData().get(showColums.get(j)) + " = " + tempAvgMap.get(showColums.get(j)));
                }

                bufferedWriter.write("<tr>\n");
                bufferedWriter.write(memoryInfoContent(appMemMapInfo, true, 1));
                bufferedWriter.write("</tr>\n");
            }
            bufferedWriter.write("<tr>\n");
            bufferedWriter.write(memoryInfoContent(new AppMemMapInfo(packName, tempAvgMap), false, numPackName));
            bufferedWriter.write("</tr>\n");
            bufferedWriter.write("</table>\n");

            //尾部
            bufferedWriter.write(htmlend());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String htmlTop() {
        String strHtml;
        strHtml = "<html>\n";
        strHtml += "<body>\n";
        strHtml += "<head>\n";
        strHtml += "<title>MEIZU_内存启动测试</title>\n";
        strHtml += "</head>\n";
        return strHtml;
    }

    private String baseInfoHeader() {
        String strHtml;
        strHtml = "<br/>";
        strHtml += "<h1 align='center'>应用内存启动测试</h1></div>\n";
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

    private String memoryInfoHeader(String packageName) {
        String strHtml = "";
        strHtml += "<table height=\"100\"  width=\"68%\" table border=\"1\" cellspacing=\"0px\" style=\"border-collapse:collapse\"  align='center'>\n";
        strHtml += "<tr><td  colspan='" + showColumn.size() + "'   align='center' bgcolor='#F83F7D' style='font-weight:bold;font-size:30'>" + packageName + " Memory Infomation</td></tr>\n";
        strHtml += "<tr>\n";
        for (String column : showColumn) {
            strHtml += "<td bgcolor='#92D999' width=\"20%\">" + column + "</td>\n";
        }
        strHtml += "<tr>\n";
        return strHtml;
    }

    private String memoryInfoContent(AppMemMapInfo appMemMapInfo, boolean normal, int time) {
        String bgcolor = "#92D999";
        if (!normal)
            bgcolor = "#FAEBD7";
        String strHtml = "";
        for (String column : showColumn) {
            Log.i(TAG, "memoryInfoContent column：" + column);
            if (appMemMapInfo.getMapData().containsKey(column))
                strHtml += "<td bgcolor='" + bgcolor + "' width=\"20%\">" + appMemMapInfo.getMapData().get(column) / time + "</td>\n";
            else
                strHtml += "<td bgcolor='" + bgcolor + "' width=\"20%\">" + null + "</td>\n";
        }
        return strHtml;
    }

    private String htmlend() {
        String strHtml;
        strHtml = "</table>\n";
        strHtml += "</body>\n";
        strHtml += "</html>\n";
        return strHtml;
    }

    public void mkDirs(String sdPath) throws IOException {
        Log.e("mkdir", sdPath);
        File file = new File(sdPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private void baseInfoGen(List<String> baseInfos) {
        baseInfos.add("Model：~" + android.os.Build.DEVICE);
        baseInfos.add("Date：~" + Contants.getTime());
        baseInfos.add("Version： ~" + Build.VERSION.RELEASE);
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
