package com.karim.facebook.services;

import com.karim.facebook.Model.Comment;
import com.karim.facebook.Model.Post;
import com.karim.facebook.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository ;

    public Comment addComment(Comment comment){
        comment.setDate(new Date());
        return repository.save(comment);
    }

    public List<Comment> getAll(Post post){
        return repository.findByPost(post);
    }

    public Comment getOne(long id){
        return repository.findById(id).get();
    }

    public Comment updateComment(Comment comment){
        return repository.save(comment);
    }

    public void deleteComment(long id){
        repository.deleteById(id);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}
