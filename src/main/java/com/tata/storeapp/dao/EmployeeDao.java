package com.tata.storeapp.dao;

import com.tata.storeapp.models.Employee;
import java.util.Hashtable;
import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    List<Employee> generateOutstandingList();
    Hashtable<Employee,Integer> countOutstandingEmployees();

}
