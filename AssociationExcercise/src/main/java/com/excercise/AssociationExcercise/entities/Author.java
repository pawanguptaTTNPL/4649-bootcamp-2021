package com.excercise.AssociationExcercise.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    @OneToMany(mappedBy = "author",cascade =CascadeType.ALL)//table name(entity)
    private Set<Subject> subjects;


    @OneToOne(mappedBy = "author")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<Subject> getSubjetcs() {
        return subjects;
    }

    public void setSubjetcs(Set<Subject> subjetcs) {
        this.subjects= subjetcs;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Embedded
    private Address address;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public void addSubject(Subject subject)
    {
        if(subject!=null){
            if(subjects==null)
                subjects=new HashSet<>();
            subject.setAuthor(this);
            subjects.add(subject);
        }
    }

}
