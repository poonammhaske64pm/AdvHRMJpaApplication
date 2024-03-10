package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
     EmployeeRepository employeeRepository;


    @Override
    public Employee signUp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {

        boolean flag = false;
        for(Employee employee : employeeRepository.findAll()){

            if(employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)){

                flag = true;
            }
        }
        return flag;
    }

    @Override
    public Optional<Employee> getDataById(int empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public List<Employee> getDataByName(String empName) {
        return employeeRepository.findByEmpName(empName);
    }

    @Override
    public Employee getDataByEmailId(String empEmailId) {
        return employeeRepository.findByEmpEmailId(empEmailId);
    }

    @Override
    public Employee getDataByPhoneNum(long empPhoneNum) {
        return employeeRepository.findByEmpPhoneNum(empPhoneNum);
    }

    @Override
    public List<Employee> getDataByUsingAnyInput(String input) {

        List<Employee> employeeList = new ArrayList<>();

        for(Employee employee : employeeRepository.findAll()){

            if (employee.getEmpName().equals(input)
            || String.valueOf(employee.getEmpSalary()).equals(input)
            || String.valueOf(employee.getEmpAge()).equals(input)
            || employee.getEmpPassword().equals(input)
            || String.valueOf(employee.getEmpPhoneNum()).equals(input)){

                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public List<Employee> getAllData() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> sortByName() {
        return employeeRepository.findAll().stream().sorted((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName())).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortById() {
        return employeeRepository.findAll().stream().sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortBySalary() {
        return employeeRepository.findAll().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByAge() {
        return employeeRepository.findAll().stream().sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByDOB() {
        return employeeRepository.findAll().stream().sorted((e1, e2) -> e1.getEmpDOB().compareTo(e2.getEmpDOB())).collect(Collectors.toList());
    }

    @Override
    public List<Employee> filterDataBySalary(double empSalary) {
        return employeeRepository.findAll().stream().filter(emp -> emp.getEmpSalary() >= 50000).collect(Collectors.toList());
    }

    @Override
    public boolean isEligibleForLoan(int empId) {

        boolean flag = false;

        for(Employee employee : employeeRepository.findAll()){

            if(employee.getEmpId()== empId && employee.getEmpSalary() >= 50000){

                flag = true;
            }
        }
        return flag;
    }

    @Override
    public Employee updateDataById(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteDataById(int empId) {

        employeeRepository.deleteById(empId);
    }

    @Override
    public void deleteAllData() {

        employeeRepository.deleteAll();
    }
}
