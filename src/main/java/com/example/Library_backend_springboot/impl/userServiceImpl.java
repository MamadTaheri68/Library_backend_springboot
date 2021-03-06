package com.example.Library_backend_springboot.impl;

import com.example.Library_backend_springboot.Repository.userRepository;
import com.example.Library_backend_springboot.model.userModel;
import com.example.Library_backend_springboot.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements userService {

    @Autowired
    userRepository userRepositoryObj;

    @Override
    public List<userModel> getAllusers() {
            return userRepositoryObj.findAll();
    }

    @Override
    public Integer saveNewUser(userModel user) {
        try {
            userRepositoryObj.save(user);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Optional<userModel> getUser(Integer id) {
        return userRepositoryObj.findById(id);
    }

    @Override
    public String updateUser(userModel userModel) {
        try {
            userModel tempUserModel = userRepositoryObj.getById(userModel.getId());
            tempUserModel.setName(userModel.getName());
            tempUserModel.setFamily(userModel.getFamily());
            tempUserModel.setSocialNumber(userModel.getSocialNumber());
            userRepositoryObj.save(tempUserModel);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "server error";
        }
    }
}
