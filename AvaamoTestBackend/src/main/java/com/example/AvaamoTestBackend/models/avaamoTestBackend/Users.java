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
@Table(name = "users")
public class Users {
	// Enums list start for Users
	public enum Type {
		ENDUSER,
		SUPPORTREP
	}

	// Enums list end for Users

	// Column start
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@NotNull
	@Column(name = "name")
	private String name;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Type type = Type.ENDUSER;

	@Setter
	@NotNull
	@Column(name = "password")
	private String password;
	// Column end

	// Relations Start
	// Relations End

}