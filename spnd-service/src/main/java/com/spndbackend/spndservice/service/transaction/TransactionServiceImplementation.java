package com.spndbackend.spndservice.service.transaction;

import com.spndbackend.spndservice.entity.Transaction;
import com.spndbackend.spndservice.entity.Value;
import com.spndbackend.spndservice.models.user.SingleValue;
import com.spndbackend.spndservice.models.value.addsavingamount.AddSavingAmountRequest;
import com.spndbackend.spndservice.models.value.addsavingamount.AddSavingAmountResponse;
import com.spndbackend.spndservice.repository.TransactionRepository;
import com.spndbackend.spndservice.repository.ValueRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Beans;
import java.util.Objects;
import java.util.Optional;


@Log4j2
@Service
public class TransactionServiceImplementation implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ValueRepository valueRepository;


    @Override
    @Transactional
    public AddSavingAmountResponse addSavingAmount(AddSavingAmountRequest request) {
        AddSavingAmountResponse addSavingAmountResponse = new AddSavingAmountResponse();
        Transaction transaction = new Transaction();
        SingleValue singleValue = new SingleValue();
        if (!(request == null)) {
            valueRepository.findById(request.getValueId()).ifPresent((value) -> {
                BeanUtils.copyProperties(request,transaction);
                transaction.setValue(value);
                log.info("transaction object :: :: " + transaction);
                try {
                    Transaction transactionReturned = transactionRepository.save(transaction);
                    log.info("Transaction being processed :: Transaction Posted Successfully :: :: " + transactionReturned);
                } catch (Exception error) {
                    error.printStackTrace();
                    log.info("Sorry, something went wrong");
                }
                value.setValueId(request.getValueId());
                value.setBudgetedAmount(value.getBudgetedAmount() + request.getTransactionAmount());
                value.setLastUpdateAmount(request.getTransactionAmount());
                if ((value.getBudgetedAmount() + request.getTransactionAmount()) >= value.getValueAmount()) {
                    value.setFullyValued(true);
                }
                try {
                    valueRepository.save(value);
                    BeanUtils.copyProperties(value, singleValue);
                    addSavingAmountResponse.setSuccess(true);
                    addSavingAmountResponse.setSystemMessage("Value is updated, transaction is posted");
                    addSavingAmountResponse.setData(singleValue);
                } catch (Exception e) {
                    e.printStackTrace();
                    addSavingAmountResponse.setSuccess(false);
                    addSavingAmountResponse.setSystemMessage("Sorry something went wrong");
                    addSavingAmountResponse.setData(null);
                }
            });
        } else {
            addSavingAmountResponse.setSuccess(true);
            addSavingAmountResponse.setSystemMessage("Value is updated, transaction is posted");
            addSavingAmountResponse.setData(singleValue);
        }
        return addSavingAmountResponse;
    }


}


