package com.tata.storeapp.tests;

import com.tata.storeapp.models.Person;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
public class PersonTest{

    @Test
    public void playTest() {
        Person person = new Person("name", 15);

        Person person1 = Mockito.spy(person);

        Mockito.doReturn(true).when(person1).runInGround("ground");

        assertEquals(true, person1.isPlay());
    }
}