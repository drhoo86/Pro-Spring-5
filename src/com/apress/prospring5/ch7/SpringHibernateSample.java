package com.apress.prospring5.ch7;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class SpringHibernateSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch7-app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        listContactsWithDetail(contactDao.findAllWithDetail());

        System.out.println("Finding contact with id=1...");
        Contact contact = contactDao.findById(1L);
        System.out.println(contact);
        System.out.println("");

        System.out.println("Creating a new contact...");
        contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "11111111111");
        contact.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Mobile", "22222222222");
        contact.addContactTelDetail(contactTelDetail);
        contactDao.save(contact);
        listContactsWithDetail(contactDao.findAllWithDetail());

        System.out.println("Changing contact with id=1...");
        contact = contactDao.findById(1L);
        contact.setFirstName("Kim Fung");
        Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
        ContactTelDetail toDeleteContactTel = null;
        for (ContactTelDetail contactTel : contactTels) {
            if (contactTel.getTelType().equals("Home")) {
                toDeleteContactTel = contactTel;
            }
        }
        contact.removeContactTelDetail(toDeleteContactTel);
        contactDao.save(contact);
        listContactsWithDetail(contactDao.findAllWithDetail());

        System.out.println("Deleting contact with id=1...");
        contact = contactDao.findById(1L);
        contactDao.delete(contact);
        listContactsWithDetail(contactDao.findAllWithDetail());
    }


    private static void listContacts(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts with details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail :
                        contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }
            if (contact.getHobbies() != null) {
                for (Hobby hobby : contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            System.out.println();
        }
    }
}
