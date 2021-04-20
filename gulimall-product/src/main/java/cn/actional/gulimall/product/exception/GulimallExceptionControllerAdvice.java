package cn.actional.gulimall.product.exception;

import cn.actional.common.exception.BizCodeEnum;
import cn.actional.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 *  几种处理所有异常
 * @author actional
 * @email 854356662@qq.com
 * @date 2021/4/20 1:24 PM
 */
@Slf4j
@RestControllerAdvice(basePackages = "cn.actional.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    /**
     *  校验异常处理
     * @param e e
     * @return 异常消息
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}, 异常类型{}", e.getMessage(), e.getClass());
        BindingResult result = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        result.getFieldErrors().forEach(item -> {
            // 获取错误消息
            String message = item.getDefaultMessage();
            // 获取字段名
            String field = item.getField();
            map.put(field, message);
        });
        return R.error(BizCodeEnum.VAILD_EXCEPTION.getCode(), BizCodeEnum.VAILD_EXCEPTION.getMsg()).put("data", map);
    }


    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable t) {
        log.error("错误： ", t);
        return R.error(BizCodeEnum.UNKNOW_EXCEPTION.getCode(), BizCodeEnum.UNKNOW_EXCEPTION.getMsg());
    }

}
