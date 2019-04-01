package cc.lovezhy.cache.demo.mapper;

import cc.lovezhy.cache.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select({
            "SELECT id, name, password, role FROM user WHERE id = #{id}"
    })
    User selectById(Integer id);

}
