package com.excercise.AssociationExcercise.repos;

import com.excercise.AssociationExcercise.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
}
