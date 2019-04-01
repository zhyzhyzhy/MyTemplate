package cc.lovezhy.cache.demo.mapper;

import cc.lovezhy.cache.demo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select({
            "SELECT id, name, password, role FROM user WHERE id = #{id}"
    })
    User selectById(Integer id);


    @Update({
            "UPDATE user SET name = #{user.name}, password = #{user.password}, role = #{user.role} ",
            "WHERE id = #{id}"
    })
    User updateById(Integer id, User user);


    @Delete({
            "DELETE FROM user WHERE id = #{id}"
    })
    int deleteById(Integer id);

    @Select({
            "SELECT id, name, password, role FROM user WHERE name = #{name}"
    })
    User selectByName(String name);
}

