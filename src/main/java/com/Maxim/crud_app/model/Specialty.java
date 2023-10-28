package com.Maxim.crud_app.model;

import com.Maxim.crud_app.base.Status;
import java.util.concurrent.ThreadLocalRandom;


public class Specialty {

    public Specialty() {
        setStatus(Status.ACTIVE);
        this.id= ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
    }

    private Status status = Status.ACTIVE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
