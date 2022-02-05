package com.spndbackend.spndservice.service.value;

import com.spndbackend.spndservice.entity.Value;
import com.spndbackend.spndservice.models.user.SingleValue;
import com.spndbackend.spndservice.models.value.AddValueResponse;
import com.spndbackend.spndservice.models.value.GetAllValuesByUserIdRequest;
import com.spndbackend.spndservice.models.value.GetAllValuesByUserIdResponse;
import com.spndbackend.spndservice.models.value.ValueResponse;
import com.spndbackend.spndservice.models.value.addsavingamount.AddSavingAmountRequest;
import com.spndbackend.spndservice.models.value.addsavingamount.AddSavingAmountResponse;
import com.spndbackend.spndservice.models.value.delete.DeleteSingleValueRequest;
import com.spndbackend.spndservice.models.value.delete.DeleteSingleValueResponse;
import com.spndbackend.spndservice.repository.UserRepository;
import com.spndbackend.spndservice.repository.ValueRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class valueServiceImplementation implements ValueService {

    @Autowired
    ValueRepository valueRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public AddValueResponse addValue(Value value) {
        Value addedValue = valueRepository.save(value);
        AddValueResponse addValueResponse = new AddValueResponse();
        addValueResponse.setSuccess(true);
        addValueResponse.setSystemMessage("Value is Added Succesfully");
        addValueResponse.setData(addedValue);
        return addValueResponse;

    }

    @Override
    public GetAllValuesByUserIdResponse getAllValuesByUserId(GetAllValuesByUserIdRequest request) {
        GetAllValuesByUserIdResponse getAllValuesByUserIdResponse = new GetAllValuesByUserIdResponse();
        List<ValueResponse> valueResponseList = new ArrayList<>();
        userRepository.findById(request.getUserId()).ifPresent((user) -> {
            log.info("getAllValuesByUserId() value :: :: " + user);
            user.getValues().forEach((value -> {
                ValueResponse valueResponse = new ValueResponse();
                SingleValue singleValue = new SingleValue();
                BeanUtils.copyProperties(value, singleValue);
                valueResponse.setValue(singleValue);
                valueResponseList.add(valueResponse);
                log.info("getAllValuesByUserId()  valueResponse:: :: " + value);
            }));
            log.info("getAllValuesByUserId() valueResponseList :: :: " + valueResponseList);
            getAllValuesByUserIdResponse.setData(valueResponseList);
            getAllValuesByUserIdResponse.setSuccess(true);
            getAllValuesByUserIdResponse.setSystemMessage("Values Successfully retrieved");
        });
        return getAllValuesByUserIdResponse;
    }


    @Override
    public DeleteSingleValueResponse deleteValue(DeleteSingleValueRequest request) {
       Optional<Value> value = valueRepository.findById(request.getValueId());
        DeleteSingleValueResponse deleteSingleValueResponse = null;
        if (value.isPresent()) {
            try {
                valueRepository.deleteById(request.getValueId());
                deleteSingleValueResponse = new DeleteSingleValueResponse();
                deleteSingleValueResponse.setSuccess(true);
                deleteSingleValueResponse.setSystemMessage("Item " + value.get().getValueName() + "is now deleted! ");
            } catch (Exception e) {
                e.printStackTrace();
                deleteSingleValueResponse.setSuccess(false);
                deleteSingleValueResponse.setSystemMessage("Failed to delete Item " + value.get().getValueName() + "please try again");
            }

        }
        return deleteSingleValueResponse;
    }

//    @Override
//    @Transactional
//    public AddSavingAmountResponse addSavingAmount(AddSavingAmountRequest request) throws Exception {
//        AddSavingAmountResponse addSavingAmountResponse = new AddSavingAmountResponse();
//        SingleValue singleValue = new SingleValue();
//        Optional<Value> value = valueRepository.findById(request.getValueId());
//        value.get().setValueId(request.getValueId());
//        value.get().setBudgetedAmount(value.get().getBudgetedAmount() + request.getTransactionAmount());
//        value.get().setLastUpdateAmount(request.getTransactionAmount());
//        if ((value.get().getBudgetedAmount() + request.getTransactionAmount()) >= value.get().getValueAmount()) {
//            value.get().setFullyValued(true);
//        }
//        valueRepository.save(value.get());
//        BeanUtils.copyProperties(value.get(), singleValue);
//        addSavingAmountResponse.setSuccess(true);
//        addSavingAmountResponse.setSystemMessage("Value is update");
//        addSavingAmountResponse.setData(singleValue);
//        return addSavingAmountResponse;
//    }


}
