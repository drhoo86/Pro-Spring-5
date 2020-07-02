package com.apress.prospring5.ch8;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import static java.util.Optional.of;

@Service("contactAuditService")
@Repository
@Transactional
public class ContactAuditServiceImpl implements ContactAuditService {
    @Autowired
    ContactAuditRepository contactAuditRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ContactAudit> findAll() {
        return Lists.newArrayList(contactAuditRepository.findAll());
    }

    @Override
    public ContactAudit findById(Long id) {
        Optional<ContactAudit> foundContact = contactAuditRepository.findById(id);
        if (foundContact.isPresent()) {
            return foundContact.get();
        } else {
            return null;
        }
    }

    @Override
    public ContactAudit save(ContactAudit contact) {
        return contactAuditRepository.save(contact);
    }
}
