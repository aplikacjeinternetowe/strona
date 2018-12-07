package com.projekt.strona.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void deleteItem(String id) {
        String sql = "DELETE FROM item WHERE item_id=?";
        jdbcTemplate.update(sql, id);
    }
}