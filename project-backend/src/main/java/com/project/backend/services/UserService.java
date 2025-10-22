package com.project.backend.services;

import com.project.backend.entities.User;
import java.util.List;

public interface UserService{

<<<<<<< HEAD
    public List<User> getAllUsers();

    public User getUserById(int uid);

    public User saveUser(User user);

    void updateUserName(String firstName, String lastName,int userId);
=======
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


>>>>>>> 6f40d21c9e6f50ad11136398ebf97eef7ca50660
}
