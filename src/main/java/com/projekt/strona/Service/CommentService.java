package com.projekt.strona.Service;

import com.projekt.strona.Dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    public void addComment(String commentContent, String commentTarget, String userName) {
        commentDao.addComment(commentContent,commentTarget,userName);
    }
}
