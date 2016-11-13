package com.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.test.action.BaseAction;
import com.test.action.LoginAction;
import com.test.entity.Employee;

/**
 * Created by 95 on 2016/11/13.
 */
public class LoginInterceptor implements Interceptor{
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        BaseAction action = (BaseAction) actionInvocation.getAction();
        if(action instanceof LoginAction){
            return actionInvocation.invoke();
        }else {
            Employee existEmployee = (Employee) actionInvocation.getInvocationContext().getSession().get("existEmployee");
            if(existEmployee == null){
                return "login";
            }else {
                return actionInvocation.invoke();
            }
        }
    }
}
