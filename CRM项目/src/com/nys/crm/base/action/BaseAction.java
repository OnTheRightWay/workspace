package com.nys.crm.base.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
    private T t;
    private Class aClass;

    public BaseAction(){
        //获得继承BaseAction是传入的泛型类型
        ParameterizedType type = (ParameterizedType) this.getClass().getAnnotatedSuperclass();
        //将泛型类型取出来赋值给aClasses
        this.aClass = (Class) type.getActualTypeArguments()[0];
        //给传入的泛型类型创建一个对象
        try {
            this.t= (T) this.aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public T getModel() {
        return t;
    }
}
