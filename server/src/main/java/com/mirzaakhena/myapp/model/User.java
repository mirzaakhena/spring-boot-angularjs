package com.mirzaakhena.myapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 30)
	private String name;

	@Column(length = 60)
	private String address;

}
