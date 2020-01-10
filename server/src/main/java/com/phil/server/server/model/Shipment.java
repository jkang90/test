package com.phil.server.server.model;

import javax.persistence.*;

@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false, unique=true)
    private Long trackingnumber;

    @Column
    private String name;

    public Shipment(){}

    public Shipment(Long id, Long trackingnumber, String name){
        this.id = id;
        this.trackingnumber = trackingnumber;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrackingnumber() {
        return trackingnumber;
    }

    public void setTrackingnumber(Long trackingnumber) {
        this.trackingnumber = trackingnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
