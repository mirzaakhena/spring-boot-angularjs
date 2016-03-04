package com.mirzaakhena.myapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirzaakhena.myapp.model.User;

/**
 * 
 * @author mirzaakhena
 *
 */
public interface UserDao extends JpaRepository<User, Long> {

}
