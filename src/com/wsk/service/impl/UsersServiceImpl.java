package com.wsk.service.impl;

import com.wsk.mapper.UsersMapper;
import com.wsk.pojo.Users;
import com.wsk.service.UsersService;
import com.wsk.utils.MybatisUtils;
import jdk.nashorn.internal.runtime.ECMAException;
import org.apache.ibatis.session.SqlSession;

public class UsersServiceImpl implements UsersService {
    @Override
    public void addUsers(Users users) {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            System.out.println(users);
            usersMapper.insertSelective(users);


    }
}
