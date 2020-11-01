package cn.iocoder.springboot.lab23.springmvc.vo;

/**
 * @ClassName : UserVO
 * @Description :
 * @Author : wangyan
 * @Date: 2020-10-08 16:35
 */
/**
 * 用户 VO
 */
public class UserVO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;

    public Integer getId() {
        return id;
    }

    public UserVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserVO setUsername(String username) {
        this.username = username;
        return this;
    }

}
