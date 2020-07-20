package com.karim.facebook.Model;

import javax.persistence.*;

@Entity
@Table(name = "myLike")
public class like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    @OneToOne
    private User user ;

    @ManyToOne
    private Post post;

    private int active ;

    public like() {
    }

    public like(User user , Post post) {
        this.user = user;
        this.post = post;
        this.active = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
