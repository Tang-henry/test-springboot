package org.getech.henry.test;

import cn.getech.poros.framework.common.api.IResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Demo@getech.cn
 * @date 2020/3/17
 */
@Getter
@AllArgsConstructor
public enum AuthCode implements IResultCode {

    PASSWORD_IS_ERROR(10001,"密码错误"),
    USER_NOT_FOUND(10002,"用户没有找到");

    private int code;

    private String msg;
}
