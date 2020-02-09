package com.hdu.canteen.repository;

import com.hdu.canteen.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;
    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("MouseSun");
        orderMaster.setBuyerPhone("13291658473");
        orderMaster.setBuyerAddress("杭州电子科技大学");
        orderMaster.setBuyerOpenid("1102110");
        orderMaster.setOrderAmount(new BigDecimal(3.2));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByBuyerOpenId() {
        Pageable pageable = PageRequest.of(0,2);
        Page<OrderMaster> result = repository.findByBuyerOpenid("110110",pageable);
        Assert.assertNotEquals(0,result.getNumberOfElements());

    }
}