package com.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import java.lang.reflect.ParameterizedType;

/**
 * Created by 95 on 2016/11/13.
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>,Preparable {

    public T model;

    public BaseAction(){
        try {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class clazz = (Class) type.getActualTypeArguments()[0];
            model = (T) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T getModel(){
        return model;
    }

    @Override
    public void prepare() throws Exception {
    }
}
