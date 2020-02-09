package com.hdu.canteen.services.Impl;

import com.hdu.canteen.SellException;
import com.hdu.canteen.Utils.KeyUtil;
import com.hdu.canteen.dataobject.OrderDetail;
import com.hdu.canteen.dataobject.OrderMaster;
import com.hdu.canteen.dataobject.ProductInfo;
import com.hdu.canteen.dataobject.dto.CartDTO;
import com.hdu.canteen.dataobject.dto.OrderDTO;
import com.hdu.canteen.enums.OrderStatusEnum;
import com.hdu.canteen.enums.PayStatusEnum;
import com.hdu.canteen.enums.ResultEnum;
import com.hdu.canteen.repository.OrderDetailRepository;
import com.hdu.canteen.repository.OrderMasterRepository;
import com.hdu.canteen.services.OrderServices;
import com.hdu.canteen.services.ProductServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/9 20:15
 */
@Service
@Slf4j
public class OrderServicesImpl implements OrderServices {
    @Autowired
    private ProductServices productServices;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.getUniqueKey();
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        /*查询商品(数量，价格)*/
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productServices.findOne(orderDetail.getProductId());
            if (productInfo == null) throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            /*计算总价*/
            orderAmout = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmout);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);
        }
        /*写入订单数据库(orderMaster和orderDetail)*/
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        /*减库存*/
        List<CartDTO> cartDTOList =
                orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productServices.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
