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
import com.example.AvaamoTestBackend.models.avaamoTestBackend.Attachments;
// import dependecies ends


@TypeDef(name = "json", typeClass = JsonStringType.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class AttachmentsDto {
	// Enums list start for Attachments
	public Attachments.EntityType entityType;
	// Enums list end for Attachments

	// Column start
	private Long id;
	private String fileName;

	private String fileUrl;

	private BigInteger entityId;

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