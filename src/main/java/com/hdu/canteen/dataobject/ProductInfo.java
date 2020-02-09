package com.hdu.canteen.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/7 16:18
 */
@Entity
@Proxy(lazy = false)
@DynamicUpdate
@Data
public class ProductInfo {
    @Id
    private String productId;
    /*名字*/
    private String productName;
    /*单价*/
    private BigDecimal productPrice;
    /*库存*/
    private Integer productStock;
    /*描述*/
    private String productDescription;
    /*小图*/
    private String productIcon;
    /*状态，0正常 1下架*/
    private Integer productStatus;
    /*类目编号*/
    private Integer categoryType;

}
