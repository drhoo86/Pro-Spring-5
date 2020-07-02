package com.apress.prospring5.ch8;

import com.apress.prospring5.ch8.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
    List<Contact> findByCriteriaQuery(String firstName, String lastName);
}
