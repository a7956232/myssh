package com.test.action;

import com.test.entity.Employee;
import com.test.service.EmployeeService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by 95 on 2016/11/13.
 */
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<Employee> implements SessionAware{
    @Resource
    private EmployeeService employeeService;

    private Map<String, Object> sessionMap;

    public String login(){
        return SUCCESS;
    }

    public String user(){
        return SUCCESS;
    }

    public void validateUser(){
        Employee existEmployee = employeeService.validateLoginInfo(model.getUsername(),model.getPassword());
        if(existEmployee == null){
            this.addActionError("用户名或密码错误！");
        }else{
            sessionMap.put("existEmployee",existEmployee);
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap = map;
    }
}
