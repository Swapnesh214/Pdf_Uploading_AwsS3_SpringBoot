package com.nandi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	private Integer imgId;
	private String imgName;
	private String url;
}
