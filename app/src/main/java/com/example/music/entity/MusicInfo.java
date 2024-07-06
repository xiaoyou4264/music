package com.example.music.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MusicInfo {

    private Long id;
    private String musicName;
    private String author;
    private String coverUrl;
    private String musicUrl;
    private String lyricUrl;

    public MusicInfo() {
    }

    public MusicInfo(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public MusicInfo(Long id, String musicName, String author, String coverUrl, String musicUrl, String lyricUrl) {
        this.id = id;
        this.musicName = musicName;
        this.author = author;
        this.coverUrl = coverUrl;
        this.musicUrl = musicUrl;
        this.lyricUrl = lyricUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getLyricUrl() {
        return lyricUrl;
    }

    public void setLyricUrl(String lyricUrl) {
        this.lyricUrl = lyricUrl;
    }
}
