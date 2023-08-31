package com.shareapp.dao;

import com.shareapp.model.Share;

import java.util.List;

public interface ShareDao {
    void insertShare(Share share);

    List<Share> selectAllShares(String username);
    Share getShare(String username);
}
