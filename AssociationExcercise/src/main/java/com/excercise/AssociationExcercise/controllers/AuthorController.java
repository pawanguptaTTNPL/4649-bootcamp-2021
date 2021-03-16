package com.excercise.AssociationExcercise.controllers;

import com.excercise.AssociationExcercise.entities.Address;
import com.excercise.AssociationExcercise.entities.Author;
import com.excercise.AssociationExcercise.entities.Book;
import com.excercise.AssociationExcercise.entities.Subject;
import com.excercise.AssociationExcercise.repos.AuthorRepository;
import com.excercise.AssociationExcercise.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorController {

    @Autowired
   private AuthorRepository repository;

    @Autowired
    private BookRepository bookRepository;


public void createRecord()
{
    Author author=new Author();
    author.setAge(22);
    author.setFirstName("Gaurav");
    author.setLastName("Rawat");

    Address address=new Address();
    address.setStreetNumber(4);
    address.setLocation("Najafgarh");
    address.setState("New Delhi");
    author.setAddress(address);
    //Add Subject here
    Subject subject1=new Subject();
    subject1.setSubjectName("Java");

    Subject subject2=new Subject();
    subject2.setSubjectName("C++");

    Subject subject3=new Subject();
    subject3.setSubjectName("DataBase");


    author.addSubject(subject1);
    author.addSubject(subject2);
    author.addSubject(subject3);




    Book book=new Book();
    book.setBookName("Master in hibernet");
    book.setAuthor(author);

    bookRepository.save(book);
    repository.save(author);
}




}
