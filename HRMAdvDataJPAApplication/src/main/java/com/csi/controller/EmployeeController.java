package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee){

        log.info("##################### SIGN UP FOR EMPLOYEE DATA");
        return ResponseEntity.ok(employeeService.signUp(employee));
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword){

        log.info("##################### SIGN IN FOR EMPLOYEE DATA");
        return ResponseEntity.ok(employeeService.signIn(empEmailId, empPassword));
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId) {

        log.info("##################### GET EMPLOYEE DATA BY ID");
        return ResponseEntity.ok(employeeService.getDataById(empId));
    }

    @GetMapping("/getdatabyname/{empName}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName) {

        log.info("##################### GET EMPLOYEE DATA BY NAME");
        return ResponseEntity.ok(employeeService.getDataByName(empName));
    }

    @GetMapping("/getdatabyemailid/{empEmailId}")
    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String empEmailId) {

        log.info("##################### GET EMPLOYEE DATA BY EMAIL ID");
        return ResponseEntity.ok(employeeService.getDataByEmailId(empEmailId));
    }

    @GetMapping("/getdatabyphonenum/{empPhoneNum}")
    public ResponseEntity<Employee> getDataByPhoneNum(@PathVariable long empPhoneNum) {

        log.info("##################### GET EMPLOYEE DATA BY PHONE NUMBER");
        return ResponseEntity.ok(employeeService.getDataByPhoneNum(empPhoneNum));
    }

    @GetMapping("/getdatabyusinganyinput/{input}")
    public ResponseEntity<List<Employee>> getDataByUsingAnyInput(@PathVariable String input) {

        log.info("##################### GET EMPLOYEE DATA BY USING ANY INPUT");
        return ResponseEntity.ok(employeeService.getDataByUsingAnyInput(input));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData() {

        log.info("##################### GET EMPLOYEE'S ALL DATA");
        return ResponseEntity.ok(employeeService.getAllData());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName() {

        log.info("##################### SORT EMPLOYEE DATA BY NAME");
        return ResponseEntity.ok(employeeService.sortByName());
    }

    @GetMapping("/sortbyid")
    public ResponseEntity<List<Employee>> sortById() {

        log.info("##################### SORT EMPLOYEE DATA BY ID");
        return ResponseEntity.ok(employeeService.sortById());
    }

    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortBySalary() {

        log.info("##################### SORT EMPLOYEE DATA BY SALARY");
        return ResponseEntity.ok(employeeService.sortBySalary());
    }

    @GetMapping("/sortbyage")
    public ResponseEntity<List<Employee>> sortByAge() {

        log.info("##################### SORT EMPLOYEE DATA BY AGE");
        return ResponseEntity.ok(employeeService.sortByAge());
    }

    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>> sortByDOB() {

        log.info("##################### SORT EMPLOYEE DATA BY DOB");
        return ResponseEntity.ok(employeeService.sortByDOB());
    }

    @GetMapping("/filterdatabysalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterDataBySalary(@PathVariable double empSalary) {

        log.info("##################### FILTER EMPLOYEE DATA BY SALARY");
        return ResponseEntity.ok(employeeService.filterDataBySalary(empSalary));
    }

    @GetMapping("/iseligibleforloan/{empId}")
    public ResponseEntity<String> isEligibleForLoan(@PathVariable int empId) {

        log.info("##################### TRYING TO CHECK THAT EMPLOYEE IS ELIGIBLE FOR LOAN OR NOT");
        String msg = null;

        if(employeeService.isEligibleForLoan(empId)){
            msg = "YES! Eligible For Loan";
        } else{
            msg = "Not Eligible For Loan!!!";
        }

        return ResponseEntity.ok(msg);
    }

    @PutMapping("/updatedatabyid/{empId}")
    public ResponseEntity<Employee> updateDataById(@RequestBody Employee employee, @PathVariable int empId) {

        log.info("##################### UPDATE EMPLOYEE DATA BY ID");

        Employee employee1 = employeeService.getDataById(empId).orElseThrow(()-> new RecordNotFoundException("USER ID NOT FOUND!!!"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpAge(employee.getEmpAge());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpPhoneNum(employee.getEmpPhoneNum());
        employee1.setEmpEmailId(employee.getEmpEmailId());

        return ResponseEntity.ok(employeeService.updateDataById(employee1));
    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId) {

        log.info("##################### DELETE EMPLOYEE DATA BY ID");

        employeeService.deleteDataById(empId);
        return ResponseEntity.ok("DATA DELETED SUCCESSFULLY");
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData() {

        log.info("##################### DELETE EMPLOYEE'S ALL DATA");

        employeeService.deleteAllData();
        return ResponseEntity.ok("DATA DELETED SUCCESSFULLY");
    }
}
