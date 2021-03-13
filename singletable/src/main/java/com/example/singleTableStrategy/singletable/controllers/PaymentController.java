package com.example.singleTableStrategy.singletable.controllers;

import com.example.singleTableStrategy.singletable.entities.Check;
import com.example.singleTableStrategy.singletable.entities.CreditCard;
import com.example.singleTableStrategy.singletable.repos.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentController {
    @Autowired
    PaymentRepository repository;

    public void createPaymentCC()
    {
        CreditCard cc=new CreditCard();
        cc.setId(1);
        cc.setAmount(1000);
        cc.setCardnumber("12345678");
        repository.save(cc);
    }
    public void createPaymentCH()
    {
        Check ch=new Check();
        ch.setId(2);
        ch.setAmount(2000);
        ch.setChecknumber("12345679");
        repository.save(ch);
    }
}
