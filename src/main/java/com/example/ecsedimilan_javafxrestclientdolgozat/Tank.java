package com.example.ecsedimilan_javafxrestclientdolgozat;

public class Tank {

    private int id;
    private String name;
    private String country;
    private boolean inservice;
    private int penetration;


    public Tank(int id, String name, String country, boolean inservice, int penetration) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.inservice = inservice;
        this.penetration = penetration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isInservice() {
        return inservice;
    }

    public void setInservice(boolean inservice) {
        this.inservice = inservice;
    }

    public int getPenetration() {
        return penetration;
    }

    public void setPenetration(int penetration) {
        this.penetration = penetration;
    }
}
