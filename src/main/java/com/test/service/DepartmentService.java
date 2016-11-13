package com.test.service;

import com.test.entity.Department;
import com.test.entity.PageBean;

import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
public interface DepartmentService extends BaseService<Department>{

    List<Department> findAll();
}
