package com.example.music.adapters;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.music.HomeActivity;
import com.example.music.R;
import com.example.music.entity.HomePageInfo;
import com.example.music.entity.MusicInfo;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeAdapter extends BaseMultiItemQuickAdapter<HomePageInfo, BaseViewHolder> {

    private final String TAG = "Test_HomeAdapter";

    private Context context;
    private LifecycleOwner lifecycleOwner;

    private static final List<String> title = Arrays.asList("", "", "专属好歌", "每日推荐", "热门金曲");

    public HomeAdapter(Context context, LifecycleOwner lifecycleOwner, @Nullable List<HomePageInfo> data) {
        super(data);
        this.context = context;
        this.lifecycleOwner = lifecycleOwner;
        addItemType(HomePageInfo.STYLE_1, R.layout.banner);
        addItemType(HomePageInfo.STYLE_2, R.layout.item);
        addItemType(HomePageInfo.STYLE_3, R.layout.item);
        addItemType(HomePageInfo.STYLE_4, R.layout.item);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, HomePageInfo homePageInfo) {
        switch (baseViewHolder.getItemViewType()) {
            case HomePageInfo.STYLE_1:
                Log.d(TAG, homePageInfo.toString());
                Banner banner = baseViewHolder.getView(R.id.banner);
                ImageAdapter imageAdapter = new ImageAdapter(context, homePageInfo.getMusicInfoList());
                banner.addBannerLifecycleObserver(lifecycleOwner)//添加生命周期观察者
                        .setAdapter(imageAdapter)
                        .setIndicator(new CircleIndicator(context));
                break;
            case HomePageInfo.STYLE_2:
            case HomePageInfo.STYLE_3:
            case HomePageInfo.STYLE_4:
                initView(baseViewHolder, homePageInfo);
                break;
            default:
                break;
        }
    }

    private void initView(BaseViewHolder baseViewHolder, HomePageInfo homePageInfo) {
        TextView tv_item = baseViewHolder.getView(R.id.tv_item);
        tv_item.setText(title.get(homePageInfo.getItemType()));
        List<MusicInfo> musicInfoList = homePageInfo.getMusicInfoList();
        RecyclerView recyclerView = baseViewHolder.getView(R.id.rv_item);
        ItemAdapter adapterItem = new ItemAdapter(R.layout.item_image, musicInfoList);
        recyclerView.setAdapter(adapterItem);

        if (homePageInfo.getItemType() == 4) {
            recyclerView.setLayoutManager(new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false));
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }


}
