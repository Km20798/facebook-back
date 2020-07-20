package com.karim.facebook.services;

import com.karim.facebook.Model.Post;
import com.karim.facebook.Repository.PostRepository;
import com.karim.facebook.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServices {

    @Autowired
    private PostRepository repository ;

    public Post addPost(Post post){
        post.setDate(new Date());
        return repository.save(post);
    }

    public Post updatePost(Post post){
        return repository.save(post);
    }

    public List<Post> getAll(){
        return repository.findAll();
    }

    public Post getOne(long id){
        return repository.findById(id).get();
    }

    public void deleteOne(Post post){
        repository.delete(post);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public List<Post> findByUser(User user){
        return repository.findByUser(user);
    }

}
