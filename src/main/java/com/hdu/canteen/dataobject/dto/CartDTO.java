package com.hdu.canteen.dataobject.dto;

import lombok.Data;

/**
 * 购物车
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/9 20:56
 */
@Data
public class CartDTO {
    /*商品Id*/
    private String productId;

    /*商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
