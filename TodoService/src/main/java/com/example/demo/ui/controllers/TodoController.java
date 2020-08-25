package com.example.demo.ui.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.ui.dto.UserDto;
import com.example.demo.ui.entity.UserEntity;
import com.example.demo.ui.model.request.UserDetailsRequestModel;
import com.example.demo.ui.model.response.UserRest;


@Controller
public class TodoController {

	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails)throws Exception
	{	
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		UserDto createdUser = userService.createUser(userDto);
		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}
	
}
