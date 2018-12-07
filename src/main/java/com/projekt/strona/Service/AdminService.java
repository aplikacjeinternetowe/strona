package com.projekt.strona.Service;

import com.projekt.strona.Dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;
    public void deleteItem(String id) {
        this.adminDao.deleteItem(id);
    }
}
