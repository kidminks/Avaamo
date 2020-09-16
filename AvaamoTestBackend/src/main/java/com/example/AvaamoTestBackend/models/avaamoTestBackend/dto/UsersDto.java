package com.example.AvaamoTestBackend.models.avaamoTestBackend.dto;

// import statements start
import com.example.AvaamoTestBackend.models.avaamoTestBackend.Users;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

import java.util.*;
// import statements ends


// import dependecies start

// import dependecies ends


@TypeDef(name = "json", typeClass = JsonStringType.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class UsersDto {
	// Enums list start for Users
	public Users.Type type;
	// Enums list end for Users

	// Column start
	private Long id;
	private String name;

	private String photoUrl;

	private String label;

	private String password;

	private String createdBy;

	private String updatedBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createdAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startCreatedAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endCreatedAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date updatedAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startUpdatedAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endUpdatedAt;

	// Column end

	// Relations Start
	// Relations End

}