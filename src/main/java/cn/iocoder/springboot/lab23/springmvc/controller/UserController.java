package cn.iocoder.springboot.lab23.springmvc.controller;

import cn.iocoder.springboot.lab23.springmvc.constants.ServiceExceptionEnum;
import cn.iocoder.springboot.lab23.springmvc.core.exception.ServiceException;
import cn.iocoder.springboot.lab23.springmvc.dto.UserAddDTO;
import cn.iocoder.springboot.lab23.springmvc.dto.UserUpdateDTO;
import cn.iocoder.springboot.lab23.springmvc.vo.CommonResult;
import cn.iocoder.springboot.lab23.springmvc.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : wangyan
 * @Date: 2020-10-08 16:28
 *
 * 一个改进，实际项目中一般不使用@PathVariable参数，主要原因如下：
 * 1、封装的权限框架，基于 URL 作为权限标识，暂时是不支持带有路径参数的 URL 。
 * 2、基于 URL 进行告警，而带有路径参数的 URL ，“相同” URL 实际对应的是不同的 URL ，导致无法很方便的实现按照单位时间请求错误次数告警。
 * 3、@PathVariable 路径参数的 URL ，会带来一定的 SpringMVC 的性能下滑
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("")
    public List<UserVO> list() {
        // 查询列表
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("yudaoyuanma"));
        result.add(new UserVO().setId(2).setUsername("woshiyutou"));
        result.add(new UserVO().setId(3).setUsername("chifanshuijiao"));
        // 返回列表
        return result;
    }

    /**
     * 获得指定用户编号的用户
     *
     * @param id 用户编号
     * @return 用户
     */
//    @GetMapping("/{id}")
//    public UserVO get(@PathVariable("id") Integer id) {
//        // 查询并返回用户
//        return new UserVO().setId(id).setUsername("username:" + id);
//    }

    @GetMapping("/get") // URL 修改成 /get
    public UserVO get(@RequestParam("id") Integer id) {
        // 查询并返回用户
        return new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
    }

    @GetMapping("/get2")
    public CommonResult<UserVO> get2(@RequestParam("id") Integer id) {
        // 查询用户
        UserVO user = new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
        // 返回结果
        return CommonResult.success(user);
    }

    /**
     * 添加用户
     *
     * @param addDTO 添加用户信息 DTO
     * @return 添加成功的用户编号
     */
    @PostMapping("")
    public Integer add(UserAddDTO addDTO) {
        // 插入用户记录，返回编号
        Integer returnId = 1;
        // 返回用户编号
        return returnId;
    }

    /**
     * 更新指定用户编号的用户
     *
     * @param id 用户编号
     * @param updateDTO 更新用户信息 DTO
     * @return 是否修改成功
     */
//    @PutMapping("/{id}")
//    public Boolean update(@PathVariable("id") Integer id, UserUpdateDTO updateDTO) {
//        // 将 id 设置到 updateDTO 中
//        updateDTO.setId(id);
//        // 更新用户记录
//        Boolean success = true;
//        // 返回更新是否成功
//        return success;
//    }

    /**
     * 更新指定用户编号的用户
     *
     * @param updateDTO 更新用户信息 DTO
     * @return 是否修改成功
     */
    @PostMapping("/update") // URL 修改成 /update ，RequestMethod 改成 POST
    public Boolean update(UserUpdateDTO updateDTO) {
        // 更新用户记录
        Boolean success = true;
        // 返回更新是否成功
        return success;
    }

    /**
     * 删除指定用户编号的用户
     *
     * @param id 用户编号
     * @return 是否删除成功
     */
//    @DeleteMapping("/{id}")
//    public Boolean delete(@PathVariable("id") Integer id) {
//        // 删除用户记录
//        Boolean success = false;
//        // 返回是否更新成功
//        return success;
//    }

    @DeleteMapping("/delete") // URL 修改成 /delete ，RequestMethod 改成 DELETE
    public Boolean delete(@RequestParam("id") Integer id) {
        // 删除用户记录
        Boolean success = false;
        // 返回是否更新成功
        return success;
    }

    /**
     * 测试抛出 NullPointerException 异常
     */
    @GetMapping("/exception-01")
    public UserVO exception01() {
        throw new NullPointerException("没有粗面鱼丸");
    }

    /**
     * 测试抛出 ServiceException 异常
     */
    @GetMapping("/exception-02")
    public UserVO exception02() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }

}
