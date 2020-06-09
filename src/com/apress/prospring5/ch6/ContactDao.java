package com.apress.prospring5.ch6;

import java.util.List;

public interface ContactDao {
    List<Contact> findAll();
    void insert(Contact contact);

    List<Contact> findByFirstName(String firstName);

    String findFirstNameById(Long id);

    String findLastNameById(Long id);

    void update(Contact contact);
    void delete(Long contactId);
}
