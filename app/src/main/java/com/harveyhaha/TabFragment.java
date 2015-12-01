package com.harveyhaha;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Function:
 * <br/>
 * Create on:2015/12/1 11:42
 * <br/>
 * Author:WuTengFei
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TabFragment extends Fragment {
    View view;
    private TextView titleTv;
    private String title;

    public static TabFragment getInstance(String title) {
        TabFragment tab = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        tab.setArguments(bundle);
        return tab;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment, null);
        titleTv = (TextView) view.findViewById(R.id.title);
        if (!TextUtils.isEmpty(title))
            titleTv.setText(title);
        return view;
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        title = (String) args.get("title");
    }
}
