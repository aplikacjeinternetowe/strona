package com.projekt.strona.Service;

import com.projekt.strona.Dao.UserDao;
import com.projekt.strona.Entity.Comment;
import com.projekt.strona.Entity.Item;
import com.projekt.strona.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(String username, String password, String phone_number) {
        userDao.addUser(username,encode(password),phone_number);
    }

    public static String encode(String password){
        int i = 0;
        String hashedPassword = "";
        while (i<10){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            hashedPassword = passwordEncoder.encode(password);
            i++;
        }
        return hashedPassword;
    }

    public String getUserPhoneNumberByItemId(int id) {
        return this.userDao.getUserPhoneNumberByItemId(id);
    }

    public User getUserDetails(String userName) {
        return this.userDao.getUserDetails(userName);
    }

    public Collection<Item> getUserPosts(String userName) {
        return this.userDao.getUserPosts(userName);
    }

    public Collection<Comment> getUserComments(String userName) {
        return this.userDao.getUserComments(userName);
    }
}
