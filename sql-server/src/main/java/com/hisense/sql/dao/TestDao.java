package com.hisense.sql.dao;

import com.github.pagehelper.Page;
import com.hisense.sql.domain.TestPOJO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


import java.util.List;


@Mapper  //这里的Mapper是Mybatis自己定义的注解。
@Service
public interface TestDao {

    //根据age查找info
    List<TestPOJO> get(int age);

    //插入数据

    void insertUser(TestPOJO user);
    //更新数据
    void updateUser(TestPOJO  user);

    //根据userId删除一个用户的数据
    void deletdUserById(String userId);
    //根据userCode删除一个用户的数据
    void deletdUserByCode(String userCode);
    //根据userCode取出一个用户的数据
    TestPOJO getUserByCode(String userCode);
    //根据userId取出一个用户的数据
    TestPOJO getUserById(String userId);

    List<TestPOJO> getUserList();
    //根据参数获得用户数据
    List<TestPOJO> getUsersByage(int age);
    List<TestPOJO> getUsersBymail(String mail);
    List<TestPOJO> getUsersByphone(String phone);
    List<TestPOJO> getUsersByuserCode(String userCode);
}