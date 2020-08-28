package com.lagou.test;

import java.util.List;

public interface UserMapper {

    public List<User> findAll();

    public List<User> findByCondition(User user);

    public Integer insert(User user);

    public Integer updateById(User user);

    public Integer deleteById(User user);
}
