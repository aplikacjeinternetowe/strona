package com.projekt.strona.Service;

import com.projekt.strona.Dao.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardService {
    @Autowired
    private BoardDao boardDao;

    public void addItem(String itemName, String itemDescription, String itemPrice, String userName) {
        boardDao.addItem(itemName,itemDescription,itemPrice,userName);
    }

}
