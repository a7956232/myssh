package com.test.action;

import com.opensymphony.xwork2.ActionContext;
import com.test.entity.Department;
import com.test.entity.Employee;
import com.test.service.DepartmentService;
import com.test.service.EmployeeService;
import com.test.util.ActionUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
@Controller("employeeAction")
@Scope("prototype")
public class EmployeeAction extends BaseAction<Employee>{

    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepartmentService departmentService;

//    private Integer currPage = 1;
//
//    public void setCurrPage(int currPage) {
//        this.currPage = currPage;
//    }

//    public String findByPage(){
//        PageBean<Employee> pageBean = employeeService.findByPage(currPage);
//        ActionContext.getContext().getValueStack().push(pageBean);
//        return "findByPage";
//    }

    public String list(){
        List<Employee> list = employeeService.findAll();
        ActionContext.getContext().getValueStack().set("Elist",list);
        List<Department> Dlist = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("Dlist",Dlist);
        return SUCCESS;
    }

//    public String addShow(){
//        //查询所有部门以便下拉菜单显示
//        List<Department> list = departmentService.findAll();
//        ActionContext.getContext().getValueStack().set("list",list);
//        return "addShow";
//    }

    public String add(){
        employeeService.saveEntity(model);
        ActionUtil.setUrl("/employee_list.action");
        return ActionUtil.REDIRECT;
    }

    public String delete(){
        model = employeeService.getEntity(model.getEid());
        employeeService.deleteEntity(model);
        ActionUtil.setUrl("/employee_list.action");
        return ActionUtil.REDIRECT;
    }

    public String edit(){
        model = employeeService.getEntity(model.getEid());
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list",list);
        return SUCCESS;
    }

    public String update(){
        employeeService.updateEntity(model);
        ActionUtil.setUrl("/employee_list.action");
        return ActionUtil.REDIRECT;
    }

    public String logout(){
        if(ActionContext.getContext().getSession().get("existEmployee")!=null){
            ActionContext.getContext().getSession().remove("existEmployee");
        }
        return INPUT;
    }

    public String user(){
        return "user";
    }
}
