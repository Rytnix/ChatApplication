package com.leapAssignment.ChatApplication.service;


import com.leapAssignment.ChatApplication.config.entity.User;
import com.leapAssignment.ChatApplication.config.exception.UserException;
import com.leapAssignment.ChatApplication.config.middlewareRequest.UpdateUserRequest;

import java.util.List;

public interface UserService {
	
	public User findUserProfile(String jwt);
	
	public User updateUser(Integer userId, UpdateUserRequest req) throws UserException;
	
	public User findUserById(Integer userId) throws UserException;
	
	public List<User> searchUser(String query);
}
