package com.lanou3g.yesterday.two;

import com.lanou3g.yesterday.one.DatabaseUtil;

public class OperateDbImpl<T> implements OperateDB<T>{

    @Override
    public T operate(T t) {
        DatabaseUtil<T> dbu =new DatabaseUtil<>();
        return null;
    }
}
