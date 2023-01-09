package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;


    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.signUp(employee));
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword){
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>>getDataById(@PathVariable int empId){
        return  ResponseEntity.ok(employeeServiceImpl.getDataById(empId));

    }

    @GetMapping("/getdatabyname/{empName}")
    public  ResponseEntity<List<Employee>>getDataByName(@PathVariable String empName){
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));
    }

    @GetMapping("/getdatabyemailid/{empEmailId]")
    public  ResponseEntity<Employee>getDataByEmailId(@PathVariable String empEmailId){
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmailId(empEmailId));
    }

    @GetMapping("/getdatabycontactno/{empContactNo}")
    public  ResponseEntity<Employee>getDataByContactNo(@PathVariable long empContactNo){
        return  ResponseEntity.ok(employeeServiceImpl.getDataByContactNo(empContactNo));
    }

    @GetMapping("/getdatabyusinganyinput/{input}")
    public  ResponseEntity<List<Employee>>getDataByUsingAnyInput(@PathVariable String input){
        return  ResponseEntity.ok(employeeServiceImpl.getDataByUsingAnyInput(input));
    }

    @GetMapping("/getalldata")
    public  ResponseEntity<List<Employee>>getAllData(){
        return  ResponseEntity.ok(employeeServiceImpl.getAllData());
    }











}
