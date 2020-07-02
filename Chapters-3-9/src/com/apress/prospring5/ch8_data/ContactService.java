package com.apress.prospring5.ch8_data;

import com.apress.prospring5.ch8.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
