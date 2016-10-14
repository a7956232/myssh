package com.test.dao.impl;

import com.test.dao.DepartmentDao;
import com.test.entity.Department;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    @Override
    public int findCount() {
        String hql = "select count(*) from Department";
        List list = this.getHibernateTemplate().find(hql);
        if(list.size()>0){
            return ((Long) list.get(0)).intValue();
        }
        return 0;
    }

    @Override
    public List<Department> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
        List list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
        return list;
    }

    @Override
    public void add(Department department) {
        this.getHibernateTemplate().save(department);
    }

    @Override
    public Department findById(Integer did) {
        return this.getHibernateTemplate().get(Department.class,did);
    }

    @Override
    public void update(Department department) {
        this.getHibernateTemplate().update(department);
    }

    @Override
    public void delete(Department department) {
        this.getHibernateTemplate().delete(department);
    }

    @Override
    public List findAll() {
        return this.getHibernateTemplate().find("from Department");
    }
}
