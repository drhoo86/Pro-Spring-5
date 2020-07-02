package com.apress.prospring5.ch8;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Optional;

//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "contact_audit")
public class ContactAudit implements Serializable {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;

    //@CreatedBy
    private String createdBy;

    //@CreatedDate
    private Date createdDate;

    //@LastModifiedBy
    private String lastModifiedBy;

    //@LastModifiedDate
    private Date lastModifiedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

/*
    public boolean isNew() {
        if (id == null) {
            return true;
        } else {
            return false;
        }
    }
*/

    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "LAST_MODIFIED_BY")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }


    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }


    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String toString() {
        return "Contact - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate
                + ", Created by: " + createdBy + ", Create date: " + createdDate
                + ", Modified by: " + lastModifiedBy + ", Modified date: "
                + lastModifiedDate;
    }
}
