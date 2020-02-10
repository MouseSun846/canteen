package com.hdu.canteen.dataobject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hdu.canteen.Utils.serializer.DateToLongSerializer;
import com.hdu.canteen.enums.OrderStatusEnum;
import com.hdu.canteen.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/9 18:59
 */
@Entity
@Data
@Proxy(lazy = false)
@DynamicUpdate
public class OrderMaster {
    @Id
    /*订单id*/
    private String orderId;

    /*买家名字*/
    private String buyerName;

    /*买家手机号*/
    private String buyerPhone;

    /*买家地址*/
    private String buyerAddress;

    /*买家微信Openid*/
    private String buyerOpenid;

    /*订单总金额*/
    private BigDecimal orderAmount;

    /*订单状态,默认0为新下单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /*支付状态,默认0为未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;
}
