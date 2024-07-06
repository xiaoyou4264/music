package com.example.music.adapters;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.music.R;
import com.example.music.entity.MusicInfo;

import java.util.List;

public class ItemAdapter extends BaseQuickAdapter<MusicInfo, BaseViewHolder> {
    public ItemAdapter(int layoutResId, @Nullable List<MusicInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, MusicInfo musicInfo) {
        TextView tv_music_name = holder.getView(R.id.tv_music_name);
        TextView tv_author = holder.getView(R.id.tv_author);
        tv_music_name.setText(musicInfo.getMusicName());
        tv_author.setText(musicInfo.getAuthor());

        ImageView imageView = holder.getView(R.id.iv_item);
        Glide.with(imageView.getContext())
                .load(musicInfo.getCoverUrl())
                .apply(new RequestOptions().transform(new MultiTransformation<>(new CenterCrop(), new RoundedCorners(20))))
                .into(imageView);

    }
}
