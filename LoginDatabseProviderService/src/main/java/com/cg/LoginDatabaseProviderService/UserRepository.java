package com.cg.LoginDatabaseProviderService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import feign.Param;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByuserNameAndPassword(@Param("uname") String userName, @Param("pass") String password);

}
