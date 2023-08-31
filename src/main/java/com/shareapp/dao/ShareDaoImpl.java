package com.shareapp.dao;

import com.shareapp.model.Share;
import com.shareapp.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShareDaoImpl implements ShareDao{

    @Override
    public void insertShare(Share share) {
        String INSERT_SHARE_SQL = "INSERT INTO share (share_name, username, share_article,created_at) VALUES (?, ?, ?,?)";
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_SHARE_SQL);
            statement.setString(1, share.getShareName());
            statement.setString(2, share.getUsername());
            statement.setString(3, share.getShareArticle());
            statement.setDate(4, Date.valueOf(share.getCreated_at()));

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Share> selectAllShares(String username) {
        String SELECT_ALL_SHARES_SQL = "SELECT id, share_name, share_article,  username FROM share WHERE username = ?";

        List<Share> shares = new ArrayList<>();

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SHARES_SQL);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Share share = new Share();
                share.setId(resultSet.getInt("id"));
                share.setShareName(resultSet.getString("share_name"));
                share.setShareArticle(resultSet.getString("share_article"));
                share.setUsername(resultSet.getString("username"));

                shares.add(share);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return shares;
    }

    @Override
    public Share getShare(String username) {
        String GET_SHARE_SQL = "SELECT share_name, username, share_article,created_at FROM share WHERE username=?";
        Share share=null;
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_SHARE_SQL);

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                share=new Share();
                share.setId(resultSet.getInt("id"));
                share.setShareName(resultSet.getString("share_name"));
                share.setShareArticle(resultSet.getString("share_article"));
                share.setUsername(resultSet.getString("username"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
