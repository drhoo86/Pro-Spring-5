package com.apress.prospring5.ch8;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Hobby.class)
public abstract class Hobby_ {

	public static volatile SingularAttribute<Hobby, String> hobbyId;
	public static volatile SetAttribute<Hobby, Contact> contacts;

	public static final String HOBBY_ID = "hobbyId";
	public static final String CONTACTS = "contacts";

}

