package com.projekt.strona.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addImageLinkToDatabase(String[] imgList, int itemId) {
        String sql = "INSERT INTO image (image_name,item_id) VALUES (?,?)";
        for (int i = 1; i < imgList.length; i++) {
            jdbcTemplate.update(sql, new Object[]{imgList[i], itemId});
        }
    }
}
