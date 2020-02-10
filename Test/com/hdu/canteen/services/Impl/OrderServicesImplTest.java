package com.hdu.canteen.services.Impl;

import com.hdu.canteen.dataobject.OrderDetail;
import com.hdu.canteen.dataobject.dto.OrderDTO;
import com.hdu.canteen.enums.OrderStatusEnum;
import com.hdu.canteen.enums.PayStatusEnum;
import com.hdu.canteen.services.OrderServices;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServicesImplTest {
    @Autowired
    private OrderServicesImpl orderServices;
    private final String BUYER_OPENID = "110111";
    private final String ORDER_ID = "1581257864689420369";
    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("MouseSun");
        orderDTO.setBuyerAddress("杭电");
        orderDTO.setBuyerPhone("13291658472");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("12345678");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("123456");
        orderDetail1.setProductQuantity(10);
        orderDetailList.add(orderDetail1);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderServices.create(orderDTO);
        log.info("【创建订单】 result = {}",result);
    }

    @Test
    public void findOne() {
        OrderDTO result = orderServices.findOne(ORDER_ID);
        log.info("【查询单个订单】 result = {}",result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderServices.findList(BUYER_OPENID, request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());

    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderServices.findOne(ORDER_ID);
        OrderDTO result = orderServices.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderServices.findOne(ORDER_ID);
        OrderDTO result = orderServices.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISH.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderServices.findOne(ORDER_ID);
        OrderDTO result = orderServices.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }
}