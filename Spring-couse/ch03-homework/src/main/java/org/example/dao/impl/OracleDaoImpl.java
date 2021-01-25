package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.domin.SysUser;
import org.springframework.stereotype.Repository;

@Repository("OracleDao")
public class OracleDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("这是Oracle的插入值方法");
    }
}
