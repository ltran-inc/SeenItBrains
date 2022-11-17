package com.seenItBrains.SeenItBrains.repositories;

import com.seenItBrains.SeenItBrains.domain.Transaction;
import com.seenItBrains.SeenItBrains.exceptions.EtBadRequestException;
import com.seenItBrains.SeenItBrains.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface TransactionRepository {


    List<Transaction> findAll(Integer userId, Integer categoryId);
    Integer createTransaction(Integer userId, Integer categoryId, Double amount, String note) throws EtBadRequestException;

    Transaction findById(Integer transactionId) throws EtResourceNotFoundException;

    void updateById(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws EtResourceNotFoundException;

    void removeById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

}
