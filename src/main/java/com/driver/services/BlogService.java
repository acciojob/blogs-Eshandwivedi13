package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

        //Get the userEntity from Db
        Optional<User> optUser = userRepository1.findById(userId);
        User user = optUser.get();

        // createBlog Entity
        Blog blogEntityObj = new Blog(title, content);
        //Copied wala -> .getInstance se calenderObj milta aur .getTime se dateObj
        blogEntityObj.setPubDate(Calendar.getInstance().getTime());//had to set it manually, @CreationTimestamp not working bruh


        //set parent in child, and update childList in parent
        blogEntityObj.setUser(user);
        user.getBlogList().add(blogEntityObj);//no need to set, just add and save any 1thing

        //save parent or child other automatically save ho jata
         userRepository1.save(user);
        return blogEntityObj;

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);

    }
}
