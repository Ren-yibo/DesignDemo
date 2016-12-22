package com.design.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.design.R;

/**
 * @author 任益波
 * @date 2016/10/17
 * @description
 */
public class TabFragment extends Fragment {

    private View rootView;
    private TextView tv;
    private String str;

    public TabFragment(String str) {
        this.str = str;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.item_fragment, container, false);
        tv = (TextView) rootView.findViewById(R.id.fragmentTv);
        tv.setText(str);
        return rootView;
    }

}
