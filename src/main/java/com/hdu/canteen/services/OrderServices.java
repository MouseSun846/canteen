package com.hdu.canteen.services;

import com.hdu.canteen.dataobject.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/9 20:04
 */
public interface OrderServices {
    /*创建订单*/
    OrderDTO create(OrderDTO orderDTO);

    /*查询单个订单*/
    OrderDTO findOne(String orderId);

    /*查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /*取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);

    /*完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /*支付订单*/
    OrderDTO paid(OrderDTO orderDTO);


}
