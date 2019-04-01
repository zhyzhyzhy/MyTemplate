package cc.lovezhy.cache.demo.service;

import cc.lovezhy.cache.demo.entity.User;
import cc.lovezhy.cache.demo.mapper.UserMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Cacheable(cacheNames = "user", key = "#id")
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

}
