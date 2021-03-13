package com.example.singleTableStrategy.singletable.entities;

import com.example.singleTableStrategy.singletable.entities.Payment;

import javax.persistence.*;

@Entity
@Table(name="bankcheck")
@PrimaryKeyJoinColumn(name="id")
public class Check extends Payment {
    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
