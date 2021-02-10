package com.tata.storeapp.dao;

import com.tata.storeapp.models.Employee;
import com.tata.storeapp.models.Transaction;
import com.tata.storeapp.models.TransactionType;

import java.time.LocalDate;
import java.util.*;

public class EmployeeImpl implements  EmployeeDao{

    private List<Employee> getEmployeeData(){
        Employee employee=null;
        List<Employee> employeeList=new ArrayList<Employee>();
        for(int i=0;i<100;i++){

            employee=new Employee(new Random().nextInt(100000),
                    "emp"+i,999999999+new Random().nextInt(10000000));
           employeeList.add(employee);
        }

        return employeeList;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return getEmployeeData();
    }

    public List<Employee> generateOutstandingList(){

        List<Employee> outStandingEmployeeList=new ArrayList<Employee>();
        List<Employee> localList=getAllEmployees();
        //three years
        for(int i=0;i<3;i++){
            //yearwise
            for(int j=0;j<10;j++)
            {
                outStandingEmployeeList.add(localList
                        .get(new Random().nextInt(99)));
            }
        }

        return outStandingEmployeeList;

    }


    @Override
    public Hashtable<Employee, Integer> countOutstandingEmployees() {

        Hashtable<Employee, Integer> finalData=new Hashtable<Employee,Integer>();
        LinkedHashSet<Employee> lset=new LinkedHashSet<Employee>();
        int count=1;
        for(Employee employee :generateOutstandingList()){
             if(!lset.add(employee)) {
                 count++;
                 finalData.put(employee,count);
             }
        }


        return finalData;
    }
}
