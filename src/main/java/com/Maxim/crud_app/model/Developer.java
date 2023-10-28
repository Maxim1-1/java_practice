package com.Maxim.crud_app.model;

import com.Maxim.crud_app.base.Status;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Developer {
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status;

    public int getId() {
        return id;
    }

    private int id;
    private String firstName;
    private String lastName;
    private Specialty specialty;
    private List<Skill> skills = null;

    public Developer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);;
        setStatus(Status.ACTIVE);
    }

    public String getLastName() {
            return lastName;
    }

    public void setLastName(String lastName) {
            this.lastName = lastName;

    }
    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public String getFirstName() {
        return firstName;
    }

    public  void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}



