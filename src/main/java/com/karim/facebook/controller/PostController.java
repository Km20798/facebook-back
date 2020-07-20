package com.karim.facebook.controller;

import com.karim.facebook.Model.Post;
import com.karim.facebook.services.PostServices;
import com.karim.facebook.Model.User;
import com.karim.facebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostServices postServices ;
    @Autowired
    private UserService userService;

    //--------------- Add Post -----------------------
    @PostMapping("/{email}")
    public ResponseEntity<Post> addPost(@PathVariable String email , @RequestBody Post post){
        User user = userService.findByEmail(email);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        post.setUser(user);
        postServices.addPost(post);
        return new ResponseEntity<Post>(post , HttpStatus.OK);
    }

    //---------------- Get All Posts -------------------
    @GetMapping
    public ResponseEntity<List<Post>> getAll(){
        List<Post> posts = postServices.getAll();
        if (posts.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Post>>(posts , HttpStatus.OK);
    }

    //--------------- Get Post -------------------------
    @GetMapping("/{email}/{id}")
    public ResponseEntity<Post> getOne(@PathVariable long id , @PathVariable String email){
        User user = userService.findByEmail(email);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Post post = postServices.getOne(id);
        if (post == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }

    //--------------------- update Post ---------------------
    @PutMapping("/{user_id}/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable long user_id ,  @PathVariable long id , @RequestBody Post post){
        User user =userService.getUser(user_id);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Post currentPost = postServices.getOne(id);
        if (currentPost == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        currentPost.setDate(post.getDate());
        currentPost.setPost(post.getPost());
        postServices.updatePost(post);
        return new ResponseEntity<Post>(currentPost , HttpStatus.OK);
    }

    //-------------------- delete Post --------------------------
    @DeleteMapping("/{user_id}/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable long user_id , @PathVariable long id){
        User user = userService.getUser(user_id);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Post post = postServices.getOne(id);
        if (post == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        postServices.deleteOne(post);
        return new ResponseEntity<Post>(HttpStatus.OK);
    }

    //----------------------- delete All ----------------------------
    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        List<Post> posts = postServices.getAll();
        if (posts.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        postServices.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //------------------------ Posts of User ----------------
    @GetMapping("/{user_id}")
    public ResponseEntity<List<Post>> findByUser(@PathVariable long user_id){
        User user = userService.getUser(user_id);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<Post> posts = postServices.findByUser(user);
        return new ResponseEntity<List<Post>>(posts , HttpStatus.OK);
    }
}
