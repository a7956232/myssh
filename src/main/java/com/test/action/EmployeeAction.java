package com.test.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.entity.Department;
import com.test.entity.Employee;
import com.test.entity.PageBean;
import com.test.service.DepartmentService;
import com.test.service.EmployeeService;

import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
    private Employee employee = new Employee();
    @Override
    public Employee getModel() {
        return employee;
    }
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    private Integer currPage = 1;

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public String login(){
        Employee existEmployee = employeeService.login(employee);
        if(existEmployee == null){
            this.addActionError("用户名或密码错误！");
            System.out.println("=============="+ActionContext.getContext().getSession());
            return INPUT;
        }else {
            ActionContext.getContext().getSession().put("existEmployee",existEmployee);
            System.out.println("=============="+ActionContext.getContext().getSession());
            return SUCCESS;
        }
    }

    public String findByPage(){
        PageBean<Employee> pageBean = employeeService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findByPage";
    }

    public String findAll(){
        List<Employee> list = employeeService.findAll();
        ActionContext.getContext().getValueStack().set("Elist",list);
        return "findAll";
    }

    public String addShow(){
        //查询所有部门以便下拉菜单显示
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list",list);
        return "addShow";
    }

    public String add(){
        employeeService.add(employee);
        return "addSuccess";
    }

    public String delete(){
        employee = employeeService.findById(employee.getEid());
        employeeService.delete(employee);
        return "deleteSuccess";
    }

    public String edit(){
        employee = employeeService.findById(employee.getEid());
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list",list);
        return "editSuccess";
    }

    public String update(){
        employeeService.update(employee);
        return "updateSuccess";
    }

    public String logout(){
        if(ActionContext.getContext().getSession().get("existEmployee")!=null){
            ActionContext.getContext().getSession().remove("existEmployee");
        }
        return "logout";
    }
}
