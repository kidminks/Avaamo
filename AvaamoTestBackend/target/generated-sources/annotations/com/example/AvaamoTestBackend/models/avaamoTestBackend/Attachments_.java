package com.example.AvaamoTestBackend.models.avaamoTestBackend;

import com.example.AvaamoTestBackend.models.avaamoTestBackend.Attachments.EntityType;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Attachments.class)
public abstract class Attachments_ {

	public static volatile SingularAttribute<Attachments, Date> createdAt;
	public static volatile SingularAttribute<Attachments, String> fileName;
	public static volatile SingularAttribute<Attachments, String> updatedBy;
	public static volatile SingularAttribute<Attachments, String> createdBy;
	public static volatile SingularAttribute<Attachments, EntityType> entityType;
	public static volatile SingularAttribute<Attachments, String> fileUrl;
	public static volatile SingularAttribute<Attachments, BigInteger> entityId;
	public static volatile SingularAttribute<Attachments, Long> id;
	public static volatile SingularAttribute<Attachments, Date> updatedAt;

	public static final String CREATED_AT = "createdAt";
	public static final String FILE_NAME = "fileName";
	public static final String UPDATED_BY = "updatedBy";
	public static final String CREATED_BY = "createdBy";
	public static final String ENTITY_TYPE = "entityType";
	public static final String FILE_URL = "fileUrl";
	public static final String ENTITY_ID = "entityId";
	public static final String ID = "id";
	public static final String UPDATED_AT = "updatedAt";

}

