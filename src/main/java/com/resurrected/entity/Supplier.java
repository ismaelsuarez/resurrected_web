package com.resurrected.entity;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.resurrected.enums.Example;

import lombok.Data;

@Entity
@Data
public class Supplier {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_client")
    private String id;
    @Column(name = "dv_enterprise")
    private String enterprise;
    
    @Column(name = "dv_example")
    private Example example;

    @OneToOne
    private Client client;
    @OneToOne
    private Photo photo;
}
