package com.tata.storeapp.tests;

import com.tata.storeapp.models.Person;
import com.tata.storeapp.models.Stock;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StockTest {

    @Test
    public void stockTest() {
        Stock stock = mock(Stock.class);
        when(stock.getPrice()).thenReturn(100.00);    // Mock implementation
        when(stock.getQuantity()).thenReturn(200);    // Mock implementation
        when(stock.getValue()).thenCallRealMethod();  // Real implementation

    }
}
