package com.tata.storeapp.models;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
   // @Getter(value = AccessLevel.NONE)
    //@Setter(value = AccessLevel.NONE)
    private long transactionId;
    //@Getter(value = AccessLevel.NONE)
    //@Setter(value = AccessLevel.NONE)
    private long amount;
    private LocalDate dot;

    private TransactionType transactionType;
}
