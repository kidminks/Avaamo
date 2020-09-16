package com.example.AvaamoTestBackend.models.avaamoTestBackend.dto;

// import statements start
import lombok.*;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

import java.math.*;
// import statements ends


// import dependecies start

// import dependecies ends


@TypeDef(name = "json", typeClass = JsonStringType.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class TopicCommentRelationsDto {
	// Enums list start for TopicCommentRelations
	// Enums list end for TopicCommentRelations

	// Column start
	private Long id;
	private Long topicId;

	private Long commentId;

	// Column end

	// Relations Start
	// Relations End

}