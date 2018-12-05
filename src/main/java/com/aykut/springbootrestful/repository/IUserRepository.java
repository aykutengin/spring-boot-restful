package com.aykut.springbootrestful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aykut.springbootrestful.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
	@Query("select u from User u WHERE u.name = :name")
	List<User> findByName(@Param("name") String name);
}
