package com.karim.facebook.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private String comment ;

    private Date date  ;

    @ManyToOne
    private User user ;

    @ManyToOne
    private Post post ;

    //Constructor
    public Comment() {
    }

    public Comment(String comment){
        this.comment = comment;
    }

    //Setter And Getter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    //toString
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
