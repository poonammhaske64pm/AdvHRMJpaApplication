package com.csi.service;

import com.csi.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Employee signUp(Employee employee);

    public boolean signIn(String empEmailId, String empPassword);

    public Optional<Employee> getDataById(int empId);

    public List<Employee> getDataByName(String empName);

    public Employee getDataByEmailId(String empEmailId);

    public Employee getDataByPhoneNum(long empPhoneNum);

    public List<Employee> getDataByUsingAnyInput(String input);

    public List<Employee> getAllData();

    public List<Employee> sortByName();

    public List<Employee> sortById();

    public List<Employee> sortBySalary();

    public List<Employee> sortByAge();

    public List<Employee> sortByDOB();

    public List<Employee> filterDataBySalary(double empSalary);

    public boolean isEligibleForLoan(int empId);

    public Employee  updateDataById(Employee employee);

    public void deleteDataById(int empId);

    public void deleteAllData();
}
