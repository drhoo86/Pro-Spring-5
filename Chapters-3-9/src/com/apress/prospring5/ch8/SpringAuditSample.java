package com.apress.prospring5.ch8;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class SpringAuditSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch8-audit-app-context-annotation.xml");
        ctx.refresh();

        ContactAuditService contactService = ctx.getBean(
                "contactAuditService", ContactAuditService.class);
        
        List<ContactAudit> contacts = contactService.findAll();
        listContacts(contacts);

        System.out.println("Add new contact");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        contactService.save(contact);
        contacts = contactService.findAll();
        listContacts(contacts);

        contact = contactService.findById(1L);
        System.out.println("");
        System.out.println("Contact with id 1: " + contact);
        System.out.println("");
        System.out.println("Update contact");
        contact.setFirstName("Tom");
        contactService.save(contact);
        contacts = contactService.findAll();
        listContacts(contacts);

    }

    private static void listContacts(List<ContactAudit> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (ContactAudit contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
}
