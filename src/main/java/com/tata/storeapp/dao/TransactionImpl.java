package com.tata.storeapp.dao;

import com.tata.storeapp.models.Transaction;
import com.tata.storeapp.models.TransactionType;

import java.time.LocalDate;
import java.util.*;

public class TransactionImpl implements TransactionDao{
    @Override
    public List<Transaction> getAllTransactions() {
        return getData();
    }

    private List<Transaction> getData(){
        List<Transaction> transactionList=new ArrayList<Transaction>();
        Set<Long> transactionIdSet=new HashSet<Long>();
       //generate 10 unique ids
        for(int i=0;i<20;i++) {

            transactionIdSet.add((long) new Random().nextInt(10000));
        }
        Object[] objects=transactionIdSet.toArray();
        Transaction transaction=null;
        for(int i=0;i<10;i++){

            transaction=new Transaction();
            transaction.setTransactionId((Long) objects[i]);
            transaction.setAmount(new Random().nextInt(1000000));
            transaction.setDot(LocalDate.of(1990+new Random().nextInt(25),1+new Random().nextInt(10),1+new Random().nextInt(27) ));
            transaction.setTransactionType(TransactionType.NETBANKING);
            transactionList.add(transaction);
        }

        return transactionList;
    }

}
