package com.example.singleTableStrategy.singletable;

import com.example.singleTableStrategy.singletable.controllers.PaymentController;
import com.example.singleTableStrategy.singletable.repos.PaymentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SingletableApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(SingletableApplication.class, args);
		PaymentController paymentController=applicationContext.getBean(PaymentController.class);

		paymentController.createPaymentCC();
		paymentController.createPaymentCH();
	}

}
