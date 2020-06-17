package com.apress.prospring5.ch7;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("contactDao")
public class ContactDaoImp implements ContactDao {
    private static final Log LOG = LogFactory.getLog(ContactDaoImp.class);
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
    }

    @Override
    public List findAllWithDetail() {
        return sessionFactory.getCurrentSession().getNamedQuery("Contact.findAllWithDetail").list();
    }

    @Override
    public Contact findById(Long id) {
        return (Contact) sessionFactory.getCurrentSession().
                getNamedQuery("Contact.findById").setParameter("id", id).uniqueResult();
    }

    @Override
    public Contact save(Contact contact) {
        return null;
    }

    @Override
    public void delete(Contact contact) {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
