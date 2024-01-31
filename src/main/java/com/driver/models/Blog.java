package  com.driver.models;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
//@Table  => Not compulsory, its for additional information like tableName etc
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    @CreationTimestamp//this means, currDate jab publish/create ho rha blog
    private Date pubDate;
    @ManyToOne
    @JoinColumn
    private User user;//it automatically stores userId as fkey

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Image> imageList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Image> getImageList() {
        return imageList;
    }
    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public Blog(){
    }
    public String getTitle() {
        return title;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

}
