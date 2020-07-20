package com.apress.prospring5.ch15;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
