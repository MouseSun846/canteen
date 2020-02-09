package com.hdu.canteen.enums;

import lombok.Getter;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/9 19:08
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
