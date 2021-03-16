package com.excercise.AssociationExcercise.entities;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;

//    @ManyToMany(mappedBy = "books")
//    private Set<Author> authors;private Author author;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="author_id")
        private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }






    //    @OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name = "author_id")
//    private Author author;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
