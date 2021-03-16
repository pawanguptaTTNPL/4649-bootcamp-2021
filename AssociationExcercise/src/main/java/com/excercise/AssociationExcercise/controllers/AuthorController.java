package com.excercise.AssociationExcercise.controllers;

import com.excercise.AssociationExcercise.entities.Address;
import com.excercise.AssociationExcercise.entities.Author;
import com.excercise.AssociationExcercise.entities.Book;
import com.excercise.AssociationExcercise.entities.Subject;
import com.excercise.AssociationExcercise.repos.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorController {

    @Autowired
   private AuthorRepository repository;



public void createRecord()
{
    Author author=new Author();
    author.setAge(22);
    author.setFirstName("Shubham");
    author.setLastName("Pandey");

    Address address=new Address();
    address.setStreetNumber(4);
    address.setLocation("Shyam Vihar");
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


    Book book1=new Book();
    book1.setBookName("Master in Java");

    Book book2=new Book();
    book2.setBookName("Master in c++");

    Book book3=new Book();
    book3.setBookName("Master in database");

    author.addBooks(book1);
    author.addBooks(book2);
    author.addBooks(book3);
//    HashSet<Book> books =  new HashSet<Book>();
//    Book book=new Book();
//    book.setBookName("Master IN Java");
//    books.add(book);

   // author.setBooks(books);

    repository.save(author);
}




}
