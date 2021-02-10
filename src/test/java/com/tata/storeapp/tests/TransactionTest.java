package com.tata.storeapp.tests;

import com.tata.storeapp.models.Transaction;
import com.tata.storeapp.models.TransactionType;
import com.tata.storeapp.utility.TransactionApp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.Connection;
import java.util.EnumSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TransactionTest {
    private Transaction transaction1,transaction2,transaction3;
    private Connection conn;
    //private static final Logger logger = LoggerFactory.getLogger( TransactionTest.class);
    @BeforeAll
    public static void getConnection(){
    }

    @BeforeEach
    public void getInstance(){
        transaction1=new Transaction();
        transaction1.setTransactionId(new Random().nextInt(10000));
       transaction2=new Transaction();
        transaction2.setTransactionId(new Random().nextInt(10000));
       // System.out.println(transaction2.getTransactionId());
    }

    //Transaction Id should be unique
    @Test
    @DisplayName("Test Transaction Id to be Unique")
    public void testTransactionIdUnique(){

        assertNotEquals(transaction1.getTransactionId(),
                transaction2.getTransactionId());
    }

    //amount should be non negative value
    @ParameterizedTest
    @ValueSource(ints = {4367,5398389,-372476,0,361565})
    @DisplayName("Test Transaction Amount to be greater than zero")
    public void testAmountToBePositive(int data){
        transaction1.setAmount(data);
        assertTrue(transaction1.getAmount()>0);

    }
   //negative test case nullpointer exception
    @Test()
    public void negativeTestForTransactionInstance(){
        assertThrows(NullPointerException.class,
                ()->{
            transaction3.getTransactionId();
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "transactiondata.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(int transactionId, int amount) {
       assertTrue(transactionId>0);
        assertNotEquals(0, amount);
    }



    @RepeatedTest(15)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        //assertEquals(15, repetitionInfo.getTotalRepetitions());
        assertNotEquals(transaction1.getTransactionId(),
                transaction2.getTransactionId());
    }

    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void transactionDisplayName(TestInfo testInfo,RepetitionInfo repetitionInfo) {
        assertEquals("Repeat! "+repetitionInfo.getCurrentRepetition()
                +"/"+repetitionInfo.getTotalRepetitions(), testInfo.getDisplayName());
    }
    @Disabled
    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    void customDisplayNameWithLongPattern(TestInfo testInfo) {
        assertEquals("Details... :: repetition 1 of 1", testInfo.getDisplayName());
    }
    @Disabled
    @RepeatedTest(value = 5, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
    void repeatedTestInGerman() {
        // ...
    }

    @AfterEach
    public void testUnReferenceInstance(){
        transaction1=null;
        transaction2=null;
        transaction3=null;
    }
    @AfterAll
    public void testUnReferenceConnection(){

    }
}
