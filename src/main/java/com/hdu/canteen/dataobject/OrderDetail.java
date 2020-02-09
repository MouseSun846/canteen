package com.hdu.canteen.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/9 19:14
 */
@Entity
@Data
@Proxy(lazy = false)
public class OrderDetail {
    @Id
    private String detailId;

    /*订单id*/
    private String orderId;

    /*商品Id*/
    private String productId;

    /*商品名称*/
    private String productName;

    /*商品单价*/
    private BigDecimal productPrice;

    /*商品数量*/
    private Integer productQuantity;

    /*商品小图*/
    private String productIcon;
}
