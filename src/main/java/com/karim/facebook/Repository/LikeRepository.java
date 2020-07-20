package com.karim.facebook.Repository;

import com.karim.facebook.Model.Post;
import com.karim.facebook.Model.like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<like , Long> {
    List<like> findByPost(Post post);
}
