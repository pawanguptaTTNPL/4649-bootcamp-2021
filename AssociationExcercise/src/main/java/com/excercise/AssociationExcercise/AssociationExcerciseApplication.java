package com.excercise.AssociationExcercise;

import com.excercise.AssociationExcercise.controllers.AuthorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AssociationExcerciseApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(AssociationExcerciseApplication.class, args);
		AuthorController authorController=applicationContext.getBean(AuthorController.class);
		authorController.createRecord();
	//	authorController.createBook();

	}

}
