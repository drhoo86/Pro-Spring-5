package com.apress.prospring5.ch6;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AnnotationJdbcDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch6-app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        System.out.println("\nFinding all contacts...");
        List<Contact> contacts = contactDao.findAll();
        listContacts(contacts);

        System.out.println("\nFind contact with first name Chris...");
        contacts = contactDao.findByFirstName("Chris");
        listContacts(contacts);

        System.out.println("\nChange contact with id=1...");
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("Chris");
        contact.setLastName("John");
        contact.setBirthDate(new Date(
                (new GregorianCalendar(1977, 10, 1)).getTime().getTime()
        ));
        contactDao.update(contact);
        listContacts(contactDao.findAll());

        System.out.println("\nCreate new contact...");
        contact = new Contact();
        contact.setFirstName("Rod");
        contact.setLastName("Johnson");
        contact.setBirthDate(new Date(
                (new GregorianCalendar(2001, 10, 1)).getTime().getTime()
        ));
        contactDao.insert(contact);
        listContacts(contactDao.findAll());
    }

    private static void listContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            }
            System.out.println();
        }
    }
}
