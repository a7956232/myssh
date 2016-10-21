package com.test.dao.impl;

import com.test.dao.EmployeeDao;
import com.test.entity.Employee;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

    @Override
    public Employee findByUsernameAndPassword(Employee employee) {
        String hql ="from Employee where username = ? and password = ?";
        List<Object> list = this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
        if(list.size()>0){
            return (Employee) list.get(0);
        }
        return null;
    }

    @Override
    public int findCount() {
        String hql = "select count(*) from Employee";
        List list = this.getHibernateTemplate().find(hql);
        if(list.size()>0){
            return ((Long)list.get(0)).intValue();
        }
        return 0;
    }

    @Override
    public List<Employee> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
        List list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
        return list;
    }

    @Override
    public void add(Employee employee) {
        this.getHibernateTemplate().save(employee);
    }

    @Override
    public Employee findById(Integer eid) {
        return this.getHibernateTemplate().get(Employee.class,eid);
    }

    @Override
    public void delete(Employee employee) {
        this.getHibernateTemplate().delete(employee);
    }

    @Override
    public void update(Employee employee) {
        this.getHibernateTemplate().update(employee);
    }

    @Override
    public List findAll() {
        return this.getHibernateTemplate().find("from Employee");
    }
}
