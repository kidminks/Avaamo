package com.example.AvaamoTestBackend.models.avaamoTestBackend.dto;

// import statements start
import lombok.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

import java.math.*;
import java.util.*;
// import statements ends


// import dependecies start
import com.example.AvaamoTestBackend.models.avaamoTestBackend.Topics;
// import dependecies ends


@TypeDef(name = "json", typeClass = JsonStringType.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class TopicsDto {
	// Enums list start for Topics
	public Topics.Status status;
	public Topics.Type type;
	// Enums list end for Topics

	// Column start
	private Long id;
	private String subject;

	private String content;

	private String permalink;

	private BigInteger views;

	private BigInteger likes;

	private BigInteger creatorId;

	private Long topicIdForComment;

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