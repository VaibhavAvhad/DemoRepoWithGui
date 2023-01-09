package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepo;

    public Employee signUp(Employee employee) {
        return employeeRepo.save(employee);
    }

    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;
        for (Employee employee : employeeRepo.findAll()) {
            if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
                flag = true;
            }
        }
        return flag;
    }

    public Optional<Employee> getDataById(int empId) {
        return employeeRepo.findById(empId);
    }

    public List<Employee> getDataByEmpName(String empName) {
        return employeeRepo.findByEmpName(empName);

    }

    public Employee getDataByEmpEmailId(String empEmailId) {
        return employeeRepo.findByEmpEmailId(empEmailId);

    }

    public Employee getDataByContactNo(long empContactNo) {
        return employeeRepo.findByEmpContactNo(empContactNo);
    }


    public List<Employee> getDataByUsingAnyInput(String input) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employeeRepo.findAll()) {
            if (String.valueOf(employee.getEmpName()).equals(input) ||
                    employee.getEmpName().equals(input) ||
                    employee.getEmpEmailId().equals(input) ||
                    String.valueOf(employee.getEmpContactNo()).equals(input)
            ) {
                employeeList.add(employee);
            }

        }
        return employeeList;

    }

    public List<Employee> getAllData() {
        return employeeRepo.findAll();

    }

    public List<Employee> sortByName() {
        return employeeRepo.findAll().stream().sorted((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName())).collect(Collectors.toList());
    }

    public List<Employee> sortById() {
        return employeeRepo.findAll().stream().sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList());
    }

    public List<Employee> sortBySallary() {
        return employeeRepo.findAll().stream().sorted(Comparator.comparingDouble(Employee::getEmpSallry)).collect(Collectors.toList());
    }

    public List<Employee> sortByAge() {
        return employeeRepo.findAll().stream().sorted(Comparator.comparingInt(Employee::getEmpAge)).collect(Collectors.toList());
    }

    public List<Employee> sortByDob() {
        return employeeRepo.findAll().stream().sorted((e1, e2) -> e1.getEmpDob().compareTo(e2.getEmpDob())).collect(Collectors.toList());
    }

    public List<Employee> filterDataBySallary(double empSallary) {
        return employeeRepo.findAll().stream().filter(emp -> emp.getEmpSallry() >= empSallary).collect(Collectors.toList());
    }

    public  boolean isEligibleForLoan(int empId){
        boolean flag= false;

        for (Employee employee:employeeRepo.findAll()){
            if (employee.getEmpId()==empId && employee.getEmpSallry()>=60000){
                flag=true;

            }
        }
        return  flag;
    }

    public Employee updateData(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteById(int empId){
        employeeRepo.deleteById(empId);
    }

    public void deleteAll(){
        employeeRepo.deleteAll();
    }





}
