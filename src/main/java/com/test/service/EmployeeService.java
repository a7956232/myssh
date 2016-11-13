package com.test.service;

import com.test.entity.Employee;
import com.test.entity.PageBean;

import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
public interface EmployeeService extends BaseService<Employee>{

    List<Employee> findAll();

    Employee validateLoginInfo(String username, String password);
}
