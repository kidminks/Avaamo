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

import java.util.*;
// import statements ends


@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@DynamicUpdate
@Getter
@Setter
@Table(name = "tags")
public class Tags {
	// Enums list start for Tags
	// Enums list end for Tags

	// Column start
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "permalink")
	private String permalink;

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