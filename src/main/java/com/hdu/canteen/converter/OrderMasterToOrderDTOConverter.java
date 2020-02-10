package com.hdu.canteen.converter;

import com.hdu.canteen.dataobject.OrderMaster;
import com.hdu.canteen.dataobject.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/10 17:32
 */
public class OrderMasterToOrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e -> convert(e))
                .collect(Collectors.toList());
    }
}
