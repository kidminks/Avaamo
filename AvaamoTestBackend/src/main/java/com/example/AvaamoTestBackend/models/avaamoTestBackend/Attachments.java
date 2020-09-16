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
@Table(name = "attachments")
public class Attachments {
	// Enums list start for Attachments
	public enum EntityType {
		TOPICS,
		COMMENT,
		REPLIES
	}

	// Enums list end for Attachments

	// Column start
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "file_name")
	private String fileName;

	@NotNull
	@Column(name = "file_url")
	private String fileUrl;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "entity_type")
	private EntityType entityType;

	@NotNull
	@Column(name = "entity_id")
	private BigInteger entityId;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "created_at")
	private Date createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "updated_at")
	private Date updatedAt;

	// Column end

	// Relations Start
	// Relations End

}