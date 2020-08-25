package com.example.demo.ui.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ui.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> 
{
	public UserEntity findByUserId(String userId);

}
