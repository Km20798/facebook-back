package com.karim.facebook.controller;

import com.karim.facebook.Model.Comment;
import com.karim.facebook.services.CommentService;
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

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService ;
    @Autowired
    private UserService userService ;
    @Autowired
    private PostServices postServices ;

    //--------------------- Add Comment ----------------------
    @PostMapping("/{email}/{post_id}")
    public ResponseEntity<Comment> addComment(@PathVariable String email , @PathVariable long post_id , @RequestBody Comment comment){
        User user = userService.findByEmail(email);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Post post = postServices.getOne(post_id);
        if(post == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        commentService.addComment(comment);
        return new ResponseEntity<Comment>(comment,HttpStatus.OK);
    }

    //-------------------- Get All Comments ----------------------------
    @GetMapping("/{post_id}")
    public ResponseEntity<List<Comment>> getAllComments( @PathVariable long post_id){
        Post post = postServices.getOne(post_id);
        if(post == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<Comment> comments = commentService.getAll(post);
        if (comments.isEmpty())
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<List<Comment>>(comments , HttpStatus.OK);
    }

    //------------------ Get Comment ---------------------
    @GetMapping("/{post_id}/{id}")
    public ResponseEntity<Comment> getOne( @PathVariable  long post_id , @PathVariable long id){

        Post post = postServices.getOne(post_id);
        if(post == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Comment comment = commentService.getOne(id);
        if (comment == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(comment , HttpStatus.OK);
    }

    //---------------------------- Update Comment -------------------
    @PutMapping("/{post_id}/{id}")
    public ResponseEntity<Comment> updateComment( @PathVariable  long post_id , @PathVariable long id , @RequestBody Comment comment){

        Post post = postServices.getOne(post_id);
        if(post == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Comment currentComment = commentService.getOne(id);
        if (currentComment == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        currentComment.setComment(comment.getComment());
        currentComment.setDate(comment.getDate());
        commentService.updateComment(currentComment);
        return new ResponseEntity<>(comment , HttpStatus.OK);
    }

    //---------------------- delete Comment  ------------------------
    @DeleteMapping("/{user_id}/{post_id}/{id}")
    public ResponseEntity<?> deleteComment( @PathVariable  long post_id , @PathVariable long id){

        Post post = postServices.getOne(post_id);
        if(post == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Comment comment = commentService.getOne(id);
        if (comment == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //---------------------- delete All --------------------------
    @DeleteMapping("/{post_id}")
    public ResponseEntity<?> deleteAll( @PathVariable  long post_id ){
        Post post = postServices.getOne(post_id);
        if(post == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<Comment> comments = commentService.getAll(post     );
        if (comments.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        commentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
