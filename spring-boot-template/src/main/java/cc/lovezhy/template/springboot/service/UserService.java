package cc.lovezhy.template.springboot.service;

import cc.lovezhy.template.springboot.dataobject.UserDO;
import cc.lovezhy.template.springboot.dto.UserDTO;
import cc.lovezhy.template.springboot.repository.UserDOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDOMapper userDOMapper;

    @Autowired
    public UserService(UserDOMapper userDOMapper) {
        this.userDOMapper = userDOMapper;
    }

    public UserDTO createUser(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO, userDO);
        userDOMapper.insert(userDO);

        userDTO.setId(userDO.getId());
        return userDTO;
    }

}
