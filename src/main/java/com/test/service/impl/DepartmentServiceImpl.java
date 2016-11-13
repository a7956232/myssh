package com.test.service.impl;

import com.test.dao.BaseDao;
import com.test.entity.Department;
import com.test.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService {
    @Override
    @Resource(name = "departmentDao")
    public void setDao(BaseDao<Department> dao) {
        super.setDao(dao);
    }

    @Override
    public List<Department> findAll() {
        String hql = "from Department";
        return this.findEntityByHQL(hql);
    }
}
