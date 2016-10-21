package com.test.dao;

import com.test.entity.Employee;

import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
public interface EmployeeDao {

    Employee findByUsernameAndPassword(Employee employee);

    int findCount();

    List<Employee> findByPage(int begin, int pageSize);

    void add(Employee employee);

    Employee findById(Integer eid);

    void delete(Employee employee);

    void update(Employee employee);

    List findAll();
}
