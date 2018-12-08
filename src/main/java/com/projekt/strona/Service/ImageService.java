package com.projekt.strona.Service;

import com.projekt.strona.Dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageDao imageDao;

    public void addImageLinkToDatabase(String[] imgList, int itemId) {
        imageDao.addImageLinkToDatabase(imgList, itemId);
    }
}
