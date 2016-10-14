package com.test.service.impl;

import com.test.dao.DepartmentDao;
import com.test.entity.Department;
import com.test.entity.PageBean;
import com.test.service.DepartmentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public PageBean<Department> findByPage(Integer currPage) {
        PageBean<Department> pageBean = new PageBean<Department>();
        pageBean.setCurrPage(currPage);
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        double tc = totalCount;
        Double num = Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        int begin = (currPage - 1)*pageSize;
        List<Department> list = departmentDao.findByPage(begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void add(Department department) {
        departmentDao.add(department);
    }

    @Override
    public Department findById(Integer did) {
        return departmentDao.findById(did);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public void delete(Department department) {
        departmentDao.delete(department);
    }

    @Override
    public List findAll() {
        return departmentDao.findAll();
    }
}
