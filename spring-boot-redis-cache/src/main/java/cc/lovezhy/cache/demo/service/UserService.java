package cc.lovezhy.cache.demo.service;

import cc.lovezhy.cache.demo.entity.User;
import cc.lovezhy.cache.demo.mapper.UserMapper;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.lang.annotation.Repeatable;

@Service
//方法级别的的配置，比如cacheNames，还是比较鸡肋
//@CacheConfig(cacheNames = "user")
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * @Cacheable SPEL不能取到result
     */
    @Cacheable(cacheNames = "user", key = "#id")
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @CachePut(cacheNames = "user", key = "#user.id")
    public User updateById(Integer id, User user) {
        return userMapper.updateById(id, user);
    }

    @CacheEvict(cacheNames = "user", key = "#id")
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    @CacheEvict(cacheNames = "user", allEntries = true)
    public void clearCache() {
    }

    /**
     * 多重组合规则的指定
     * 如果有CachePut,即使有Cacheable，还是会执行
     * 感觉规则不太好掌握
     */
    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "user", key = "#name")
            },
            put = {
                    @CachePut(cacheNames = "user", key = "#result.id")
            }
    )
    public User getUserByName(String name) {
        return userMapper.selectByName(name);
    }
}
