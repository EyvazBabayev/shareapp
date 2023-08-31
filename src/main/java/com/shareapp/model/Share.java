package com.shareapp.model;

import java.time.LocalDateTime;

public class Share {
    private int id;
    private String shareName;
    private String username;
    private String shareArticle;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShareArticle() {
        return shareArticle;
    }

    public void setShareArticle(String shareArticle) {
        this.shareArticle = shareArticle;
    }

    public String getCreated_at() {
        return String.valueOf(created_at);
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
