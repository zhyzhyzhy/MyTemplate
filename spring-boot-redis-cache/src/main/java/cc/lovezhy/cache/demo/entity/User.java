package cc.lovezhy.cache.demo.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Byte role;
}
