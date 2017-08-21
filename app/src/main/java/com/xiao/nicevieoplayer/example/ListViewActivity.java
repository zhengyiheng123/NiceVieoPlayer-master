package com.xiao.nicevieoplayer.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.xiao.nicevieoplayer.R;
import com.xiao.nicevieoplayer.example.adapter.holder.ListViewVideoHolder;
import com.xiao.nicevieoplayer.example.base.BaseArrayAdapter;
import com.xiao.nicevieoplayer.example.util.DataUtil;

/**
 * Created by Zheng on 2017/8/17.
 */

public class ListViewActivity extends AppCompatActivity {
    //zhengyiheng
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        initView();
    }

    private void initView() {
        ListView lv_video= (ListView) findViewById(R.id.lv_video);
        lv_video.setAdapter(new BaseArrayAdapter<>(getApplicationContext(), new BaseArrayAdapter.OnCreateViewHolderListener() {
            @Override
            public Object onCreateViewHolder() {
                return new ListViewVideoHolder();
            }
        }, DataUtil.getVideoListData()));

    }
}
