package com.test.dao.impl;

import com.test.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by 95 on 2016/11/13.
 */
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T>{

    @Resource
    private SessionFactory sf;

    private Class<T> clazz;

    public BaseDaoImpl(){
        //得到泛型化超类
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class) type.getActualTypeArguments()[0];
    }

    @Override
    public void saveEntity(T t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void saveOrUpdateEntity(T t) {
        sf.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public void updateEntity(T t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void deleteEntity(T t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public void batchEntityByHQL(String hql, Object... objects) {
        Query q = sf.getCurrentSession().createQuery(hql);
        for (int i=0;i<objects.length;i++){
            q.setParameter(i,objects[i]);
        }
        q.executeUpdate();
    }

    @Override
    public T loadEntity(Integer id) {
        return (T) sf.getCurrentSession().load(clazz,id);
    }

    @Override
    public T getEntity(Integer id) {
        return (T) sf.getCurrentSession().get(clazz,id);
    }

    @Override
    public List<T> findEntityByHQL(String hql, Object... objects) {
        Query q = sf.getCurrentSession().createQuery(hql);
        for (int i=0;i<objects.length;i++){
            q.setParameter(i,objects[i]);
        }
        return q.list();
    }
}
