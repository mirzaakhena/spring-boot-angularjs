package com.mirzaakhena.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mirzaakhena.myapp.dao.UserDao;
import com.mirzaakhena.myapp.dto.UserDto;
import com.mirzaakhena.myapp.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public User add(UserDto dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setAddress(dto.getAddress());
		return userDao.save(user);
	}

	public List<User> getAll() {
		return userDao.findAll();
	}

	public User getOne(Long id) {
		return userDao.findOne(id);
	}

	@Transactional
	public void remove(Long id) {
		userDao.delete(id);
	}

	@Transactional
	public User update(Long id, UserDto dto) {
		User user = userDao.findOne(id);
		user.setName(dto.getName());
		user.setAddress(dto.getAddress());
		return userDao.save(user);
	}

}
