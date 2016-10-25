package com.test.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.entity.Department;
import com.test.entity.PageBean;
import com.test.service.DepartmentService;
import com.test.util.ActionUtil;

import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

    private Department department = new Department();
    @Override
    public Department getModel() {
        return department;
    }

    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

//    public String findByPage(){
//        PageBean<Department> pageBean = departmentService.findByPage(currPage);
//        //将pageBean存入到值栈中
//        ActionContext.getContext().getValueStack().push(pageBean);
//        return "findByPage";
//    }

    public String list(){
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("Dlist",list);
        return SUCCESS;
    }

    public String add(){
        departmentService.add(department);
        ActionUtil.setUrl("/department_list.action");
        return ActionUtil.REDIRECT;
    }

//    public String addShow(){
//        return "addShow";
//    }

    public String edit(){
        department = departmentService.findById(department.getDid());
        return SUCCESS;
    }

    public String update(){
        departmentService.update(department);
        ActionUtil.setUrl("/department_list.action");
        return ActionUtil.REDIRECT;
    }

    public String delete(){
        department = departmentService.findById(department.getDid());
        departmentService.delete(department);
        ActionUtil.setUrl("/department_list.action");
        return ActionUtil.REDIRECT;
    }
}
