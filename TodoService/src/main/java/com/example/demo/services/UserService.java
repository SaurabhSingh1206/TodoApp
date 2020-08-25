package com.example.demo.services;

import java.util.List;

import com.example.demo.ui.dto.UserDto;


public interface UserService {

	public UserDto createUser(UserDto user);
	public UserDto getUserByUserId(String userId);
	public void deleteUser(String userId);

}
