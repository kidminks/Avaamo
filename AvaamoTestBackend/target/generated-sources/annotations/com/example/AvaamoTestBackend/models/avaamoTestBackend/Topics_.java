package com.example.AvaamoTestBackend.models.avaamoTestBackend;

import com.example.AvaamoTestBackend.models.avaamoTestBackend.Topics.Status;
import com.example.AvaamoTestBackend.models.avaamoTestBackend.Topics.Type;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Topics.class)
public abstract class Topics_ {

	public static volatile SingularAttribute<Topics, String> updatedBy;
	public static volatile SetAttribute<Topics, Topics> comments;
	public static volatile SingularAttribute<Topics, String> subject;
	public static volatile SingularAttribute<Topics, Type> type;
	public static volatile SingularAttribute<Topics, String> content;
	public static volatile SingularAttribute<Topics, Users> users;
	public static volatile SingularAttribute<Topics, Date> createdAt;
	public static volatile SingularAttribute<Topics, String> createdBy;
	public static volatile SingularAttribute<Topics, Long> id;
	public static volatile SingularAttribute<Topics, String> permalink;
	public static volatile SingularAttribute<Topics, BigInteger> views;
	public static volatile SingularAttribute<Topics, Status> status;
	public static volatile SingularAttribute<Topics, BigInteger> likes;
	public static volatile SingularAttribute<Topics, Date> updatedAt;

	public static final String UPDATED_BY = "updatedBy";
	public static final String COMMENTS = "comments";
	public static final String SUBJECT = "subject";
	public static final String TYPE = "type";
	public static final String CONTENT = "content";
	public static final String USERS = "users";
	public static final String CREATED_AT = "createdAt";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String PERMALINK = "permalink";
	public static final String VIEWS = "views";
	public static final String STATUS = "status";
	public static final String LIKES = "likes";
	public static final String UPDATED_AT = "updatedAt";

}

