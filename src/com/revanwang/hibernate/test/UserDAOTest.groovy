package com.revanwang.hibernate.test

import com.revanwang.hibernate.dao.IUserDAO
import com.revanwang.hibernate.dao.impl.UserDAOImpl
import com.revanwang.hibernate.domain.User
import org.junit.Test

class UserDAOTest {

    private IUserDAO userDAO = new UserDAOImpl();

    @Test
    void testSave() {
        User user = new User();
        user.setName("Revan");
        user.setSalary(new BigDecimal(2000));
        user.setHiredate(new Date());
        userDAO.save(user);
    }

    @Test
    void testUpdate() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void testGet() {
        User user = userDAO.get(1L);
        System.out.print(user);

    }

    @Test
    void testGetList() {
        List<User> list = userDAO.getList();
        Iterator<User> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
