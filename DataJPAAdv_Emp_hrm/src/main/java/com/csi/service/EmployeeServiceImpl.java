package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee signUp(Employee employee){
        return  employeeDaoImpl.signUp(employee);
    }

    public boolean signIn(String empEmailId, String empPassword){
        return employeeDaoImpl.signIn(empEmailId,empPassword);
    }

    public Optional<Employee> getDataById(int empId){
        return  employeeDaoImpl.getDataById(empId);

    }

    public List<Employee> getDataByName(String empName){
        return  employeeDaoImpl.getDataByEmpName(empName);
    }

    public Employee getDataByContactNo(long empContactNo){
        return  employeeDaoImpl.getDataByContactNo(empContactNo);

    }

    public Employee getDataByEmailId(String empEmailid){
        return employeeDaoImpl.getDataByEmpEmailId(empEmailid);

    }

    public List<Employee>  getDataByUsingAnyInput(String input){
        return employeeDaoImpl.getDataByUsingAnyInput(input);

    }
    public List<Employee> getAllData(){
        return  employeeDaoImpl.getAllData();
    }

    public List<Employee> sortByName(){
        return  employeeDaoImpl.sortByName();

    }

    public  List<Employee> sortById(){
        return employeeDaoImpl.sortById();
    }

    public  List<Employee> sortBySalary(){
        return  employeeDaoImpl.sortBySallary();

    }

    public  List<Employee> sortByAge(){
        return  employeeDaoImpl.sortByAge();
    }

    public List<Employee> sortByDob(){
        return  employeeDaoImpl.sortByDob();
    }

    public List<Employee> filterDataBySallary(double empSallary){
        return  employeeDaoImpl.filterDataBySallary(empSallary);
    }

    public boolean isEligibleForLoan(int empId){
        employeeDaoImpl.isEligibleForLoan(empId);
    }
    
  public Employee updateData(Employee employee){
        employeeDaoImpl.updateData(employee);
  }

  public  void  deleteById(int empId){
        employeeDaoImpl.deleteById(empId);
  }

  public  void  deleteAll(){
        employeeDaoImpl.deleteAll();

  }




}
