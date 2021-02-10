package com.tata.storeapp.utility;

import com.tata.storeapp.business.TransactionSorter;
import com.tata.storeapp.dao.TransactionDao;
import com.tata.storeapp.dao.TransactionImpl;
import com.tata.storeapp.models.Transaction;
import com.tata.storeapp.models.TransactionType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TransactionApp {

    public static void main(String[] args){
        TransactionDao transactionDao=new TransactionImpl();
        List<Transaction> transactionList=transactionDao.getAllTransactions();
        //transactions before sorting....
        System.out.println("Before Sorting.....");
        for(Transaction transaction : transactionList){
            System.out.println(transaction);
        }
        //sort the transaction by dot
        Collections.sort(transactionList,new TransactionSorter());
        System.out.println("After Sorting.....");
        /*
        transactionList.stream()
                .sorted((t1,t2)->(t1.getDot().compareTo(t2.getDot())))
                .forEach(System.out::println);
       */
        for(Transaction transaction : transactionList){
            System.out.println(transaction);
        }

    }
}
