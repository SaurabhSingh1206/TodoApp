package com.example.demo.ui.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ui.entity.Todo;
import com.example.demo.ui.entity.UserEntity;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>
{
	List<Todo> findAllByUserDetails(UserEntity userEntity);
}
