package com.river.entity;

import java.util.Date;

public class UploadFile {
    private String id;

    private String userId;

    private String snacksId;

    private String url;

    private String fileName;

    private Date reateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSnacksId() {
        return snacksId;
    }

    public void setSnacksId(String snacksId) {
        this.snacksId = snacksId == null ? null : snacksId.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Date getReateTime() {
        return reateTime;
    }

    public void setReateTime(Date reateTime) {
        this.reateTime = reateTime;
    }
}