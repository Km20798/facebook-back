package com.karim.facebook.Repository;

import com.karim.facebook.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email , String password);
    User findByEmail(String email);
    List<User> findByFirstname(String firstname);
}
