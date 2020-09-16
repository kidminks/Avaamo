package com.example.AvaamoTestBackend.models.avaamoTestBackend;

// import statements start
import lombok.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.jetbrains.annotations.NotNull;
import java.math.*;
import java.util.*;
// import statements ends


@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@DynamicUpdate
@Getter
@Setter
@Table(name = "topics")
public class Topics {
	// Enums list start for Topics
	public enum Status {
		PUBLISHED,
		DRAFT
	}

	public enum Type {
		DISCUSSION,
		IDEA,
		QUESTION,
		COMMENTS
	}

	// Enums list end for Topics

	// Column start
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "subject")
	private String subject;

	@NotNull
	@Column(name = "content")
	private String content;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@NotNull
	@Column(name = "permalink")
	private String permalink;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Type type;

	@Column(name = "views")
	private BigInteger views = new BigInteger("0");

	@Column(name = "likes")
	private BigInteger likes = new BigInteger("0");

//	@Column(name = "creator_id")
//	private BigInteger creatorId;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "created_at")
	private Date createdAt = new Date();

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "updated_at")
	private Date updatedAt = new Date();

	@OneToOne
	@JoinColumn(name = "creator_id")
	private Users users;

	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="topic_comment_relations",
			joinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"))
	private Set<Topics> comments;

	// Column end

	// Relations Start
	// Relations End

}