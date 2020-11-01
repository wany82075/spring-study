package cn.iocoder.springboot.lab23.springmvc.core.web;

import cn.iocoder.springboot.lab23.springmvc.vo.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 在 SpringMVC 中，可以使用通过实现 ResponseBodyAdvice 接口，并添加 @ControllerAdvice 接口，拦截 Controller 的返回结果。
 * 注意，我们这里 @ControllerAdvice 注解，设置了 basePackages 属性，只拦截 "cn.iocoder.springboot.lab23.springmvc.controller" 包，也就是我们定义的 Controller 。
 * 为什么呢？因为在项目中，我们可能会引入 Swagger 等库，也使用 Controller 提供 API 接口，那么我们显然不应该让 GlobalResponseBodyHandler 去拦截这些接口，
 * 毕竟它们并不需要我们去替它们做全局统一的返回。
 *
 * @ClassName : GlobalResponseBodyHandler
 * @Description :
 * @Author : wangyan
 * @Date: 2020-10-08 16:56
 */
@ControllerAdvice(basePackages = "cn.iocoder.springboot.lab23.springmvc.controller")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice {

    /**
     * 表示拦截的接口都有哪些
     * 直接返回true表示 所有 API 接口的返回结果。
     *
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * API 接口既然返回结果，被 GlobalResponseBodyHandler 拦截到，约定就是成功返回，
     * 所以使用 CommonResult#success(T data) 方法，进行包装成成功的 CommonResult 返回。那么，如果我们希望 API 接口是失败的返回呢？我们约定在 Controller 抛出异常，
     *
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // 如果已经是 CommonResult 类型，则直接返回
        if (body instanceof CommonResult) {
            return body;
        }
        // 如果不是，则包装成 CommonResult 类型
        return CommonResult.success(body);
    }

}
