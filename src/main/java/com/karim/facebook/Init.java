package com.karim.facebook;

import com.karim.facebook.Model.Comment;
import com.karim.facebook.services.CommentService;
import com.karim.facebook.Model.Post;
import com.karim.facebook.services.PostServices;
import com.karim.facebook.Model.User;
import com.karim.facebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Date;

@Configuration
@Service
public class Init implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private PostServices postServices;
    @Autowired
    private CommentService commentService ;



    @Override
    public void run(String... args) throws Exception {

        //Add User called user
        User user = new User("Karim" , "Mohamed" , "kmaged207@gmail.com" , "kmaged207"  , new Date() , "male");
        userService.addUser(user);

        //Add Post to user called post
        Post post = new Post("I love you Tota");
        post.setUser(user);
        postServices.addPost(post);

        //Add Comment to post with User user called comment
        Comment comment = new Comment("First Comment");
        comment.setPost(post);
        comment.setUser(user);
        commentService.addComment(comment);

        //Add User called user2
        User user2 = new User("ahmed" , "Mohamed" , "ahmed@gmail.com" , "ahmed123"  , new Date() , "male");
        userService.addUser(user2);

        //Add Post to user called post2
        Post post2 = new Post("Welcome in my application this is my secand post");
        post2.setUser(user2);
        postServices.addPost(post2);

        //Add Comment to post2 with User user called comment2
        Comment comment2 = new Comment("secand Comment");
        comment2.setPost(post2);
        comment2.setUser(user2);
        commentService.addComment(comment2);




    }


}
