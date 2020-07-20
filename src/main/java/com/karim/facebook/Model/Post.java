package com.karim.facebook.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private String post ;

    private Date date ;

    @ManyToOne
    private User user ;

    //Constructors
    public Post() {
    }

    public Post( String post){
        this.post = post;
    }

    //Getter And Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //toString
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", post='" + post + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }

}
