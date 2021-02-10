package com.tata.storeapp.utility;

import com.tata.storeapp.dao.EmployeeImpl;
import com.tata.storeapp.models.Employee;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueApp {

    public static void main(String[] args){
        PriorityQueue<Employee> priorityQueue=new PriorityQueue<Employee>();
        for(Employee employee:new EmployeeImpl().getAllEmployees()){
            priorityQueue.add(employee);
        }
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }

    }
}
