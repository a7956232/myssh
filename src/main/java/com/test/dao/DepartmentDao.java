package com.test.dao;

import com.test.entity.Department;

import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
public interface DepartmentDao {
    int findCount();

    List<Department> findByPage(int begin, int pageSize);

    void add(Department department);

    Department findById(Integer did);

    void update(Department department);

    void delete(Department department);

    List<Object> findAll();
}
