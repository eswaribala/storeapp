package com.tata.storeapp.utility;

import com.tata.storeapp.dao.EmployeeDao;
import com.tata.storeapp.dao.EmployeeImpl;
import com.tata.storeapp.models.Employee;

import java.util.Iterator;
import java.util.Map;

public class EmployeeApp {

    public static void main(String[] args){
        EmployeeDao employeeDao=new EmployeeImpl();
        int value=0;
        //read key and value together
        Iterator itr =employeeDao.countOutstandingEmployees()
                .entrySet().iterator();
        Map.Entry<Employee,Integer> data=null;
        while(itr.hasNext()){
          data= (Map.Entry<Employee, Integer>) itr.next();
          value=data.getValue();
          if(value>=3) {
              System.out.println(data.getKey());
              System.out.println(data.getValue());
          }
        }


    }
}
