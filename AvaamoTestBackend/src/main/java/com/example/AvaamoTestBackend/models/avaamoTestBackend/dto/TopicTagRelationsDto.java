package com.example.AvaamoTestBackend.models.avaamoTestBackend.dto;

// import statements start
import lombok.*;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
// import statements ends


// import dependecies start

// import dependecies ends


@TypeDef(name = "json", typeClass = JsonStringType.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class TopicTagRelationsDto {
	// Enums list start for TopicTagRelations
	// Enums list end for TopicTagRelations

	// Column start
	private Long id;
	// Column end

	// Relations Start
	private Long topicsId;
	private Long tagsId;
	// Relations End

}