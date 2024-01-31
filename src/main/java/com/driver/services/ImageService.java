package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog

        //Get the blog
        Optional<Blog> optBlog = blogRepository2.findById(blogId);
        Blog blog = optBlog.get();

        //create ImageEntityObj
        Image imageEntityObj = new Image(description, dimensions);

        //set the parent in child, update the child on parent
        imageEntityObj.setBlog(blog);
        blog.getImageList().add(imageEntityObj);

        //save anyone
        blogRepository2.save(blog);
        return imageEntityObj;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //is image id se image get karke dimension get karke aur kitni same dimensionImages can fit screenSize
        Image image = imageRepository2.findById(id).get();
        String[] imageDim = image.getDimensions().split("X");
        int imageWidth = Integer.parseInt(imageDim[0]);//X ke pehle
        int imageHeight = Integer.parseInt(imageDim[1]);//X ke baad

        String[] screenDim = screenDimensions.split("X");
        int screenWidth = Integer.parseInt(screenDim[0]);
        int screenHeight = Integer.parseInt(screenDim[1]);

        int numOfImages = (screenWidth / imageWidth) * (screenHeight / imageHeight);//
        return numOfImages;
    }
}
