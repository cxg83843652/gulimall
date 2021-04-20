package cn.actional.common.exception;

/**
 * 错误码和错误信息定义类
 * 1。 错误码定义规则为5位数字
 * 2。 前两位表示业务场景，最后三位为错误码。 例如： 10001  10: 通用  001： 系统未知异常
 * 3。 维护错误码后需要维护错误描述，定义为枚举类
 * 错误码列表：
 * 10： 通用
 * 001： 参数格式校验
 * 11： 商品
 * 12： 订单
 * 13： 购物车
 * 14： 物流
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021/4/20 1:38 PM
 */
public enum BizCodeEnum {
    /**
     *
     */
    UNKNOW_EXCEPTION(10000, "系统未知异常"),
    VAILD_EXCEPTION(10001, "参数格式校验失败");

    private final Integer code;
    private final String msg;

    BizCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
