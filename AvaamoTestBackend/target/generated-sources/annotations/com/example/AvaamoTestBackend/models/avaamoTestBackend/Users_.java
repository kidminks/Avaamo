package com.example.AvaamoTestBackend.models.avaamoTestBackend;

import com.example.AvaamoTestBackend.models.avaamoTestBackend.Users.Type;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_ {

	public static volatile SingularAttribute<Users, String> password;
	public static volatile SingularAttribute<Users, String> name;
	public static volatile SingularAttribute<Users, Long> id;
	public static volatile SingularAttribute<Users, Type> type;

	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TYPE = "type";

}

