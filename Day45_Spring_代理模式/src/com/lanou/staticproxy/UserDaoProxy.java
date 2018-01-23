package com.lanou.staticproxy;

public class UserDaoProxy  implements UserDao{
    private Transaction transaction;
    //要代理的对象
    //代理对象是经济人，要代理的独享是明星
    //宋喆               宝强
    private UserDao userDao;

    public UserDaoProxy(Transaction transaction, UserDao userDao) {
        this.transaction = transaction;
        this.userDao = userDao;
    }

    @Override
    public void add() {
        transaction.begin();
        userDao.add();
        transaction.commit();

    }

    @Override
    public void delete() {
        transaction.begin();
        userDao.delete();
        transaction.commit();
    }

}
