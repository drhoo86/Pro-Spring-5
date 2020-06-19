package com.apress.prospring5.ch8;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class SpringJPASample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch8-app-context-annotation.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("jpaContactService",
                ContactService.class);
        listContactsWithDetail(contactService.findAllWithDetail());

        System.out.println("Finding contact with id=1...");
        Contact contact = contactService.findById(1L);
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(contact);
        listContactsWithDetail(contacts);

        contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        ContactTelDetail contactTelDetail =
                new ContactTelDetail("Home", "11111111111");
        contact.addContactTelDetail(contactTelDetail);
        contactTelDetail =
                new ContactTelDetail("Mobile", "2222222222");
        contact.addContactTelDetail(contactTelDetail);
        contactService.save(contact);
        listContactsWithDetail(contactService.findAllWithDetail());

        System.out.println("Changing contact with id=1...");
        contact = contactService.findById(1L);
        contact.setFirstName("Justin");
        Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
        ContactTelDetail toDeleteContactTel = null;
        for (ContactTelDetail contactTel : contactTels) {
            if (contactTel.getTelType().equals("Home")) {
                toDeleteContactTel = contactTel;
            }
        }
        contact.removeContactTelDetail(toDeleteContactTel);
        contactService.save(contact);
        listContactsWithDetail(contactService.findAllWithDetail());

        System.out.println("Deleting contact with id=1...");
        contact = contactService.findById(1L);
        contactService.delete(contact);
        listContactsWithDetail(contactService.findAllWithDetail());

        // test Criteria API
        contacts = contactService.findByCriteriaQuery(null, "Tiger");
        listContactsWithDetail(contacts);
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
