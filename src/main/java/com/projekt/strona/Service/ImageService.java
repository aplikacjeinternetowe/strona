package com.projekt.strona.Service;

import com.projekt.strona.Dao.ImageDao;
import com.projekt.strona.Entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ImageService {

    @Autowired
    private ImageDao imageDao;

    public void addImageLinkToDatabase(String[] imgList, int itemId) {
        imageDao.addImageLinkToDatabase(imgList, itemId);
    }

    public Collection<Image> getImageName(String id1) {
        return this.imageDao.getImageName(id1);
    }
}
