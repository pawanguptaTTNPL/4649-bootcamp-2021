package com.example.singleTableStrategy.singletable.repos;

import com.example.singleTableStrategy.singletable.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
