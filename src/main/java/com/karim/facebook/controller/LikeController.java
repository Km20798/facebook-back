package com.karim.facebook.controller;

import com.karim.facebook.Model.Post;
import com.karim.facebook.Model.like;
import com.karim.facebook.services.CommentService;
import com.karim.facebook.services.LikeServices;
import com.karim.facebook.services.PostServices;
import com.karim.facebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.karim.facebook.Model.like;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private UserService userService ;
    @Autowired
    private PostServices postServices ;
    @Autowired
    private CommentService commentService ;
    @Autowired
    private LikeServices likeServices ;

//    ----------------------------------  Add Like ------------------------
    @PostMapping("")
    public ResponseEntity<like> AddLike(@RequestBody like like){
        likeServices.AddLike(like);
        return new ResponseEntity<like>(like , HttpStatus.OK);
    }

//    --------------------------------- get All Like For Post ---------------------
    @GetMapping("/{post_id}")
    public ResponseEntity<List<like>> getAll(@PathVariable int post_id){
        Post post = postServices.getOne(post_id);
        if(post == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<like> likes = likeServices.findByPost(post);
        return new ResponseEntity<List<like>>(likes , HttpStatus.OK);
    }
}
