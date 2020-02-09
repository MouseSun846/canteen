package com.hdu.canteen.enums;

import lombok.Getter;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/9 19:04
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"已取消")
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
