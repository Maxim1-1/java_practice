package com.Maxim.crud_app.model;

import com.Maxim.crud_app.base.Status;
import java.util.concurrent.ThreadLocalRandom;


public class Skill {
    public Status getStatus() {
        return status;
    }

    public Skill() {
        setStatus(Status.ACTIVE);
        this.id= ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    private String skill;

    public String getSkill() {
        return skill;

    }

    public void setSkill(String skill) {

        this.skill = skill;
    }

    public void removeSkill() {
        this.status = Status.DELETED;
    }
}
