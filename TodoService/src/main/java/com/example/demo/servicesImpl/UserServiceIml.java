package com.example.demo.servicesImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.services.UserService;
import com.example.demo.ui.dto.UserDto;
import com.example.demo.ui.entity.UserEntity;
import com.example.demo.ui.repositories.UserRepository;

public class UserServiceIml implements UserService {

	@Autowired
	UserRepository userRepository;

	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity storedUserDetail = userRepository.findByUserId(user.getAgent_id());
		if (storedUserDetail != null)	throw new RuntimeException("Record already exists.");
		for(int i=0;i <user.getAddresses().size();i++)
		{
			AddressDTO address = user.getAddresses().get(i);
			address.setUserDetails(user);
			address.setAddressId(utils.generateAddressId(30));
			user.getAddresses().set(i, address);
		}
		ModelMapper modelMapper = new ModelMapper();
		UserEntity userEntity = modelMapper.map(user,  UserEntity.class);
		String publicUserId = utils.generateUserId(30);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setUserId(publicUserId);
		UserEntity storedUserDetails = userRepository.save(userEntity);
		System.out.println("savedit");
		UserDto returnValue = new UserDto();
		returnValue = modelMapper.map(storedUserDetails,  UserDto.class);
		return returnValue;
		return null;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		

	}

}
