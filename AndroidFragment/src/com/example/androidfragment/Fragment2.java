package com.example.androidfragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {

	private Button btnGetData;
	private TextView tvFragment1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment2, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		btnGetData = (Button) getActivity().findViewById(R.id.btn_fragment2_getdata);
		btnGetData.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tvFragment1 = (TextView) getActivity().findViewById(R.id.tv_fragment1_display);
				Toast.makeText(getActivity(), tvFragment1.getText(), Toast.LENGTH_LONG).show();
				;
			}
		});
	}
}
