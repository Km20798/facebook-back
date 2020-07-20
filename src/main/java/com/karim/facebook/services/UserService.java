package com.karim.facebook.services;

import com.karim.facebook.Model.User;
import com.karim.facebook.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository ;


    public User addUser(User user){
        return repository.save(user);
    }

    public List<User> getAllUser(){
        return repository.findAll();
    }

    public User getUser(long id){
        return repository.findById(id).get();
    }
    public User updateUser(User user){
        return repository.save(user);
    }

    public void deleteUser(long id ){
        repository.deleteById(id);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public User findByEmail(String email){
        User user = repository.findByEmail(email);
        if (user == null)
            return null;
        return user;
    }

    public User findByEmailAndPassword(String email , String password){
        return repository.findByEmailAndPassword(email , password);
    }
}
