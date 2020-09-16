package com.example.AvaamoTestBackend.models.avaamoTestBackend;

// import statements start
import lombok.*;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.jetbrains.annotations.NotNull;
import java.math.*;
// import statements ends


@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@DynamicUpdate
@Getter
@Setter
@Table(name = "topic_comment_relations")
public class TopicCommentRelations {
	// Enums list start for TopicCommentRelations
	// Enums list end for TopicCommentRelations

	// Column start
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "topic_id")
	private Long topicId;

	@NotNull
	@Column(name = "comment_id")
	private Long commentId;

	// Column end

	// Relations Start
	// Relations End

}