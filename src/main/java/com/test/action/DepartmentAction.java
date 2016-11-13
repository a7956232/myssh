package com.test.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.entity.Department;
import com.test.entity.PageBean;
import com.test.service.DepartmentService;
import com.test.util.ActionUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 95 on 2016/10/12.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{

//    private Integer currPage = 1;
//
//    public void setCurrPage(Integer currPage) {
//        this.currPage = currPage;
//    }

    @Resource
    private DepartmentService departmentService;

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
        departmentService.saveEntity(model);
        ActionUtil.setUrl("/department_list.action");
        return ActionUtil.REDIRECT;
    }

//    public String addShow(){
//        return "addShow";
//    }

    public String edit(){
        model = departmentService.getEntity(model.getDid());
        return SUCCESS;
    }

    public String update(){
        departmentService.updateEntity(model);
        ActionUtil.setUrl("/department_list.action");
        return ActionUtil.REDIRECT;
    }

    public String delete(){
        model = departmentService.getEntity(model.getDid());
        departmentService.deleteEntity(model);
        ActionUtil.setUrl("/department_list.action");
        return ActionUtil.REDIRECT;
    }
}
