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
        Image image = imageRepository2.save(imageEntityObj);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {//image id, screenSize
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        Image image = imageRepository2.findById(id).get();
        String[] imageDim = image.getDimensions().split("X");
        int imageWidth = Integer.parseInt(imageDim[0]);
        int imageHeight = Integer.parseInt(imageDim[1]);

        String[] screenDim = screenDimensions.split("X");
        int screenWidth = Integer.parseInt(screenDim[0]);
        int screenHeight = Integer.parseInt(screenDim[1]);

        int numOfImages = (screenWidth / imageWidth) * (screenHeight / imageHeight);
        return numOfImages;
    }
}
