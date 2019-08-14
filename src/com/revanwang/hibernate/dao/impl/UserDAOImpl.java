package com.revanwang.hibernate.dao.impl;

import com.revanwang.hibernate.dao.IUserDAO;
import com.revanwang.hibernate.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDAOImpl implements IUserDAO {
    @Override
    public void save(User user) {
        //1、创建配置对象
        Configuration cfg = new Configuration();
        //2、读取配置文件
        cfg.configure("/hibernate.cfg.xml");
        //3、创建SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();
        //4、获取session
        Session session = sf.openSession();
        //============事务操作
        //5、设置事务为活动状态
        Transaction ts = session.getTransaction();
        ts.begin();
        //5、具体的操作
        session.save(user);
        //提交事务
        ts.commit();
        //6、关闭session
        session.close();
        //7、关闭sessionFactory
        sf.close();
    }

    @Override
    public void update(User user) {
        Configuration cfg = new Configuration();
        cfg.configure("/hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.getTransaction();
        ts.begin();
        session.update(user);
        ts.commit();
        session.close();
        sf.close();

    }

    @Override
    public void delete(User user) {
        Configuration cfg = new Configuration();
        cfg.configure("/hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.getTransaction();
        ts.begin();
        session.delete(user);
        ts.commit();
        session.close();
        sf.close();
    }

    @Override
    public User get(Long id) {
        Configuration cfg = new Configuration();
        cfg.configure("/hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    @Override
    public List<User> getList() {
        //1、创建配置对象
        Configuration cfg = new Configuration();
        //2、读取配置文件
        cfg.configure("/hibernate.cfg.xml");
        //3、创建sessionFactory
        SessionFactory sf = cfg.buildSessionFactory();
        //4、获取session
        Session session = sf.openSession();
        //5、查询操作
        String hql = "select u from User u";
        Query query = session.createQuery(hql);
        List<User> list = query.list();
        //6、关闭session
        session.close();
        //7、关闭sessionFactory
        sf.close();
        return list;
    }
}
