package com.phil.client.client.model;

public class Shipment {

    private Long id;
    private Long trackingnumber;
    private String name;

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
