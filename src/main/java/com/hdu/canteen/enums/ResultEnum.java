package com.hdu.canteen.enums;

import lombok.Getter;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/9 20:23
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
