package com.mmc.jhapa.classes.models.adapters;

public class NoticeModel {
    private final String title;
    private final String date;
    private final String noticeBody;

    public NoticeModel(String title, String date, String noticeBody){
        this.title = title;
        this.date = date;
        this.noticeBody = noticeBody;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getNoticeBody() {
        return noticeBody;
    }
}
