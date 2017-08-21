package com.xiao.nicevieoplayer.example.adapter.holder;

import android.content.Context;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;
import com.xiao.nicevieoplayer.R;
import com.xiao.nicevieoplayer.example.base.BaseArrayAdapter;
import com.xiao.nicevieoplayer.example.base.BaseViewHolder;
import com.xiao.nicevieoplayer.example.bean.Video;

/**
 * Created by Zheng on 2017/8/17.
 */

public class ListViewVideoHolder extends BaseViewHolder<Video> {

    private NiceVideoPlayer mVideoPlayer;
    private VideoViewHolder holder;
    private TxVideoPlayerController controller;

    @Override
    public BaseViewHolder onCreateViewHolder(View v) {
        mVideoPlayer = (NiceVideoPlayer) v.findViewById(R.id.nice_video_player);
        ViewGroup.LayoutParams params = mVideoPlayer.getLayoutParams();
        params.width = v.getResources().getDisplayMetrics().widthPixels; // 宽度为屏幕宽度
        params.height = (int) (params.width * 9f / 16f);    // 高度为宽度的9/16
        mVideoPlayer.setLayoutParams(params);

        return this;
    }

    @Override
    public void onBindViewHolder(Context context, Video video) {
        controller = new TxVideoPlayerController(context);
        controller.setTitle(video.getTitle());
        controller.setLenght(video.getLength());
        Glide.with(context)
                .load(video.getImageUrl())
                .placeholder(R.drawable.img_default)
                .crossFade()
                .into(controller.imageView());
        mVideoPlayer.setController(controller);
        mVideoPlayer.setUp(video.getVideoUrl(), null);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_video;
    }
}
