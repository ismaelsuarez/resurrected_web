package com.resurrected.entity;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import com.resurrected.enums.Rol;
import com.resurrected.enums.StatusClient;

import lombok.Data;

@Entity
@Data
@Builder
public class Client {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_client")
    private String id;
    @Column(name = "dv_name")
    private String name;
    @Column(name = "dv_lastname")
    private String lastname;
    @Column(name = "dv_document")
    private Long document;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dv_dob")
    private Date dob;
    @Column(name = "dv_phoneNumber")
    private String phoneNumber;
    @Column(name = "dv_adress")
    private String adress;
    @Column(name = "dv_email")
    private String email;
    @Column(name = "dv_password")
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dv_createDate")
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dv_updateDate")
    private Date updateDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dv_lastLogin")
    private Date lastLogin;
    @Column(name = "dv_statusClient")
    private StatusClient statusClient;
    @Column(name = "dv_active")
    private Boolean active;
    @Column(name = "dv_rol")
    private Rol rol;

    @OneToOne
    private Photo photo;
}
