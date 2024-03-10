package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
     EmployeeDaoImpl employeeDao;

    @Override
    public Employee signUp(Employee employee) {
        return employeeDao.signUp(employee);
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        return employeeDao.signIn(empEmailId, empPassword);
    }

    @Override
    public Optional<Employee> getDataById(int empId) {
        return employeeDao.getDataById(empId);
    }

    @Override
    public List<Employee> getDataByName(String empName) {
        return employeeDao.getDataByName(empName);
    }

    @Override
    public Employee getDataByEmailId(String empEmailId) {
        return employeeDao.getDataByEmailId(empEmailId);
    }

    @Override
    public Employee getDataByPhoneNum(long empPhoneNum) {
        return employeeDao.getDataByPhoneNum(empPhoneNum);
    }

    @Override
    public List<Employee> getDataByUsingAnyInput(String input) {
        return employeeDao.getDataByUsingAnyInput(input);
    }

    @Override
    public List<Employee> getAllData() {
        return employeeDao.getAllData();
    }

    @Override
    public List<Employee> sortByName() {
        return employeeDao.sortByName();
    }

    @Override
    public List<Employee> sortById() {
        return employeeDao.sortById();
    }

    @Override
    public List<Employee> sortBySalary() {
        return employeeDao.sortBySalary();
    }

    @Override
    public List<Employee> sortByAge() {
        return employeeDao.sortByAge();
    }

    @Override
    public List<Employee> sortByDOB() {
        return employeeDao.sortByDOB();
    }

    @Override
    public List<Employee> filterDataBySalary(double empSalary) {
        return employeeDao.filterDataBySalary(empSalary);
    }

    @Override
    public boolean isEligibleForLoan(int empId) {
        return employeeDao.isEligibleForLoan(empId);
    }

    @Override
    public Employee updateDataById(Employee employee) {
        return employeeDao.updateDataById(employee);
    }

    @Override
    public void deleteDataById(int empId) {

        employeeDao.deleteDataById(empId);
    }

    @Override
    public void deleteAllData() {

        employeeDao.deleteAllData();
    }
}
