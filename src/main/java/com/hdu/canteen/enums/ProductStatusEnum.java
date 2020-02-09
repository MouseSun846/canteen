package com.hdu.canteen.enums;

import lombok.Getter;

/**
 * 商品状态
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/7 18:32
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
