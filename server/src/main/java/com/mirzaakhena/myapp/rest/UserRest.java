package com.mirzaakhena.myapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mirzaakhena.myapp.dto.UserDto;
import com.mirzaakhena.myapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRest {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody UserDto dto) {
		return new ResponseEntity<>(userService.add(dto), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		return new ResponseEntity<>(userService.getOne(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable Long id) {
		userService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDto dto) {		
		return new ResponseEntity<>(userService.update(id, dto), HttpStatus.OK);
	}

}
