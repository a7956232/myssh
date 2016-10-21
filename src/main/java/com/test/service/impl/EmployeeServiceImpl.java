package com.test.service.impl;

import com.test.dao.EmployeeDao;
import com.test.entity.Employee;
import com.test.entity.PageBean;
import com.test.service.EmployeeService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee login(Employee employee) {
        Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
        return existEmployee;
    }

    @Override
    public PageBean<Employee> findByPage(Integer currPage) {
        PageBean<Employee> pageBean = new PageBean<Employee>();
        pageBean.setCurrPage(currPage);
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        int totalCount = employeeDao.findCount();
        pageBean.setTotalCount(totalCount);
        double tc = totalCount;
        Double num = Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        int begin = (currPage - 1)*pageSize;
        List<Employee> list = employeeDao.findByPage(begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    @Override
    public Employee findById(Integer eid) {
        return employeeDao.findById(eid);
    }

    @Override
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public List findAll() {
        return employeeDao.findAll();
    }
}
