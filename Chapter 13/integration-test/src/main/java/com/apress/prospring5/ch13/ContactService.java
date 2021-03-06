package com.apress.prospring5.ch13;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    Contact findById(Long id);
    Contact findByFirstNameAndLastName(String firstName, String lastName);
    Contact save(Contact contact);
    void delete(Contact contact);
}
