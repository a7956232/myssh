package com.test.service.impl;

import com.test.dao.BaseDao;
import com.test.entity.Employee;
import com.test.service.EmployeeService;
import com.test.util.ValidateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
@Service("employeeService")
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService{
    @Override
    @Resource(name = "employeeDao")
    public void setDao(BaseDao<Employee> dao) {
        super.setDao(dao);
    }


    @Override
    public List<Employee> findAll() {
        String hql = "from Employee";
        return this.findEntityByHQL(hql);
    }

    @Override
    public Employee validateLoginInfo(String username, String password) {
        String hql = "from Employee e where e.username = ? and e.password = ?";
        List<Employee> list = this.findEntityByHQL(hql,username,password);
        return ValidateUtil.isValid(list)?list.get(0):null;
    }
}
