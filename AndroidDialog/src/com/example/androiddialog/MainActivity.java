package com.example.androiddialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {
	private Button btnNew;
	private Button btnSure;
	private Button btnTxt;
	private Button btnRadio;
	private Button btnChoice;
	private Button btnList;
	private Button btnPic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnNew = (Button) this.findViewById(R.id.btn_dialog_new);
		btnSure = (Button) this.findViewById(R.id.btn_dialog_sure);
		btnTxt = (Button) this.findViewById(R.id.btn_dialog_txt);
		btnRadio = (Button) this.findViewById(R.id.btn_dialog_radio);
		btnChoice = (Button) this.findViewById(R.id.btn_dialog_choice);
		btnList = (Button) this.findViewById(R.id.btn_dialog_list);
		btnPic = (Button) this.findViewById(R.id.btn_dialog_pic);
		btnNew.setOnClickListener(this);
		btnSure.setOnClickListener(this);
		btnTxt.setOnClickListener(this);
		btnRadio.setOnClickListener(this);
		btnChoice.setOnClickListener(this);
		btnList.setOnClickListener(this);
		btnPic.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Builder dialog;
		dialog = new AlertDialog.Builder(this);
		dialog.setTitle("hello");
		switch (v.getId()) {
		case R.id.btn_dialog_new:
			dialog.setMessage("简单消息框");
			dialog.setPositiveButton("确定", null);
			dialog.show();
			break;
		case R.id.btn_dialog_sure:
			dialog.setMessage("确定吗？");
			dialog.setPositiveButton("确定", null);
			dialog.setNegativeButton("取消", null);
			dialog.show();
			break;
		case R.id.btn_dialog_txt:
			dialog.setIcon(android.R.drawable.ic_dialog_info);
			dialog.setView(new EditText(this));
			dialog.setPositiveButton("确定", null);
			dialog.setNegativeButton("取消", null);
			dialog.show();
			break;
		case R.id.btn_dialog_radio:
			dialog.setSingleChoiceItems(new String[] { "选项1", "选项2", "选项3", "选项4" }, 0, null);
			// dialog.setSingleChoiceItems(new String[] { "选项1", "选项2", "选项3", "选项4" }, 0, new DialogInterface.OnClickListener() {
			//
			// @Override
			// public void onClick(DialogInterface dialogInf, int arg1) {
			// // TODO Auto-generated method stub
			// dialogInf.dismiss();
			// }
			// });
			dialog.setNegativeButton("取消", null);
			dialog.show();
			break;
		case R.id.btn_dialog_choice:
			dialog.setMultiChoiceItems(new String[] { "选项1", "选项2", "选项3", "选项4" }, null, null);
			dialog.setPositiveButton("确定", null);
			dialog.setNegativeButton("取消", null);
			dialog.show();
			break;
		case R.id.btn_dialog_list:
			dialog.setItems(new String[] { "列表1", "列表2", "列表3", "列表4" }, null);
			dialog.setPositiveButton("确定", null);
			dialog.setNegativeButton("取消", null);
			dialog.show();
			break;
		case R.id.btn_dialog_pic:
			ImageView img = new ImageView(this);
			img.setImageResource(R.drawable.ic_launcher);
			dialog.setView(img);
			dialog.setPositiveButton("确定", null);
			dialog.setNegativeButton("取消", null);
			dialog.show();
			break;
		default:
			break;
		}
	}

}
