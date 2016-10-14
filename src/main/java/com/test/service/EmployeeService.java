package com.test.service;

import com.test.entity.Employee;
import com.test.entity.PageBean;

/**
 * Created by 95 on 2016/10/12.
 */
public interface EmployeeService {

    Employee login(Employee employee);

    PageBean<Employee> findByPage(Integer currPage);

    void add(Employee employee);

    Employee findById(Integer eid);

    void delete(Employee employee);

    void update(Employee employee);
}
