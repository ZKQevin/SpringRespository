package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.domin.SysUser;
import org.springframework.stereotype.Repository;

@Repository("MysqlDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("姓名为"+user.name+"年龄为"+user.age+"插入到了mysql数据库");
    }
}
