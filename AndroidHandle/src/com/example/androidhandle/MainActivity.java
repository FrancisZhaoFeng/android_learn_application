package com.example.androidhandle;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private final static String Tag = "MainActivity";
	private Button btnDownload;
	private Dialog dialog;
	private View vdialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnDownload = (Button) this.findViewById(R.id.btn_download);
		btnDownload.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("下载资源");
				vdialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null);
				builder.setView(vdialog);
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
					}
				});
				dialog = builder.create();
				dialog.show();
				((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
				new Thread(threadDown).start();
			}
		});
	}

	@SuppressLint("HandlerLeak")
	public Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			Button btnSure = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
			btnSure.setEnabled(true);
			TextView tv = (TextView) vdialog.findViewById(R.id.tv_dialog);
			tv.setText(R.string.downloaded);
			tv.setText(msg.getData().getString("status"));
			switch (msg.arg1) {
			case 0:
				Log.e(Tag, "arg1:" + msg.arg1);
				tv.setBackgroundColor(Color.rgb(131, 196, 125));
				break;
			case 1:
				Log.e(Tag, "arg1:" + msg.arg1);
				tv.setBackgroundColor(Color.rgb(247, 9, 171));
				new Thread(threadDown).start();
				break;
			default:
				break;
			}
		}
	};

	Runnable threadDown = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep((new Random().nextInt(5) + 3) * 1000);
				int num = new Random().nextInt(2);
				Message message = new Message();
				Bundle bundle = new Bundle();
				message.arg1 = num;
				if (num == 0) {
					bundle.putString("status", "下载成功&&下载成功&&下载成功&&下载成功&&下载成功&&下载成功&&下载成功");
				} else {
					bundle.putString("status", "下载失败,重新下载中&&下载失败,重新下载中&&下载失败,重新下载中&&下载失败,重新下载中");
				}
				message.setData(bundle);
				handler.sendMessage(message);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

}
