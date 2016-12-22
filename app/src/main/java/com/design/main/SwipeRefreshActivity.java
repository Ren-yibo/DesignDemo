package com.design.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.design.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 任益波
 * @date 2016/10/14
 * @description
 */
public class SwipeRefreshActivity extends AppCompatActivity {

    private SwipeRefreshLayout mSwipeLay;
    private TextView mSwipeTv;
    private RecyclerView recycleView;
    private RecycleAdapter adapter;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        mSwipeLay = (SwipeRefreshLayout) findViewById(R.id.swipeLay);
        mSwipeTv = (TextView) findViewById(R.id.refreshTv);
        recycleView = (RecyclerView) findViewById(R.id.recycleView);
        mList = new ArrayList<>();
        mList.add("Postion 1");
        mList.add("Postion 2");
        mList.add("Postion 3");
        mList.add("Postion 4");
        mList.add("Postion 5");
        mList.add("Postion 6");
        mList.add("Postion 7");
        mList.add("Postion 8");
        mList.add("Postion 9");
        mList.add("Postion 10");
        adapter = new RecycleAdapter(mList, this);

        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setItemAnimator(new DefaultItemAnimator());
        recycleView.setAdapter(adapter);

        mSwipeLay.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light);
        mSwipeLay.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeTv.setText("Refreshimg...");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeLay.setRefreshing(false);
                        mSwipeTv.setText("Refresh Finished");
                    }
                }, 2000);
            }
        });
    }
}
