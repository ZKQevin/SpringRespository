package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.domin.SysUser;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("service")
public class UserServiceImpl implements UserService {
    //应用类型，在xml文件给属性赋值，要求属性有set方法。
    //@Autowired()
    @Resource(name="MysqlDao")
    private UserDao dao=null;



    @Override
    public void addUser(SysUser user) {
        //调用dao的方法
        dao.insertUser(user);
    }

}
