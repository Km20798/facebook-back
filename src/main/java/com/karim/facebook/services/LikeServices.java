package com.karim.facebook.services;

import com.karim.facebook.Model.Post;
import com.karim.facebook.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.karim.facebook.Model.like;

import java.util.List;

@Service
public class LikeServices {

    @Autowired
    private LikeRepository repository ;

    public like AddLike(like like){
        return repository.save(like);
    }

    public List<like> getAllLike(){
        return repository.findAll();
    }

    public List<like> findByPost(Post post){
        return repository.findByPost(post);
    }
}
