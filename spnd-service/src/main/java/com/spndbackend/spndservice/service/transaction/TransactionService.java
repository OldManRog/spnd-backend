package com.spndbackend.spndservice.service.transaction;

import com.spndbackend.spndservice.models.value.addsavingamount.AddSavingAmountRequest;
import com.spndbackend.spndservice.models.value.addsavingamount.AddSavingAmountResponse;
import com.spndbackend.spndservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;


public interface TransactionService {


    AddSavingAmountResponse addSavingAmount(AddSavingAmountRequest request);


}
