package com.fullstackdev.springboot.tcdemo.repository;

import java.util.List;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fullstackdev.springboot.tcdemo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByFirstName(String firstName);
	
	
	public List<User> findByFirstNameLike(String firstName);
	
	@Query("select u from User u where u.lastName like %:lasttName%")
	public List<User> searchByLastName(String lasttName);
	
	public List<User> findAllUsersSortByUsertype();
	

}
