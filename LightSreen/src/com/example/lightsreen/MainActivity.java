package com.example.lightsreen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btnLin;
	private EditText edtInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnLin = (Button) this.findViewById(R.id.btn_msg);
		edtInput = (EditText) this.findViewById(R.id.edt_input_num);
		btnLin.setOnClickListener(new View.OnClickListener() {
			@SuppressWarnings("deprecation")
			@SuppressLint("Wakelock")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String numStr = edtInput.getText().toString();
				int number = 0;
				if (!numStr.equals("") && numStr != null) {
					number = Integer.parseInt(numStr);
					PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
					PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK, "bright");
					for (int i = 0; i < number; i++) {
						try {
							pm.goToSleep(SystemClock.uptimeMillis());
							Thread.sleep(1000);
							wl.acquire();
							wl.release();
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					Toast.makeText(MainActivity.this, "执行次数不能为空", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

}
