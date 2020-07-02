package com.apress.prospring5.ch8;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContactTelDetail.class)
public abstract class ContactTelDetail_ {

	public static volatile SingularAttribute<ContactTelDetail, String> telType;
	public static volatile SingularAttribute<ContactTelDetail, String> telNumber;
	public static volatile SingularAttribute<ContactTelDetail, Contact> contact;
	public static volatile SingularAttribute<ContactTelDetail, Long> id;
	public static volatile SingularAttribute<ContactTelDetail, Integer> version;

	public static final String TEL_TYPE = "telType";
	public static final String TEL_NUMBER = "telNumber";
	public static final String CONTACT = "contact";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

