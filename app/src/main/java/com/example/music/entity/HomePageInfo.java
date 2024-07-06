package com.example.music.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class HomePageInfo implements MultiItemEntity {

    public static final int STYLE_1 = 1;
    public static final int STYLE_2 = 2;
    public static final int STYLE_3 = 3;
    public static final int STYLE_4 = 4;


    private int moduleConfigId;
    private String moduleName;
    private int style;
    private List<MusicInfo> musicInfoList;

    public HomePageInfo() {
    }

    public HomePageInfo(int moduleConfigId, String moduleName, int style, List<MusicInfo> musicInfoList) {
        this.moduleConfigId = moduleConfigId;
        this.moduleName = moduleName;
        this.style = style;
        this.musicInfoList = musicInfoList;
    }

    public int getModuleConfigId() {
        return moduleConfigId;
    }

    public void setModuleConfigId(int moduleConfigId) {
        this.moduleConfigId = moduleConfigId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public List<MusicInfo> getMusicInfoList() {
        return musicInfoList;
    }

    public void setMusicInfoList(List<MusicInfo> musicInfoList) {
        this.musicInfoList = musicInfoList;
    }

    @Override
    public int getItemType() {
        return style;
    }

    @Override
    public String toString() {
        return "HomePageInfo{" +
                "moduleConfigId=" + moduleConfigId +
                ", moduleName='" + moduleName + '\'' +
                ", style=" + style +
                ", musicInfoList=" + musicInfoList +
                '}';
    }
}
