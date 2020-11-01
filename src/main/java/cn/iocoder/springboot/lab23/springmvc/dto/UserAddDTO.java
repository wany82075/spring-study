package cn.iocoder.springboot.lab23.springmvc.dto;

/**
 * @ClassName : UserAddDTO
 * @Description :
 * @Author : wangyan
 * @Date: 2020-10-08 16:37
 */
public class UserAddDTO {

    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public UserAddDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAddDTO setPassword(String password) {
        this.password = password;
        return this;
    }

}
