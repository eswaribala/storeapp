package com.tata.storeapp.tests;

import com.tata.storeapp.facades.CategoryArgumentProvider;
import com.tata.storeapp.facades.CustomArgumentsProvider;
import com.tata.storeapp.models.Category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.*;
public class CategoryTest {

    private Category category;
    @BeforeEach
    public void getInstance()
    {
       category=new Category();
    }

    @Test
    public void testCategoryNotNUll(){
        assertNotNull(category);
    }

    @ParameterizedTest
    @ArgumentsSource(CategoryArgumentProvider.class)
    public void testCategoryNameNotNUll(Category category){
        assertNotNull(category.getName());
    }
}
