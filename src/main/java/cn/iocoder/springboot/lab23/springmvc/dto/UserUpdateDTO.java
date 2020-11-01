package cn.iocoder.springboot.lab23.springmvc.dto;

/**
 * @ClassName : UserUpdateDTO
 * @Description :
 * @Author : wangyan
 * @Date: 2020-10-08 16:38
 */
public class UserUpdateDTO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public Integer getId() {
        return id;
    }

    public UserUpdateDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserUpdateDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserUpdateDTO setPassword(String password) {
        this.password = password;
        return this;
    }

}
