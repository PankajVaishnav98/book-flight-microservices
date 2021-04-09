package com.mindtree.learning.userdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.learning.userdetails.model.User;

@Repository
public interface UserDetailsRepo extends JpaRepository<User, Integer>{

}
