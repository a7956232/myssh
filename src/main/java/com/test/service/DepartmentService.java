package com.test.service;

import com.test.entity.Department;
import com.test.entity.PageBean;

import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
public interface DepartmentService {
    PageBean<Department> findByPage(Integer currPage);

    void add(Department department);

    Department findById(Integer did);

    void update(Department department);

    void delete(Department department);

    List<Department> findAll();
}
