package com.hdu.canteen.services;

import com.hdu.canteen.dataobject.dto.OrderDTO;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/10 22:13
 */
public interface BuyerService {
    /*查询一个订单*/
    OrderDTO findOrderOne(String openid,String orderId);

    /*取消一个订单*/
    OrderDTO cancelOrder(String openid,String orderId);
}
