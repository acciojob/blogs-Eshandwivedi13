package com.driver.models;
import javax.persistence.*;
@Entity
public  class Image{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String dimensions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image(String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
    }
    public Image() {

    }

    public String getDescription() {
        return description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}