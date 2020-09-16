package com.example.AvaamoTestBackend.models.avaamoTestBackend;

// import statements start
import lombok.*;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
// import statements ends


@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@DynamicUpdate
@Getter
@Setter
@Table(name = "topic_tag_relations")
public class TopicTagRelations {
	// Enums list start for TopicTagRelations
	// Enums list end for TopicTagRelations

	// Column start
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Column end

	// Relations Start
	@Column(name = "topic_id")
	private Long topicId;
	@Column(name = "tag_id")
	private Long tagId;
	// Relations End

}